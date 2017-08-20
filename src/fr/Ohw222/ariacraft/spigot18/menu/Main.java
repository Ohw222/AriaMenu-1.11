package fr.Ohw222.ariacraft.spigot18.menu;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin implements Listener {
	
public Map<Class<? extends CustomInventory>, CustomInventory > registeredMenus = new HashMap<>();
public boolean MessageChat = true;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("gmenu").setExecutor(this);
		addMenu(new LobbyMenu(this));
		addMenu(new Admin(this));
		addMenu(new Boutique(this));
		addMenu(new Settings(this));
		addMenu(new ServerList(this));
		addMenu(new Lobbys(this));
		addMenu(new Cosm(this));
		addMenu(new UHC(this));
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		saveDefaultConfig();
		setChatSate(ChatState.On);
		MessageChat = true;
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		
		Player player = event.getPlayer();
		ItemStack it = event.getItem();
		
		
		if(it != null && it.getType() == Material.NETHER_STAR){
			
			ItemStack menu = new ItemStack(Material.NETHER_STAR);
			ItemMeta var2 = menu.getItemMeta();
			var2.setDisplayName("§e§kf§5§kf§e§kf§5§kf§r §2Menu §e§kf§5§kf§e§kf§5§kf");
			menu.setItemMeta(var2);
			
			if(it.equals(menu)) {
				
				open(player, LobbyMenu.class);
				
			}
			
		}else {
			if(it != null && it.getType() == Material.COMMAND_MINECART){
			
				ItemStack menu = new ItemStack(Material.COMMAND_MINECART);
				ItemMeta var2 = menu.getItemMeta();
				var2.setDisplayName("§6Settings");
				menu.setItemMeta(var2);
				
				if(it.equals(menu)) {
					
					/*player.sendMessage("§8[§c!§8] §7Menu Settings pas encore codé §e:/");*/
					open(player, Settings.class);
					
				}
			
			}else {
				
				if(it != null && it.getType() == Material.ENDER_CHEST){
					
					ItemStack menu = new ItemStack(Material.ENDER_CHEST);
					ItemMeta var2 = menu.getItemMeta();
					var2.setDisplayName("§9§lCosmétiques");
					menu.setItemMeta(var2);
					
					if(it.equals(menu)) {
						
						open(player, Cosm.class);
						/*open(player, LobbyMenu.class);*/
						
					}
				
				}
				
			}
			
		}
		
	}
	
	public String cs;
	public void setChatSate(ChatState s) {
		cs = s.toString();
	}
	
	public boolean isChatSate(ChatState s) {
		if(s.toString().equalsIgnoreCase(cs)) return true;
		else return false;
	}
	
	public void setMessageChat(boolean b) {
		MessageChat = b;
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if(isChatSate(ChatState.Off)) {
			if(MessageChat) p.sendMessage("§8[§4!§8]§7 Chat désactivé");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event){
	
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();
		ItemStack current = event.getCurrentItem();
		
		if(event.getCurrentItem() == null) return;
		
		registeredMenus.values().stream()
		.filter(menu -> inv.getName().equalsIgnoreCase(menu.name()))
		.forEach(menu -> {
			player.closeInventory();
			menu.onClick(player, inv, current, event.getSlot());
			event.setCancelled(true);
		});
		
	}
	
	public void Guitem(int Position, String name, ItemStack var1, Inventory inv) {
		ItemMeta var2 = var1.getItemMeta();
		var2.setDisplayName(name);
		var1.setItemMeta(var2);
		inv.setItem(Position, var1);
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Inventory i = player.getInventory();
		i.clear();
		Guitem(1, "§9§lCosmétiques", new ItemStack(Material.ENDER_CHEST), i);
		Guitem(4, "§e§kf§5§kf§e§kf§5§kf§r §2Menu §e§kf§5§kf§e§kf§5§kf", new ItemStack(Material.NETHER_STAR), i);
		Guitem(7, "§6Settings", new ItemStack(Material.COMMAND_MINECART), i);
	}

	public void addMenu(CustomInventory m){
		this.registeredMenus.put(m.getClass(), m);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(label.equalsIgnoreCase("gmenu") && sender instanceof Player) {
			
			Inventory i = p.getInventory();
			i.clear();
			Guitem(1, "§9§lCosmétiques", new ItemStack(Material.ENDER_CHEST), i);
			Guitem(4, "§e§kf§5§kf§e§kf§5§kf§r §2Menu §e§kf§5§kf§e§kf§5§kf", new ItemStack(Material.NETHER_STAR), i);
			Guitem(7, "§6Settings", new ItemStack(Material.COMMAND_MINECART), i);
			return true;
		}
		
		return true;
		
	}

	public void open(Player player, Class<? extends CustomInventory> gClass){
		
		if(!this.registeredMenus.containsKey(gClass)) return;

		CustomInventory menu = this.registeredMenus.get(gClass);
		Inventory inv = Bukkit.createInventory(null, menu.getSize(), menu.name());
		menu.contents(player, inv);
		player.openInventory(inv);
		
	}
	
}

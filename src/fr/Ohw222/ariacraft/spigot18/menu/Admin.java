package fr.Ohw222.ariacraft.spigot18.menu;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Admin implements CustomInventory {

	private Main main;

	public Admin(Main main) { this.main = main; }

	@Override
	public String name() {
		return "§7§l> §cAdmin §3Menu";
	}

	public void Guitem(int Position, String name, ItemStack var1, Inventory inv) {
		ItemMeta var2 = var1.getItemMeta();
		var2.setDisplayName(name);
		var1.setItemMeta(var2);
		inv.setItem(Position, var1);
	}


	@Override
	public void contents(Player player, Inventory inv) {
		ItemStack is = new ItemStack(Material.FEATHER);
		ItemMeta var2 = is.getItemMeta();
		var2.setDisplayName("§3Joueurs en ligne §c"+Bukkit.getOnlinePlayers().size()+"§7/§c"+Bukkit.getMaxPlayers());
		is.setItemMeta(var2);
		inv.setItem(1, is);
		Guitem(3, "§cKick§7All", new ItemStack(Material.REDSTONE), inv);
		if(main.isChatSate(ChatState.Off)) Guitem(5, "§7MuteChat", new ItemStack(Material.WEB, 0), inv);
		if(!main.isChatSate(ChatState.Off)) Guitem(5, "§aUn§7MuteChat", new ItemStack(Material.WEB, 1), inv);
		if(main.MessageChat) Guitem(7, "§2Messages Chat §7> §cdésactiver", new ItemStack(Material.BANNER, 1, (short) 10), inv);
		if(!main.MessageChat) Guitem(7, "§2Messages Chat §7> §aactiver", new ItemStack(Material.BANNER, 1, (short) 1), inv);
		Guitem(10, "§cSuper§4Spy", new ItemStack(Material.EYE_OF_ENDER), inv);
		Guitem(12, "§7Activer/Désactiver le §3FLY", new ItemStack(Material.QUARTZ), inv);
		Guitem(14, "§aActiver§7 le §6BUILD", new ItemStack(Material.WOOL, 1, (short) 5), inv);
		Guitem(16, "§cDésactiver§7 le §6BUILD", new ItemStack(Material.REDSTONE_BLOCK), inv);
	}

	@Override
	public void onClick(Player p, Inventory inv, ItemStack current, int slot) {
		switch (current.getType()) {
		case FEATHER:
			p.sendMessage("§3Joueurs : "+Bukkit.getOnlinePlayers()+"\n §3"+Bukkit.getOnlinePlayers().size()+"§7/§3"+Bukkit.getMaxPlayers());
			break;
			
		case REDSTONE:
			for(Player pls : Bukkit.getServer().getOnlinePlayers()) {
				Player pl = pls;
				pl.kickPlayer("§cMAINTENANCE");
			}
			break;
			
		case WEB:
			if(main.isChatSate(ChatState.On)) {
				main.setChatSate(ChatState.Off);
				Bukkit.broadcastMessage("§8[§4!§8]§7 Chat désactivé");
			}else if(main.isChatSate(ChatState.Off)) {
				main.setChatSate(ChatState.On);
				Bukkit.broadcastMessage("§8[§b!§8]§7 Chat réactivé");
			}else {
				main.setChatSate(ChatState.On);
				Bukkit.broadcastMessage("§8[§b!§8]§7 Chat réactivé");
			}
			break;
			
		case BANNER:
			if(main.MessageChat) {
				main.setMessageChat(false);
				Bukkit.broadcastMessage("§8[§b!§8]§7 Messages de chat désactivés");
			}else if(!main.MessageChat) {
				main.setMessageChat(true);
				Bukkit.broadcastMessage("§8[§b!§8]§7 Messages de chat activés");
			}else {
				main.setMessageChat(true);
				Bukkit.broadcastMessage("§8[§b!§8]§7 Messages de chat activés");
			}
			break;
		case REDSTONE_BLOCK:
			p.performCommand("bm n");
			break;
		case WOOL:
			p.performCommand("bm y");
			break;
		case QUARTZ:
			if(p.getAllowFlight()) { p.setAllowFlight(false);p.sendMessage("§8[§b!§8] §3Fly §7désactivé");}
			else { p.setAllowFlight(true);p.sendMessage("§8[§b!§8] §3Fly §7activé");}
		case EYE_OF_ENDER:
			p.performCommand("ss");
			break;
			
		default:
			break;
		}
	}

	@Override
	public int getSize() {
		return 18;
	}

}

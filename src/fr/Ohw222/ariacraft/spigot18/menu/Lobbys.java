package fr.Ohw222.ariacraft.spigot18.menu;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Lobbys implements CustomInventory {
	
	private Main main;

	public Lobbys(Main main) { this.main = main; }

	@Override
	public String name() {
		return "§aAria§2§lCraft §r§7> §cLobbys";
	}
	
	public void Guitem(int Position, String name, ItemStack item, Inventory inv) {
		ItemMeta var2 = item.getItemMeta();
		var2.setDisplayName(name);
		item.setItemMeta(var2);
		inv.setItem(Position, item);
	}
	
	public ItemStack IItems(String name, ItemStack item) {
		ItemMeta var2 = item.getItemMeta();
		var2.setDisplayName(name);
		item.setItemMeta(var2);
		return item;
	}
	
	@Override
	public void contents(Player player, Inventory inv) {
		
		if(main.getConfig().getString("config.numero").equalsIgnoreCase("1")) {
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);
			ItemMeta var2 = item.getItemMeta();
			var2.setDisplayName("§bLobby §c1");
			item.setItemMeta(var2);
			item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			inv.setItem(2, item);
			
			Guitem(4, "§bLobby §c2", new ItemStack(Material.ENDER_PEARL), inv);
			
			Guitem(6, "§bLobby §c3", new ItemStack(Material.ENDER_PEARL), inv);
			
		}
		if(main.getConfig().getString("config.numero").equalsIgnoreCase("2")) {
			
			Guitem(2, "§bLobby §c1", new ItemStack(Material.ENDER_PEARL), inv);
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);
			ItemMeta var2 = item.getItemMeta();
			var2.setDisplayName("§bLobby §c2");
			item.setItemMeta(var2);
			item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			inv.setItem(4, item);
			
			Guitem(6, "§bLobby §c3", new ItemStack(Material.ENDER_PEARL), inv);
			
		}
		if(main.getConfig().getString("config.numero").equalsIgnoreCase("3")) {
			
			Guitem(2, "§bLobby §c1", new ItemStack(Material.ENDER_PEARL), inv);
			
			Guitem(4, "§bLobby §c2", new ItemStack(Material.ENDER_PEARL), inv);
			
			ItemStack item = new ItemStack(Material.ENDER_PEARL);
			ItemMeta var2 = item.getItemMeta();
			var2.setDisplayName("§bLobby §c3");
			item.setItemMeta(var2);
			item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			inv.setItem(6, item);
			
		}
		
	}
	
	
	
	@Override
	public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
		
		switch(current.getType()){
		
			
			/*case APPLE:
				main.open(player, GadgetsMenu.class);
			break;*/
			case ENDER_PEARL:
				ItemStack lobby1 = new ItemStack(Material.ENDER_PEARL);
				ItemMeta lobby1m = lobby1.getItemMeta();
				lobby1m.setDisplayName("§bLobby §c1");
				lobby1.setItemMeta(lobby1m);
				lobby1.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);

				ItemStack lobby2 = new ItemStack(Material.ENDER_PEARL);
				ItemMeta lobby2m = lobby2.getItemMeta();
				lobby2m.setDisplayName("§bLobby §c2");
				lobby2.setItemMeta(lobby2m);
				lobby2.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);

				ItemStack lobby3 = new ItemStack(Material.ENDER_PEARL);
				ItemMeta lobby3m = lobby3.getItemMeta();
				lobby3m.setDisplayName("§bLobby §c3");
				lobby3.setItemMeta(lobby3m);
				lobby3.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
				
				
				if(current.equals(lobby1)) {
					
					player.sendMessage("\n§8[§4!§8]§7 Vous êtes déjà sur ce serveur\n");
					
				}else {
					
					if(current.equals(lobby2)) {
						
						player.sendMessage("\n§8[§4!§8]§7 Vous êtes déjà sur ce serveur\n");
						
					}else {
						
						if(current.equals(lobby3)) {
							
							player.sendMessage("\n§8[§4!§8]§7 Vous êtes déjà sur ce serveur\n");
							
						}else {
							
							if(current.equals(IItems("§bLobby §c2", new ItemStack(Material.ENDER_PEARL)))) {
								
								ByteArrayOutputStream b = new ByteArrayOutputStream();
								DataOutputStream out = new DataOutputStream(b);
								try {out.writeUTF("Connect");out.writeUTF("lobby2");}
								catch(IOException e){e.printStackTrace();}
								player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
								
							}else {
								
								if(current.equals(IItems("§bLobby §c3", new ItemStack(Material.ENDER_PEARL)))) {
									ByteArrayOutputStream b = new ByteArrayOutputStream();
									DataOutputStream out = new DataOutputStream(b);
									try {out.writeUTF("Connect");out.writeUTF("lobby3");}
									catch(IOException e){e.printStackTrace();}
									player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
									
								}else {
									
									if(current.equals(IItems("§bLobby §c1", new ItemStack(Material.ENDER_PEARL)))) {
										ByteArrayOutputStream b = new ByteArrayOutputStream();
										DataOutputStream out = new DataOutputStream(b);
										try {out.writeUTF("Connect");out.writeUTF("lobby1");}
										catch(IOException e){e.printStackTrace();}
										player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
		
			default:
				break;
				
		}
		
	}

	@Override
	public int getSize() {
		return 9;
	}

}

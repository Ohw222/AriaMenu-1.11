package fr.Ohw222.ariacraft.spigot18.menu;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerList implements CustomInventory {
	
	private Main main;

	public ServerList(Main main) { this.main = main; }

	@Override
	public String name() {
		return "§aAria§2§lCraft §r§7> §cServeurs";
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
		
		Guitem(0, "§bLobby §c1", new ItemStack(Material.ENDER_PEARL), inv);
		Guitem(1, "§bLobby §c2", new ItemStack(Material.ENDER_PEARL), inv);
		Guitem(2, "§bLobby §c3", new ItemStack(Material.ENDER_PEARL), inv);
		
		Guitem(3, "§6Mini Jeux", new ItemStack(Material.STAINED_GLASS, 1, (short) 1), inv);
		
		Guitem(2, "§aWallsBattle", new ItemStack(Material.SANDSTONE), inv);
		
	}
	
	
	
	@Override
	public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
		
		switch(current.getType()){
		
			case STAINED_GLASS_PANE:
			break;
			
			/*case APPLE:
				main.open(player, GadgetsMenu.class);
			break;*/
			case ENDER_PEARL:
				if(slot == 0) {
					ByteArrayOutputStream b = new ByteArrayOutputStream();
					DataOutputStream out = new DataOutputStream(b);
					try {out.writeUTF("Connect");out.writeUTF("lobby1");}
					catch(IOException e){e.printStackTrace();}
					player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
				}else {
					if(slot == 1) {
						ByteArrayOutputStream b = new ByteArrayOutputStream();
						DataOutputStream out = new DataOutputStream(b);
						try {out.writeUTF("Connect");out.writeUTF("lobby2");}
						catch(IOException e){e.printStackTrace();}
						player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
					}else {
						if(slot == 2) {
							ByteArrayOutputStream b = new ByteArrayOutputStream();
							DataOutputStream out = new DataOutputStream(b);
							try {out.writeUTF("Connect");out.writeUTF("lobby3");}
							catch(IOException e){e.printStackTrace();}
							player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
						}else {
							
						}
					}
				}
				
		
			default:
				player.sendMessage("§8[§4!§8] §7La flemme de coder ça :D");
				break;
				
		}
		
	}

	@Override
	public int getSize() {
		return 27;
	}

}

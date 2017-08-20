package fr.Ohw222.ariacraft.spigot18.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cosm implements CustomInventory {
	
	@SuppressWarnings("unused")
	private Main main;

	public Cosm(Main main) { this.main = main; }

	@Override
	public String name() {
		return "§aAria§2§lCraft §r§7> §9Cosm";
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
		
		Guitem(2, "§6Particules", new ItemStack(Material.BLAZE_POWDER), inv);
		Guitem(6, "§7Pets", new ItemStack(Material.BONE), inv);
		
	}
	
	
	
	@Override
	public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
		
		switch(current.getType()){
		
			case BLAZE_POWDER:
				player.performCommand("trails");
				break;
			
			/*case APPLE:
				main.open(player, GadgetsMenu.class);
			break;*/
			case BONE:
				player.performCommand("headpets GUI");
				break;
				
		
			default:
				break;
				
		}
		
	}

	@Override
	public int getSize() {
		return 9;
	}

}

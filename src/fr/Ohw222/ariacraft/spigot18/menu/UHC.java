package fr.Ohw222.ariacraft.spigot18.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UHC implements CustomInventory {

	public UHC(Main main) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		return "§6UHC§7 - §cPvP §3Menu";
	}

	public void Guitem(int Position, String name, ItemStack var1, Inventory inv) {
		ItemMeta var2 = var1.getItemMeta();
		var2.setDisplayName(name);
		var1.setItemMeta(var2);
		inv.setItem(Position, var1);
	}

	@Override
	public void contents(Player player, Inventory inv) {
		Guitem(1, "§6UHC Classico", new ItemStack(Material.GOLDEN_APPLE), inv);
		Guitem(3, "§cPvP Box", new ItemStack(Material.MOB_SPAWNER), inv);
		Guitem(5, "§eSpeed UHGame", new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1), inv);
		Guitem(7, "§3Arene FFA", new ItemStack(Material.DIAMOND_SWORD), inv);

	}

	@Override
	public void onClick(Player p, Inventory inv, ItemStack current, int slot) {
		switch (current.getType()) {
		case GOLDEN_APPLE:
			p.sendMessage("§8[§4!§8]§7 Ce jeu n'est pas encore disponible, veuillez nous excuser du dérangement.");
			break;
			
		case MOB_SPAWNER:
			p.sendMessage("§8[§4!§8]§7 Ce jeu n'est pas encore disponible, veuillez nous excuser du dérangement.");
			break;
			
		case DIAMOND_SWORD:
			p.sendMessage("§8[§4!§8]§7 Ce jeu n'est pas encore disponible, veuillez nous excuser du dérangement.");
			break;

		default:
			break;
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 9;
	}

}

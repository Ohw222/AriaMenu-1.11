package fr.Ohw222.ariacraft.spigot18.menu;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Boutique implements CustomInventory {
	
	private Main main;

	public Boutique(Main main) { this.main = main; }

	@Override
	public String name() {
		return "§aAria§2§lCraft §r§7> §6Boutique";
	}

	@SuppressWarnings("deprecation")
	@Override
	public void contents(Player player, Inventory inv) {
		
		ItemStack i = new ItemStack(Material.PAPER);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName("§cEN DEVELOPPEMENT");
		i.setItemMeta(meta);
		
		inv.setItem(22, i);
		
		
		//contour
		//Item Contour
		ItemStack c = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta cm = c.getItemMeta();
		cm.setDisplayName("§0.");
		MaterialData cd = c.getData();
		cd.setData((byte) 8);
		//boucles contour
		int a = 0, b = 8;
		while(a < b || a == b){
		inv.setItem(a, c);
		a++;
		}
		
		int d = 9, e = 36;
		while(d < e || d == e){
		inv.setItem(d, c);
		d = d+8;
		inv.setItem(d, c);
		d++;
		}
		int f = 45, g = 54;
		while(f < g || a == b){
		inv.setItem(f, c);
		f++;
		}
		
	}

	@Override
	public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
		
		switch(current.getType()){
		
			case STAINED_GLASS_PANE:
			break;
			
			/*case APPLE:
				main.open(player, GadgetsMenu.class);
			break;*/
			case GOLD_INGOT:
				main.open(player, Boutique.class);
		
			default:
				break;
				
		}
		
	}

	@Override
	public int getSize() {
		return 54;
	}

	
}


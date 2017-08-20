package fr.Ohw222.ariacraft.spigot18.menu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Settings implements CustomInventory {
	
	private ArrayList<Player> hiders = new ArrayList<Player>();
	
	@SuppressWarnings("unused")
	private Main main;

	public Settings(Main main2) {
		this.main = main2;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(hiders.contains(p)) {
			for(Player pls : Bukkit.getOnlinePlayers()) {
				p.showPlayer(pls);
			}
		}
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
	public String name() {
		return "§aAria§2§lCraft §r§7> §4Settings";
	}
	

	public void contents(Player player, Inventory inv) {
		//contour
		//Item Contour
		ItemStack c = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta cm = c.getItemMeta();
		cm.setDisplayName("§0.");
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
		
		Guitem(11, "§2Speed Normal", new ItemStack(Material.INK_SACK, 1, (short) 2), inv);
		Guitem(13, "§6Speed Moyen", new ItemStack(Material.INK_SACK, 1, (short) 14), inv);
		Guitem(15, "§6Speed Rapide", new ItemStack(Material.INK_SACK, 1, (short) 1), inv);
		if(hiders.contains(player)) {
			
			Guitem(21, "§7Montrer les joueurs", new ItemStack(Material.INK_SACK, 1, (short) 8), inv);
			
		}else {
			
			Guitem(21, "§aCacher les joueurs", new ItemStack(Material.INK_SACK, 1, (short) 10), inv);
			
		}
		Guitem(23, "§6Changer d'heure", new ItemStack(Material.GOLD_BLOCK), inv);
		Guitem(29, "§5Liste des serveurs", new ItemStack(Material.ENCHANTED_BOOK), inv);
		Guitem(31, "§3Changer de Lobby", new ItemStack(Material.ENDER_PEARL), inv);
		Guitem(33, "§9Cosmétiques", new ItemStack(Material.ENDER_CHEST), inv);
		Guitem(39, "§cHelp", new ItemStack(Material.BOOK), inv);
		Guitem(41, "§7Feedback", new ItemStack(Material.SLIME_BALL), inv);
	}

	@Override
	public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
		switch(current.getType()){
		
		case INK_SACK:
			if(current.equals(IItems("§6Speed Rapide", new ItemStack(Material.INK_SACK, 1, (short) 1)))) {
				player.setWalkSpeed((float) 1);
				break;
			} else {
				if(current.equals(IItems("§6Speed Moyen", new ItemStack(Material.INK_SACK, 1, (short) 14)))) {
					player.setWalkSpeed((float) 0.6);
					break;
				} else {
					if(current.equals(IItems("§2Speed Normal", new ItemStack(Material.INK_SACK, 1, (short) 2)))) {
						player.setWalkSpeed((float) 0.3);
						break;
					}else {
						if(current.equals(IItems("§aCacher les joueurs", new ItemStack(Material.INK_SACK, 1, (short) 10)))) {
							if(!hiders.contains(player)) {
								for(Player pls : Bukkit.getOnlinePlayers()) {
									if(player != pls) {
										player.hidePlayer(pls);
									}
								}
								hiders.add(player);
								player.sendMessage("\n§8[§b!§8]§7 Joueurs cachés avec succès !\n");
								Guitem(21, "§7Montrer les joueurs", new ItemStack(Material.INK_SACK, 1, (short) 8), inv);
							}
						}else {
							if(current.equals(IItems("§7Montrer les joueurs", new ItemStack(Material.INK_SACK, 1, (short) 8)))) {
								if(hiders.contains(player)) {
									for(Player pls : Bukkit.getOnlinePlayers()) {
										player.showPlayer(pls);
									}
									hiders.remove(player);
									player.sendMessage("\n§8[§b!§8]§7 Joueurs affichés avec succès !\n");
									Guitem(21, "§aCacher les joueurs", new ItemStack(Material.INK_SACK, 1, (short) 10), inv);
								}
							}
						}
					}
				}
			}
		
			
		case GOLD_BLOCK:
			if(current.equals(IItems("§6Changer d'heure", new ItemStack(Material.GOLD_BLOCK))))
			if(player.hasPermission("ariacraft.vip")) {
				player.sendMessage("§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+\n§4 §c \n §4 §3» §bFonctionalité pas encore codée....\n  §c  \n  §3■ §7§oDSL bro :/ \n §c \n§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+");
				break;
			}else {
				player.sendMessage("§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+\n§4 §c \n §4 §3» §bPas encore de grade ?!\n  §c  \n  §3■ §bAlors devenez un §eVIP §7[§8✯§7] !!!\n  §7[§3?§7] §7§oPsst, c'est par là : [§f§ohttp://boutique.ariacraft.net§7§o]\n §c \n§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+");
				break;
			}
			
		case SLIME_BALL:
			if(current.equals(IItems("§7Feedback", new ItemStack(Material.SLIME_BALL)))) {
				player.sendMessage("§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+\n§4 §c \n §4 §3» §bUn retour à nous faire ?!\n  §c  \n  §3■ §bEnvoyez-nous un §9Feedback §7[§8✯§7] !!!\n  §7[§3?§7] §7§oCa se passe par là : [§f§ohttp://feedback.ariacraft.net§7§o]\n §c \n§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+");
				break;
			}
			
		case BOOK:
			if(current.equals(IItems("§cHelp", new ItemStack(Material.BOOK)))) {
				player.sendMessage("§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+\n§4 §c \n §4 §3» §bBesoin d'aide ?!\n  §c  \n  §3■ §bLe §2Forum§b sert à ça ! §7[§8✯§7] !!!\n  §7[§3?§7] §7§oPour y aller, c'est là : [§f§ohttp://forum.ariacraft.net§7§o]\n §c \n§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+");
				break;
			}
			
		case ENCHANTED_BOOK:
			if(current.equals(IItems("§5Liste des serveurs", new ItemStack(Material.ENCHANTED_BOOK)))) {
				main.open(player, ServerList.class);
				break;
			}
		
		case ENDER_PEARL:
			if(current.equals(IItems("§3Changer de Lobby", new ItemStack(Material.ENDER_PEARL)))) {
				main.open(player, Lobbys.class);
				break;
			}
			
		case ENDER_CHEST:
			if(current.equals(IItems("§9Cosmétiques", new ItemStack(Material.ENDER_CHEST)))) {
				main.open(player, Cosm.class);
				break;
			}
			
		default:
			break;
			
		}
		
	}

	@Override
	public int getSize() {
		return 54;
	}
	
}

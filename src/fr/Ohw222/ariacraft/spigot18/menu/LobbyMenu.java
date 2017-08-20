package fr.Ohw222.ariacraft.spigot18.menu;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyMenu implements CustomInventory {
	
	private Main main;

	public LobbyMenu(Main main) { this.main = main; }

	@Override
	public String name() {
		return "§aAria§2§lCraft §r§7> §3Menu";
	}

	public void Guitem(int Position, String name, ItemStack var1, Inventory inv) {
		ItemMeta var2 = var1.getItemMeta();
		var2.setDisplayName(name);
		var1.setItemMeta(var2);
		inv.setItem(Position, var1);
	}
	
	@Override
	public void contents(Player player, Inventory inv) {
		
		ItemStack i = new ItemStack(Material.GOLD_INGOT);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName("§6Boutique");
		meta.setLore(Arrays.asList("En developpement"));
		i.setItemMeta(meta);
		
		
		//contour
		//Item Contour
		ItemStack c = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta cm = c.getItemMeta();
		cm.setDisplayName("§0");
		c.setItemMeta(cm);
		//boucles contour
		int a = 0, b = 8;
		while(a < b || a == b){
		inv.setItem(a, c);
		a++;
		}
		
		int d = 9, e = 44;
		while(d < e || d == e){
		inv.setItem(d, c);
		d = d+8;
		inv.setItem(d, c);
		d++;
		}
		
		if(player.isOp()) {
			
			int f = 46, g = 53;
			while(f < g || a == b){
			inv.setItem(f, c);
			f++;
			}
			
			ItemStack gm3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
			ItemMeta gm3m = gm3.getItemMeta();
			gm3m.setDisplayName("§5Gamemode §d3");
			gm3.setItemMeta(gm3m);
			inv.setItem(51, gm3);
			
			ItemStack gm1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta gm1m = gm3.getItemMeta();
			gm1m.setDisplayName("§2Gamemode §a1");
			gm1.setItemMeta(gm1m);
			inv.setItem(49, gm1);
			
			ItemStack gm0 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta gm0m = gm0.getItemMeta();
			gm0m.setDisplayName("§7Gamemode §80");
			gm0.setItemMeta(gm0m);
			inv.setItem(47, gm0);
			
			ItemStack admin = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta adminm = admin.getItemMeta();
			adminm.setDisplayName("§4Administration");
			admin.setItemMeta(adminm);
			inv.setItem(45, admin);
			
			@SuppressWarnings("deprecation") ItemStack supspy = new ItemStack(102, 1);
			ItemMeta supspym = supspy.getItemMeta();
			supspym.setDisplayName("§3Super§bSpy");
			supspy.setItemMeta(supspym);
			inv.setItem(53, supspy);
			
		}else {
			int f = 45, g = 54;
			while(f < g || a == b){
			inv.setItem(f, c);
			f++;
			}
		}
		if(player.hasPermission("ariacraft.vip")) {
			ItemStack vip = new ItemStack(Material.BEACON);
			ItemMeta vipm = vip.getItemMeta();
			vipm.setDisplayName("§2Spawn §6VIP");
			vip.setItemMeta(vipm);
			inv.setItem(12, vip);
			
			ItemStack s = new ItemStack(Material.BED);
			ItemMeta sm = s.getItemMeta();
			sm.setDisplayName("§aSpawn");
			s.setItemMeta(sm);
			inv.setItem(14, s);
		}else {
			ItemStack s = new ItemStack(Material.BED);
			ItemMeta sm = s.getItemMeta();
			sm.setDisplayName("§aSpawn");
			s.setItemMeta(sm);
			inv.setItem(13, s);
		}

		Guitem(16, "§3Liens §bUtiles", new ItemStack(Material.PAPER), inv);
		Guitem(20, "§4Factions", new ItemStack(Material.DIAMOND_SWORD), inv);
		Guitem(22, "§2Créatif", new ItemStack(Material.DIAMOND), inv);
		Guitem(24, "§7Survie", new ItemStack(Material.COMPASS), inv);
		Guitem(29, "§5MiniJeux", new ItemStack(Material.STAINED_GLASS, 1, (short) 1), inv);
		Guitem(31, "§6UHC§7/§cPvP", new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1), inv);
		Guitem(33, "§aSky§2Block", new ItemStack(Material.GRASS), inv);
		Guitem(37, "§6Settings", new ItemStack(Material.COMMAND_MINECART), inv);
		Guitem(39, "§cHelp", new ItemStack(Material.BOOK), inv);
		Guitem(41, "§7Feedback", new ItemStack(Material.SLIME_BALL), inv);
		ItemStack au = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta aum = au.getItemMeta();
		aum.setDisplayName("§c© 2017 §aAria§2§lCraft");
		aum.setLore(Arrays.asList("§cCopyright 2017 §fpour §aAria§2§lCraft§f network","§7§oCodé par §3§oOhw222 §r§7& §3§oMrFroz"));
		au.setItemMeta(aum);
		au.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		inv.setItem(43, au);
		inv.setItem(10, i);
	}
	
	public ItemStack IItems(String name, ItemStack item) {
		ItemMeta var2 = item.getItemMeta();
		var2.setDisplayName(name);
		item.setItemMeta(var2);
		return item;
	}

	@Override
	public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
		
		switch(current.getType()){
		
			case STAINED_GLASS_PANE:
				ItemStack gm3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
				ItemMeta gm3m = gm3.getItemMeta();
				gm3m.setDisplayName("§5Gamemode §d3");
				gm3.setItemMeta(gm3m);
				
				ItemStack gm1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
				ItemMeta gm1m = gm3.getItemMeta();
				gm1m.setDisplayName("§2Gamemode §a1");
				gm1.setItemMeta(gm1m);
				
				ItemStack gm0 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
				ItemMeta gm0m = gm0.getItemMeta();
				gm0m.setDisplayName("§7Gamemode §80");
				gm0.setItemMeta(gm0m);
				
				ItemStack admin = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
				ItemMeta adminm = gm0.getItemMeta();
				adminm.setDisplayName("§4Administration");
				admin.setItemMeta(adminm);
				
				ItemStack supspy = new ItemStack(Material.THIN_GLASS, 1);
				ItemMeta supspym = supspy.getItemMeta();
				supspym.setDisplayName("§3Super§bSpy");
				supspy.setItemMeta(supspym);
				
				if(current.equals(gm3)) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage("\n§8[§b!§8]§7 Vous avez été mis en §5Spectateur§7.");
				}else{
					if(current.equals(gm1)) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage("\n§8[§b!§8]§7 Vous avez été mis en §aCréatif§7.");
					}else {
						if(current.equals(gm0)) {
							player.setGameMode(GameMode.ADVENTURE);
							player.sendMessage("\n§8[§b!§8]§7 Vous avez été mis en §8Survie§7");
						}else {
							if(current.equals(admin)) {
								main.open(player, Admin.class);
								break;
							}else {
								if(slot == 54 || current.equals(supspy)) {

									//player.getServer().dispatchCommand(player.getServer().getConsoleSender(), "ss");
									player.performCommand("ss");
									break;
								}else {
									main.open(player, LobbyMenu.class);
									return;
								}
							}
						}
					}
				}
			break;
			
			case THIN_GLASS:
				player.performCommand("ss");
				break;
			
			/*case APPLE:
				main.open(player, GadgetsMenu.class);
			break;*/
			case GOLD_INGOT:
				main.open(player, Boutique.class);
				break;
				
			case BED:
				Location spawn = new Location(Bukkit.getWorld("world"), 137.5, 36.1, 664.5, 180, 0);
				player.teleport(spawn);
				if(player.isOp()) {
					player.setGameMode(GameMode.CREATIVE);
				}
				break;
				
			case IRON_AXE:
				player.sendMessage("\n§8[§c!§8] §7SemiRP pas encore codé §e:/\n");
				break;
				
			case DIAMOND:
				player.sendMessage("\n§8[§c!§8] §7Créatif pas encore codé §e:/\n");
				break;
				
			case GRASS:
				ByteArrayOutputStream b3 = new ByteArrayOutputStream();
				DataOutputStream out3 = new DataOutputStream(b3);
				
				try {
					
					out3.writeUTF("Connect");
					out3.writeUTF("SkyBlock");
					
				}catch(IOException e){
					
					e.printStackTrace();
					
				}
				
				player.sendPluginMessage(main, "BungeeCord", b3.toByteArray());
				break;
				
			case COMMAND_MINECART:
				main.open(player, Settings.class);
				break;
				
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
				
			case DIAMOND_SWORD:
				ByteArrayOutputStream b = new ByteArrayOutputStream();
				DataOutputStream out = new DataOutputStream(b);
				
				try {
					
					out.writeUTF("Connect");
					out.writeUTF("Factions");
					
				}catch(IOException e){
					
					e.printStackTrace();
					
				}
				
				player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
				
				break;
				
			case STAINED_GLASS:
				ByteArrayOutputStream b2 = new ByteArrayOutputStream();
				DataOutputStream out2 = new DataOutputStream(b2);
				
				try {
					
					out2.writeUTF("Connect");
					out2.writeUTF("MiniJeux");
					
				}catch(IOException e){
					
					e.printStackTrace();
					
				}
				
				player.sendPluginMessage(main, "BungeeCord", b2.toByteArray());
				
				break;
				
			case COMPASS:
				ByteArrayOutputStream b4 = new ByteArrayOutputStream();
				DataOutputStream out4 = new DataOutputStream(b4);
				
				try {
					
					out4.writeUTF("Connect");
					out4.writeUTF("Survie");
					
				}catch(IOException e){
					
					e.printStackTrace();
					
				}
				
				player.sendPluginMessage(main, "BungeeCord", b4.toByteArray());
				
				break;
				
			case BEACON:
				if(player.hasPermission("ariacraft.vip")) {
					Location vip = new Location(Bukkit.getWorld("spawnfac"), 42.500, 16.1, 34.500);
					Inventory i = player.getInventory();
					player.teleport(vip);
					i.clear();
					Guitem(1, "§9§lCosmétiques", new ItemStack(Material.ENDER_CHEST), i);
					Guitem(4, "§e§kf§5§kf§e§kf§5§kf§r §2Menu §e§kf§5§kf§e§kf§5§kf", new ItemStack(Material.NETHER_STAR), i);
					Guitem(7, "§6Settings", new ItemStack(Material.COMMAND_MINECART), i);
					if(player.isOp()) {
						player.setGameMode(GameMode.CREATIVE);
					}
				}
				break;
				
			case PAPER:
				player.sendMessage("§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+\n§4 §c \n §4 §3» §5Discord : §dhttp://ariacraft.net/voice  \n  §3» §4Forums : §chttp://forums.ariacraft.net \n  §3» §8Feedback : §7http://feedback.ariacraft.net \n§3  » §2SiteWeb : §ahttps://ariacraft.net \n  §3» §bTwitter : §3@AriaCraftNtwk\n §c \n§f§m+-----§b§m-------§3§m---------------------------§b§m-------§f§m-----§f§m+");
				break;
				
			case GOLDEN_APPLE:
				main.open(player, UHC.class);
				break;
				
			default:
				main.open(player, LobbyMenu.class);
				return;
		
			/*default:
				break;*/
				
		}
		
	}

	@Override
	public int getSize() {
		return 54;
	}

	
}


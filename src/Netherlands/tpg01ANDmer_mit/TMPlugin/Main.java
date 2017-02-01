package Netherlands.tpg01ANDmer_mit.TMPlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Inventory OptionsMenu = Bukkit.createInventory(null, 54, "Options");
	public static ItemStack enable;
	public static ItemStack silent;
	public static ItemStack disable;
	public static ItemStack show;
	public static ItemStack bar;
	
	@Override
	public void onEnable() {
		
		new PlayerListener(this);
		new BlockListener(this);
		new InventoryListener(this);
		
		this.getConfig().options().copyDefaults(true);
		
	}
	@Override
	public void onDisable() {
		
	}
	
	static {
		
	    ItemStack green = new ItemStack(Material.GOLD_INGOT); 
	    ItemMeta im = green.getItemMeta(); 
	    im.setDisplayName (ChatColor.GREEN + "" + ChatColor.BOLD + "Notifications On"); 
	    List<String> lore = new ArrayList<String>(); 
	    lore.add(ChatColor.GREEN + "Click to enable all functions of SmartAlerts"); 
	    im.setLore(lore); 
	    green.setItemMeta(im);
	    enable = green;
	    
	    ItemStack orange = new ItemStack(Material.GOLD_INGOT); 
	    ItemMeta im1 = orange.getItemMeta(); 
	    im1.setDisplayName (ChatColor.GOLD + "" + ChatColor.BOLD + "Notifications Silent"); 
	    List<String> lore1 = new ArrayList<String>(); 
	    lore1.add(ChatColor.GOLD + "Click to silence all functions of SmartAlerts"); 
	    im1.setLore(lore1); 
	    orange.setItemMeta(im1);
	    silent = orange;
	    
	    ItemStack red = new ItemStack(Material.GOLD_INGOT); 
	    ItemMeta im2 = red.getItemMeta(); 
	    im2.setDisplayName (ChatColor.RED + "" + ChatColor.BOLD + "Notifications Off"); 
	    List<String> lore2 = new ArrayList<String>(); 
	    lore2.add(ChatColor.RED + "Click to disable all functions of SmartAlerts"); 
	    im2.setLore(lore2); 
	    red.setItemMeta(im2);
	    disable = red;
	    
	    ItemStack shower = new ItemStack(Material.GOLD_CHESTPLATE);
	    ItemMeta im4 = shower.getItemMeta();
	    im4.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Show settings");
	    List<String> lore4 = new ArrayList<String>();
	    lore4.add(ChatColor.GRAY + "Show settings for player");
	    im4.setLore(lore4);
	    shower.setItemMeta(im4);
	    show = shower;
	    
	    ItemStack barrier = new ItemStack(Material.BARRIER); 
	    ItemMeta im3 = barrier.getItemMeta(); 
	    im3.setDisplayName (ChatColor.RED + "" + ChatColor.BOLD + "Watched blocks"); 
	    List<String> lore3 = new ArrayList<String>(); 
	    lore3.add(ChatColor.RED + "Add watched blocks below"); 
	    im3.setLore(lore3); 
	    barrier.setItemMeta(im3);
	    bar = barrier;
		
	    OptionsMenu.setItem(12, green);
		OptionsMenu.setItem(13, orange);
		OptionsMenu.setItem(14, red);
		OptionsMenu.setItem(22, shower);
		OptionsMenu.setItem(27, barrier);
		OptionsMenu.setItem(28, barrier);
		OptionsMenu.setItem(29, barrier);
		OptionsMenu.setItem(30, barrier);
		OptionsMenu.setItem(31, barrier);
		OptionsMenu.setItem(32, barrier);
		OptionsMenu.setItem(33, barrier);
		OptionsMenu.setItem(34, barrier);
		OptionsMenu.setItem(35, barrier);
		
		
		
	}
	
	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		
		Player sender = (Player) send;
		
		//Toggles the alerts that a player gets
		if (cmd.getName().equalsIgnoreCase("alerts")) {
			
			if (args.length == 0) {
				
				sender.openInventory(OptionsMenu);
				
			}
			
			else {
				
				sender.sendRawMessage(ChatColor.RED + "" + ChatColor.BOLD + ">>" + ChatColor.RESET + ChatColor.GRAY + "Error: too many arguments used");
				
			}
			
			return true;
			
		}
		
		return false;
	}
	
}
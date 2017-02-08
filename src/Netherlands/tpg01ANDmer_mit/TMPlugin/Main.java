package Netherlands.tpg01ANDmer_mit.TMPlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
	public void onEnable() {

		new DBHandler();
		new PlayerListener(this);
		new BlockListener(this);
		new InventoryListener(this);
		
		this.getConfig().options().copyDefaults(true);
		
	}
	@Override
	public void onDisable() {
		
	}
	
	public static ItemStack createItemStack(Material material, String name, String lore) {
		
		ItemStack itemstack = new ItemStack(material);
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName(name);
		List<String> l = new ArrayList<String>(); 
	    l.add(lore); 
	    itemmeta.setLore(l); 
	    itemstack.setItemMeta(itemmeta);
		
		return itemstack;
		
	}
	
	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		
		Player sender = (Player) send;
		
		//Toggles the alerts that a player gets
		if (cmd.getName().equalsIgnoreCase("alerts")) {
			
			if (args.length == 0) {
				
				//open personal inventory from database
				
			}
			
			else {
				
				sender.sendRawMessage(ChatColor.RED + "" + ChatColor.BOLD + ">>" + ChatColor.RESET + ChatColor.GRAY + "Error: too many arguments used");
				
			}
			
			return true;
			
		}
		
		return false;
	}
	
}
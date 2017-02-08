package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
	
	public InventoryListener(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
	
		Player player = (Player) event.getWhoClicked(); // The player that clicked the item
	
		ItemStack clicked = event.getCurrentItem(); // The item that was clicked
	
		Inventory inventory = event.getInventory(); // The inventory that was clicked in
		
		if (inventory.getName().equals("Options")) {
			
			if (clicked.getType().equals(Material.GOLD_INGOT)) {
				
			}
			
			else if (clicked.getType().equals(Material.GOLD_CHESTPLATE)) {
				
			}
			
			
			else if (clicked.getType().equals(Material.BARRIER)) {
				
			}
			
			else if (clicked instanceof Block == false) {
				
				event.setCancelled(true);
				player.closeInventory();
				player.sendRawMessage(ChatColor.RED + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Please put in a block!");
			}
			
		}
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		
		//if (player settings for show in database are true) {
			//
		//}
		
		//depreciated
		//if (configGetter.getConfig().contains("show-temp")) {
			
			//If the player is the same as the player in the config file
			//if (player.getName().equalsIgnoreCase(configGetter.getConfig().getString("show.temp"))) {
				
				//event.setCancelled(true);
				
				//configGetter.getConfig().set("show-temp", null);
				//configGetter.saveConfig();
				
				//boolean bool = false;
				
				//for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						
					//if (p.getName().equalsIgnoreCase(event.getMessage())) {
						
						//String alerts = configGetter.getConfig().getString(p.getName());
						
						//player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + p.getName() + "'s settings are set to: ");							player.sendRawMessage(ChatColor.GRAY + "     Alerts: " + ChatColor.WHITE + alerts.toUpperCase());
						
						//bool = true;
					//}
					
				//}
				
				//if (bool == false) {
					
					//player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Cancelled: couldn't find a player online named " + event.getMessage());
					
				//}
				
			//}
			
		//}
		
	}
	
}

package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
	
	Main configGetter;
	
	public InventoryListener(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		configGetter = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
	
		Player player = (Player) event.getWhoClicked(); // The player that clicked the item
	
		ItemStack clicked = event.getCurrentItem(); // The item that was clicked
	
		Inventory inventory = event.getInventory(); // The inventory that was clicked in
		
		if (inventory.getName().equals(Main.OptionsMenu.getName())) {
			
			if (clicked.getType().equals(Material.GOLD_INGOT)) {
				
				if (clicked.getItemMeta().equals(Main.enable.getItemMeta())) {
					
					event.setCancelled(true);
					
					player.closeInventory();
					
					player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Alerts enabled");
					
					configGetter.getConfig().set(player.getName(), "on");
					configGetter.saveConfig();
					
				}
				
				if (clicked.getItemMeta().equals(Main.silent.getItemMeta())) {
					
					event.setCancelled(true);
					
					player.closeInventory();
					
					player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Alerts silent");
					
					configGetter.getConfig().set(player.getName(), "silent");
					configGetter.saveConfig();
					
				}

				if (clicked.getItemMeta().equals(Main.disable.getItemMeta())) {
	
					event.setCancelled(true);
					
					player.closeInventory();
					
					player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Alerts disabled");
					
					configGetter.getConfig().set(player.getName(), "off");
					configGetter.saveConfig();
				}
				
			}
			
			else if (clicked.getType().equals(Material.GOLD_CHESTPLATE)) {
				
				if (clicked.getItemMeta().equals(Main.show.getItemMeta())) {
					
					event.setCancelled(true);
					
					player.closeInventory();
					
					player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Put in the name of the player to show!");
					
					//Adds player to config file if not already in it
					if (!configGetter.getConfig().contains("show-temp")) {
					
						configGetter.getConfig().addDefault("show-temp", player.getName());
						configGetter.saveConfig();
					
					}
					
					//Sets the config player to given player if show.temp already existed
					if (configGetter.getConfig().contains("show-temp")) {
						
						configGetter.getConfig().set("show-temp", player.getName());
						configGetter.saveConfig();
					}
					
				}
				
			}
			
			else if (clicked.getType().equals(Material.BARRIER)) {
				
				if (clicked.getItemMeta().equals(Main.bar.getItemMeta())) {
					
					event.setCancelled(true);
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		
		if (configGetter.getConfig().contains("show-temp")) {
			
			//If the player is the same as the player in the config file
			if (player.getName().equalsIgnoreCase(configGetter.getConfig().getString("show.temp"))) {
				
				event.setCancelled(true);
				
				configGetter.getConfig().set("show-temp", null);
				configGetter.saveConfig();
				
				boolean bool = false;
				
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						
					if (p.getName().equalsIgnoreCase(event.getMessage())) {
						
						String alerts = configGetter.getConfig().getString(p.getName());
						
						player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + p.getName() + "'s settings are set to: ");							player.sendRawMessage(ChatColor.GRAY + "     Alerts: " + ChatColor.WHITE + alerts.toUpperCase());
						
						bool = true;
					}
					
				}
				
				if (bool == false) {
					
					player.sendRawMessage(ChatColor.GREEN + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.GRAY + "Cancelled: couldn't find a player online named " + event.getMessage());
					
				}
				
			}
			
		}
		
	}
	
}

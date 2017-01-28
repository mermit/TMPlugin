package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
	Main configGetter;
	
	public BlockListener(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		configGetter = plugin;
	}
	
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		
		Block block = event.getBlock();
		
		Location location = block.getLocation();
		
		if (block.getType() == Material.BEDROCK || block.getType() == Material.TNT) {
			
			event.setCancelled(true);
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				
				if ((p.hasPermission("ThomasterPlugin.alerts") || p.isOp()) && configGetter.getConfig().getBoolean(p.getName()) == true) {
					
					p.sendRawMessage(ChatColor.RED + "" + ChatColor.BOLD + "ALERT! " + ChatColor.RESET + ChatColor.GRAY + event.getPlayer().getName() + " just tried to place " + ChatColor.WHITE + block.getType() + ChatColor.GRAY + " at " + ChatColor.WHITE + "X: "+ location.getX() + " Y: "+ location.getY() + " Z: " + location.getZ() + ChatColor.GRAY +"!");
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		Block block = event.getBlock();
		
		Location location = block.getLocation();
		
		if (block.getType() == Material.BEDROCK || block.getType() == Material.TNT) {
			
			event.setCancelled(true);
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				
				if (p.hasPermission("ThomasterPlugin.alerts") || p.isOp() && configGetter.getConfig().getBoolean(p.getName()) == true) {
					
					p.sendRawMessage(ChatColor.RED + "" + ChatColor.BOLD + "ALERT! " + ChatColor.RESET + ChatColor.GRAY + event.getPlayer().getName() + " just tried to break " + ChatColor.WHITE + block.getType() + ChatColor.GRAY + " at " + ChatColor.WHITE + "X: "+ location.getX() + " Y: "+ location.getY() + " Z: " + location.getZ() + ChatColor.GRAY +"!");
					
				}
				
			}
			
		}
		
	}
	
	
}
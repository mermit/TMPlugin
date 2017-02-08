package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
	
	public BlockListener(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	
	}
	
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		
		Block block = event.getBlock();
		
		Location location = block.getLocation();
		
		//Add blockplace event here
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		Block block = event.getBlock();
		
		Location location = block.getLocation();
		
		//Add blockbreak event here
		
	}
	
	
}
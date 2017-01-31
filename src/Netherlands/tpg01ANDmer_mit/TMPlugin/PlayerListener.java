package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	Main configGetter;
	
	public PlayerListener(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		configGetter = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if (!configGetter.getConfig().contains(player.getName())) {
			
			configGetter.getConfig().addDefault(player.getName(), "on");
			configGetter.saveConfig();
			
		}
		
	}
}

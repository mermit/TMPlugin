package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		
		new PlayerListener(this);
		new BlockListener(this);
		
		this.getConfig().options().copyDefaults(true);
		
	}
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender send, Command cmd, String label, String[] args) {
		
		Player sender = (Player) send;
		
		//Toggles the alerts that a player gets
		if (cmd.getName().equalsIgnoreCase("alerts")) {
			
			if (args.length == 0) {
				
				
				//Imports data from config file
				
				boolean bool = this.getConfig().getBoolean(sender.getName());
				
				if (bool == false) {
					
					this.getConfig().set(sender.getName(), true);
					this.saveConfig();
					
					sender.sendRawMessage(ChatColor.GREEN + "Succesvully enabled SmartAlerts!");
					
				}
				
				if (bool == true) {
					
					this.getConfig().set(sender.getName(), false);
					this.saveConfig();
					
					sender.sendRawMessage(ChatColor.GREEN + "Succesvully disabled SmartAlerts!");
					
				}
				
			}
			
			else {
				
				sender.sendRawMessage("Usage: /alerts");
				
			}
			
			return true;
			
		}
		
		return false;
	}

	

}
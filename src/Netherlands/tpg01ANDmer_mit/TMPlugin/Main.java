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
			
			if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase("on")) {
					
					if (!this.getConfig().getString(sender.getName()).equalsIgnoreCase("on")) {
						
						this.getConfig().set(sender.getName(), "on");
						this.saveConfig();
						sender.sendRawMessage(ChatColor.GREEN + "Succesvully enabled SmartAlerts!");
						
					}
					
					else {
						
						sender.sendRawMessage(ChatColor.RED + "SmartAlerts is already enabled!");
						
					}
					
				}
				
				else if (args[0].equalsIgnoreCase("silent")) {
					
					if (!this.getConfig().getString(sender.getName()).equalsIgnoreCase("silent")) {
						
						this.getConfig().set(sender.getName(), "silent");
						this.saveConfig();
						sender.sendRawMessage(ChatColor.GREEN + "Succesvully set SmartAlerts to silent!");
						
					}
					
					else {
						
						sender.sendRawMessage(ChatColor.RED + "SmartAlerts is already silent!");
						
					}
					
				}
				
				else if (args[0].equalsIgnoreCase("off")) {
					
					if (!this.getConfig().getString(sender.getName()).equalsIgnoreCase("off")) {
						
						this.getConfig().set(sender.getName(), "off");
						this.saveConfig();
						sender.sendRawMessage(ChatColor.GREEN + "Succesvully disabled SmartAlerts");
						
					}
					
					else {
						
						sender.sendRawMessage(ChatColor.RED + "SmartAlerts is already disabled");
						
					}
					
				}
				
				else {
					
					sender.sendRawMessage(ChatColor.RED + "Valid arguments are: on, silent, off!");
					
				}
				
			}
			
			else {
				
				sender.sendRawMessage(ChatColor.RED + "Usage: /alerts <on/off/silent>");
				
			}
			
			return true;
			
		}
		
		return false;
	}

	

}
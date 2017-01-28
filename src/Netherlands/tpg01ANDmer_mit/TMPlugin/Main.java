package Netherlands.tpg01ANDmer_mit.TMPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
    	System.out.println("Enabling TMPlugin");
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
}

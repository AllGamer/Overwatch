package net.CraftRepo.Overwatch;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
//import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
//import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.plugin.PluginManager;
import org.bukkit.util.config.Configuration;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

/**
 * Overwatch for Bukkit
 *
 * @author CraftRepo
 */
public class Overwatchmain extends JavaPlugin 
{
	private final OverwatchPlayerListener playerListener = new OverwatchPlayerListener(this);
	private final OverwatchBlockListener blockListener = new OverwatchBlockListener(this);
    private final OverwatchInventoryListener inventoryListener = new OverwatchInventoryListener(this);
    private final OverwatchEntityListener entityListener = new OverwatchEntityListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    public final static Logger log = Logger.getLogger("Minecraft");
	public static String logPrefix = "[Overwatch]";
	public static PermissionHandler Permissions = null;
	@SuppressWarnings("unused")
	private OverwatchConfiguration confSetup;
	public static Configuration config;

	public void registerListeners() 
	{
		/** 
		 * Player Listeners
		 */
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_LOGIN, playerListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_KICK, playerListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_CHAT, playerListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, playerListener, Priority.Normal, this);
		/**
		 * Block Listeners
		 */
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, blockListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BURN, blockListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PHYSICS, blockListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.LEAVES_DECAY, blockListener, Priority.Normal, this);
		/**
		 * Inventory Listeners
		 */
		getServer().getPluginManager().registerEvent(Event.Type.INVENTORY_CHANGE, inventoryListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.INVENTORY_OPEN, inventoryListener, Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Event.Type.INVENTORY_TRANSACTION, inventoryListener, Priority.Normal, this);
		/**
		 * Entity Listener(s)
		 */
		getServer().getPluginManager().registerEvent(Event.Type.ENTITY_EXPLODE, entityListener, Priority.Normal, this);
	}
	
	public static String strip(String s) 
	{
		String good = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789:";
		String result = "";
		for ( int i = 0; i < s.length(); i++ ) 
		{
			if ( good.indexOf(s.charAt(i)) >= 0 )
				result += s.charAt(i);
		}
		return result;
	}
	
	public void configInit()
	{
		getDataFolder().mkdirs();
		config = new Configuration(new File(this.getDataFolder(), "config.yml"));
		confSetup = new OverwatchConfiguration(this.getDataFolder(), this);
	}
	
	public void setupPermissions() 
	{
		Plugin perms = this.getServer().getPluginManager().getPlugin("Permissions");
		PluginDescriptionFile pdfFile = this.getDescription();

		if (Overwatchmain.Permissions == null) 
		{
			if (perms != null) 
			{
				this.getServer().getPluginManager().enablePlugin(perms);
				Overwatchmain.Permissions = ((Permissions) perms).getHandler();
				log.info(logPrefix + " version " + pdfFile.getVersion() + " Permissions detected...");
			}
			else 
			{
				log.severe(logPrefix + " version " + pdfFile.getVersion() + " not enabled. Permissions not detected.");
				this.getServer().getPluginManager().disablePlugin(this);
			}
		}
	}
	
    public void onEnable() 
    {
    	configInit();
    	registerListeners();
    	setupPermissions();
        log.info(logPrefix + " version " + getDescription().getVersion() + " is enabled!");
    }
    
    public void onDisable() 
    {
        log.info(logPrefix + " version " + getDescription().getVersion() + " is disabled!");
    }
    
    public boolean isDebugging(final Player player) 
    {
        if (debugees.containsKey(player)) 
        {
            return debugees.get(player);
        }
        else 
        {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) 
    {
        debugees.put(player, value);
    }
}


package net.CraftRepo.Overwatch;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
	public static HashMap<Integer, String> blocks = new HashMap<Integer, String>();
	public static List<String> dbdata;
	public final static Logger log = Logger.getLogger("Minecraft");
	public static String logPrefix = "[Overwatch]";
	public static PermissionHandler Permissions = null;
	public boolean mysqlconnection = true;
	@SuppressWarnings("unused")
	private OverwatchConfiguration confSetup;
	public static Configuration config;
	protected static Object mysqldb = Overwatchmain.config.getProperty("mysqldb");
	protected static Object mysqluser = Overwatchmain.config.getProperty("mysqluser");
	protected static Object mysqlpass = Overwatchmain.config.getProperty("mysqlpass");
	public static Connection conn = null;

	public void openSQLConnection()
	{
		if (conn == null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(mysqldb.toString(),mysqluser.toString(),mysqlpass.toString());
			}
			catch (ClassNotFoundException e) 
			{
				log.severe(logPrefix + " Couldn't locate the MySQL Driver! Disabling!");
				e.printStackTrace();
				this.getServer().getPluginManager().disablePlugin(this);
			} 
			catch (SQLException e) 
			{
				log.severe(logPrefix + " An error occured during a SQL transaction!");
				e.printStackTrace();
			}
		}
	}

	public void populateItemMap()
	{
		blocks.put(1, "stone");
		blocks.put(2, "grass");
		blocks.put(3, "dirt");
		blocks.put(4, "cobblestone");
		blocks.put(5, "wood");
		blocks.put(6, "sapling");
		blocks.put(7, "bedrock");
		blocks.put(8, "movingwater");
		blocks.put(9, "sourcewater");
		blocks.put(10, "movinglava");
		blocks.put(11, "sourcelava");
		blocks.put(12, "sand");
		blocks.put(13, "gravel");
		blocks.put(14, "goldore");
		blocks.put(15, "ironore");
		blocks.put(16, "coalore");
		blocks.put(17, "log");
		blocks.put(18, "leaf");
		blocks.put(19, "sponge");
		blocks.put(20, "glass");
		blocks.put(21, "lapislazuliore");
		blocks.put(22, "lapislazuliblock");
		blocks.put(23, "dispenser");
		blocks.put(24, "sandstone");
		blocks.put(25, "noteblock");
		blocks.put(26, "bed");
		blocks.put(27, "booster rail");
		blocks.put(28, "detector rail");
		blocks.put(30, "web");
		blocks.put(35, "cloth");
		blocks.put(37, "yellowflower");
		blocks.put(38, "rose");
		blocks.put(39, "brown mushroom");
		blocks.put(40, "red mushroom");
		blocks.put(41, "gold");
		blocks.put(42, "iron");
		blocks.put(43, "doublestep");
		blocks.put(44, "step");
		blocks.put(45, "brick");
		blocks.put(46, "tnt");
		blocks.put(47, "bookshelf");
		blocks.put(48, "mossy cobble");
		blocks.put(49, "obsidian");
		blocks.put(50, "torch");
		blocks.put(51, "fire");
		blocks.put(52, "mob spawner");
		blocks.put(53, "wood stairs");
		blocks.put(54, "chest");
		blocks.put(55, "redstone wire");
		blocks.put(56, "diamond block");
		blocks.put(58, "workbench");
		blocks.put(59, "crop");
		blocks.put(60, "farmland");
		blocks.put(61, "furnace");
		blocks.put(62, "lit furnace");
		blocks.put(63, "sign post");
		blocks.put(63, "sign block");
		blocks.put(64, "wood door");
		blocks.put(65, "ladder");
		blocks.put(66, "track");
		blocks.put(67, "cobblestone stairs");
		blocks.put(68, "wall sign");
		blocks.put(69, "lever");
		blocks.put(70, "stone pressureplate");
		blocks.put(71, "iron door");
		blocks.put(72, "wooden pressureplate");
		blocks.put(73, "redstone ore");
		blocks.put(75, "redstone torch off");
		blocks.put(76, "redstone torch");
		blocks.put(77, "button");
		blocks.put(78, "snow");
		blocks.put(79, "ice");
		blocks.put(80, "snowblock");
		blocks.put(81, "cactus");
		blocks.put(82, "clay");
		blocks.put(83, "sugarcane");
		blocks.put(84, "jukebox");
		blocks.put(85, "fence");
		blocks.put(86, "pumpkin");
		blocks.put(87, "netherrack");
		blocks.put(88, "soulsand");
		blocks.put(89, "glowstone");
		blocks.put(90, "portal");
		blocks.put(91, "jack-o-lantern");
		blocks.put(92, "cake");
		blocks.put(93, "redstone repeater (off)");
		blocks.put(94, "redstone repeater");
	}

	public void registerListeners() 
	{
		/** 
		 * Player Listeners
		 */
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_LOGIN, playerListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_KICK, playerListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_CHAT, playerListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, playerListener, Priority.Monitor, this);
		/**
		 * Block Listeners
		 */
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, blockListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BURN, blockListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PHYSICS, blockListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.LEAVES_DECAY, blockListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_FROMTO, blockListener, Priority.Monitor, this);
		/**
		 * Inventory Listeners
		 */
		getServer().getPluginManager().registerEvent(Event.Type.INVENTORY_CHANGE, inventoryListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.INVENTORY_OPEN, inventoryListener, Priority.Monitor, this);
		getServer().getPluginManager().registerEvent(Event.Type.INVENTORY_TRANSACTION, inventoryListener, Priority.Monitor, this);
		/**
		 * Entity Listener(s)
		 */
		getServer().getPluginManager().registerEvent(Event.Type.ENTITY_EXPLODE, entityListener, Priority.Monitor, this);
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
		openSQLConnection();
		if (mysqlconnection & conn != null)
		{
			MySQLConnection.initialize();
		}
		else
		{
			// DISCUSS: H2 integration? or sqlite? H2 would be logical.
		}
		populateItemMap();
		log.info(logPrefix + " version " + getDescription().getVersion() + " is enabled!");
	}


	public void onDisable() 
	{
		if (conn != null)
		{
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
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


	public boolean onCommand(CommandSender sender, Command commandArg, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
		String command = commandArg.getName().toLowerCase();
		if (command.equalsIgnoreCase("ow"))
		{
			if (args[1].equals("rollback") & Overwatchmain.Permissions.has(player, "overwatch.rollback"))
			{
				// Add rollback code here. Call the thread from here or from a method.
			}
			else if (args[1].equals("area") & Overwatchmain.Permissions.has(player, "overwatch.check.area"))
			{
				// Add code to get nearby blocks and get the history on the location. Should be based on a radius.
			}
		}
		return false;
	}
}


package net.CraftRepo.Overwatch;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

/**
 * CraftRepo Overwatch for Bukkit
 * @author AllGamer
 * 
 * Copyright 2011 AllGamer, LLC.
 * See LICENSE for licensing information.
 */

@SuppressWarnings("unused")
public class MySQLConnection 
{
	private Overwatchmain plugin;
	private File folder;
	private final static Logger log = Logger.getLogger("Minecraft");
	private static String logPrefix;
	static Object mysqldb = Overwatchmain.config.getProperty("mysqldb");
	static Object mysqluser = Overwatchmain.config.getProperty("mysqluser");
	static Object mysqlpass = Overwatchmain.config.getProperty("mysqlpass");

	@SuppressWarnings("static-access")
	public MySQLConnection()
	{
		this.logPrefix = Overwatchmain.logPrefix;
	}

	private final static String CHAT_TABLE     = "CREATE TABLE `ow_chat` "
		+ "("
		+ "`id`        int not null primary key auto_increment, "
		+ "`user_id`    int, "
    	+ "`msg_from`    int, "
    	+ "`msg_to`    int, "
    	+ "`msg_content    tinytext"
    	+ ");";

	private final static String LOGIN_TABLE    = "CREATE TABLE `ow_login_logout` "
		+ "("
		+ "`user_id`    int, "
		+ "`action`    tinyint, -- 1 == login, 0 == logout, "
		+ "`ip_addr    int(10) unsigned, -- INET_ATON/INET_NTOA format,"
		+ ");";

	private final static String COMMAND_TABLE = "CREATE TABLE `ow_cmd` "
		+ "("
		+ "`id` int not null primary key auto_increment, "
		+ "`user_id` int, "
		+ "`cmd_run` tinytext, "
		+ "`cmd_success` tinyint -- 0== fail/unknown cmd, 1 = valid command, "
		+ ");";

	private final static String BLOCK_TABLE = "CREATE TABLE `ow_block` "
		+ "("
		+ "`item_id`    int, "
		+ "`user_id`    int, -- 0 == Environment, "
		+ "`action`    ENUM('placed', 'broke', 'flowed', 'dropped') -- These map internally to 0,1,2,3, "
		+ "`x`        int unsigned, "
		+ "`y`        int unsigned, "
		+ "`z`        int unsigned, "
		+ "INDEX x_y_z_idx(`x`, `y`, `z`), "
		+ ");";
	
	private final static String PLAYER_TABLE = "CREATE TABLE `ow_players` "
		+ "("
		+ "`id` int not null primary key auto_increment, "
		+ "`player` varchar(16), "
		+ ");";
	
	public static boolean initialize() 
	{
		Logger log = Logger.getLogger("Minecraft");
		log.info(logPrefix + " Loading MySQL");
		Overwatchmain.config.load();

		if (!tableExists("ow_chat")) 
		{
			log.info(logPrefix + " 'ow_chat' table doesn't exist, creating...");
			if (!createTable(CHAT_TABLE)) 
			{
				log.info(logPrefix + " Cannot make table 'ow_chat', disabling plugin.");
				return false;
			}
		}

		if (!tableExists("ow_login_logout")) 
		{
			log.info(logPrefix + " 'ow_login_logout' table doesn't exist, creating...");
			if (!createTable(LOGIN_TABLE)) 
			{
				log.info(logPrefix + " Cannot make table 'ow_login_logout', disabling plugin.");
				return false;
			}
		}

		if (!tableExists("ow_cmd")) 
		{
			log.info(logPrefix + " 'ow_cmd' table doesn't exist, creating now.");
			if (!createTable(COMMAND_TABLE)) 
			{
				log.info(logPrefix + " Cannot make table 'ow_cmd', disabling plugin.");
				return false;
			}
		}
		
		if (!tableExists("ow_block")) 
		{
			log.info(logPrefix + " 'ow_block' table doesn't exist, creating now.");
			if (!createTable(BLOCK_TABLE)) 
			{
				log.info(logPrefix + " Cannot make table 'ow_block', disabling plugin.");
				return false;
			}
		}
		
		if (!tableExists("ow_players")) 
		{
			log.info(logPrefix + " 'ow_players' table doesn't exist, creating now.");
			if (!createTable(PLAYER_TABLE)) 
			{
				log.info(logPrefix + " Cannot make table 'ow_players', disabling plugin.");
				return false;
			}
		}
		return true;
	}

	public static boolean sql(String sql) 
	{
		Connection conn = null;
		Statement st = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(mysqldb.toString(),mysqluser.toString(),mysqlpass.toString());
			st = conn.createStatement();
			st.executeUpdate(sql);
			return true;
		}
		catch (SQLException e) 
		{
			return false;
		}
		catch (ClassNotFoundException e) 
		{
			log.info(logPrefix + " Error loading com.mysql.jdbc.Driver");
			return false;
		}
		finally 
		{
			try 
			{
				if (conn != null) conn.close();
				if (st != null) st.close();
			}
			catch (SQLException e) 
			{
				log.info(logPrefix + " Could not close DB Connections.");
				return false;
			}
		}
	}

	private static boolean tableExists(String table) 
	{
		Connection conn = null;
		ResultSet rs = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(mysqldb.toString(),mysqluser.toString(),mysqlpass.toString());
			DatabaseMetaData dbm = conn.getMetaData();
			rs = dbm.getTables(null, null, table, null);
			if (!rs.next()) return false;
			return true;
		}
		catch (SQLException ex) 
		{
			log.info(logPrefix + " Table Check Exception");
			return false;
		}
		catch (ClassNotFoundException e) 
		{
			log.info(logPrefix + " Error loading com.mysql.jdbc.Driver");
			return false;
		}
		finally 
		{
			try 
			{
				if (rs != null) rs.close();
				if (conn != null) conn.close();
			}
			catch (SQLException ex) 
			{
				log.info(logPrefix + " Table Check SQL Exception (on closing)");
			}
		}
	}

	private static boolean createTable(String sql) 
	{
		Connection conn = null;
		Statement st = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(mysqldb.toString(),mysqluser.toString(),mysqlpass.toString());
			st = conn.createStatement();
			st.executeUpdate(sql);
			return true;
		}
		catch (SQLException e) 
		{
			log.info(logPrefix + " Create Table Exception");
			return false;
		}
		catch (ClassNotFoundException e) 
		{
			log.info(logPrefix + " Error loading com.mysql.jdbc.Driver");
			return false;
		}
		finally 
		{
			try 
			{
				if (conn != null) conn.close();
				if (st != null) st.close();
			}
			catch (SQLException e) 
			{
				log.info(logPrefix + " Could not create the table (on close)");
				return false;
			}
		}
	}
}

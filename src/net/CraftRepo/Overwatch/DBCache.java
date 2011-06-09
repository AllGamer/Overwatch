package net.CraftRepo.Overwatch;

import java.util.List;

public class DBCache extends Thread 
{
	private Overwatchmain OverwatchPlugin = null;
	private List<String> dbcache = null;

	public DBCache(Overwatchmain Overwatch, List<String> dbdata)
	{
		this.OverwatchPlugin = Overwatch;
		this.dbcache = dbdata;
	}
	
	public void run()
	{
		Overwatchmain.config.load();
		MySQLConnection.sql("BULK INSERT INTO " + Overwatchmain.config.getProperty("mysqlTable") + Overwatchmain.dbdata.toString());
		// Add Code to bulk insert the String List 'dbcache' into the database.
	}
}

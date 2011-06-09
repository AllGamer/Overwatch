package net.CraftRepo.Overwatch;

public class DBCache extends Thread 
{
	private Overwatchmain OverwatchPlugin = null;
	private String table;

	public DBCache(Overwatchmain Overwatch, String toTable)
	{
		this.OverwatchPlugin = Overwatch;
		this.table = toTable;
	}
	
	public void run()
	{
		Overwatchmain.config.load();
		MySQLConnection.sql("BULK INSERT INTO " + table + Overwatchmain.dbdata.toString());
		// Add Code to bulk insert the String List 'dbcache' into the database.
	}
}

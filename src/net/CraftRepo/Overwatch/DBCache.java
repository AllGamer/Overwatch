package net.CraftRepo.Overwatch;

public class DBCache extends Thread 
{
	private Overwatchmain OverwatchPlugin = null;

	public DBCache(Overwatchmain Overwatch)
	{
		this.OverwatchPlugin = Overwatch;
	}
	
	public void run()
	{
		Overwatchmain.config.load();
		MySQLConnection.sqlUpdate("BULK INSERT INTO " + Overwatchmain.dbdata.toString());
	}
}

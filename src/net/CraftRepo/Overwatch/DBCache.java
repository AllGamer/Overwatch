package net.CraftRepo.Overwatch;

import java.sql.SQLException;

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
		try 
		{
			MySQLConnection.sqlUpdate("BULK INSERT INTO " + Overwatchmain.dbdata.toString());
			MySQLConnection.st.close();
		} 
		catch (SQLException e) 
		{
			Overwatchmain.log.warning(Overwatchmain.logPrefix + " Error Updating the SQL DB.");
			e.printStackTrace();
		}
	}
}

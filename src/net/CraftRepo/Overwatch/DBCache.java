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
			for (String s : Overwatchmain.dbdataBlock)
			{
				MySQLConnection.sqlUpdate(s);
			}
			for (String s : Overwatchmain.dbdataChat)
			{
				MySQLConnection.sqlUpdate(s);
			}
			for (String s : Overwatchmain.dbdataCmd)
			{
				MySQLConnection.sqlUpdate(s);
			}
			for (String s : Overwatchmain.dbdataLogin)
			{
				MySQLConnection.sqlUpdate(s);
			}
			for (String s : Overwatchmain.dbdataPlayer)
			{
				MySQLConnection.sqlUpdate(s);
			}
			MySQLConnection.st.close();
		} 
		catch (SQLException e) 
		{
			Overwatchmain.log.warning(Overwatchmain.logPrefix + " Error Updating the SQL DB.");
			e.printStackTrace();
		}
	}
}

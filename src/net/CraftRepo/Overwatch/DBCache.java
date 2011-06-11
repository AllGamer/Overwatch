package net.CraftRepo.Overwatch;

import java.sql.SQLException;

public class DBCache implements Runnable 
{
	public Integer id;

	public void run()
	{
		Overwatchmain.config.load();
		try 
		{
			if (Overwatchmain.dbdataBlock != null)
			{
				for (String s : Overwatchmain.dbdataBlock)
				{
					MySQLConnection.sqlUpdate(s);
				}
			}
			if (Overwatchmain.dbdataBlock != null)
			{
				for (String s : Overwatchmain.dbdataChat)
				{
					MySQLConnection.sqlUpdate(s);
				}
			}
			if (Overwatchmain.dbdataBlock != null)
			{
				for (String s : Overwatchmain.dbdataCmd)
				{
					MySQLConnection.sqlUpdate(s);
				}
			}
			if (Overwatchmain.dbdataBlock != null)
			{
				for (String s : Overwatchmain.dbdataLogin)
				{
					MySQLConnection.sqlUpdate(s);
				}
			}
			if (Overwatchmain.dbdataBlock != null)
			{
				for (String s : Overwatchmain.dbdataPlayer)
				{
					MySQLConnection.sqlUpdate(s);
				}
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

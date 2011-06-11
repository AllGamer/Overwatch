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
				Overwatchmain.dbdataBlock.clear();
			}
			if (Overwatchmain.dbdataChat != null)
			{
				for (String s : Overwatchmain.dbdataChat)
				{
					MySQLConnection.sqlUpdate(s);
				}
				Overwatchmain.dbdataChat.clear();
			}
			if (Overwatchmain.dbdataCmd != null)
			{
				for (String s : Overwatchmain.dbdataCmd)
				{
					MySQLConnection.sqlUpdate(s);
				}
				Overwatchmain.dbdataCmd.clear();
			}
			if (Overwatchmain.dbdataLogin != null)
			{
				for (String s : Overwatchmain.dbdataLogin)
				{
					MySQLConnection.sqlUpdate(s);
				}
				Overwatchmain.dbdataLogin.clear();
			}
			if (Overwatchmain.dbdataPlayer != null)
			{
				for (String s : Overwatchmain.dbdataPlayer)
				{
					MySQLConnection.sqlUpdate(s);
				}
				Overwatchmain.dbdataPlayer.clear();
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

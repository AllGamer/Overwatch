package net.CraftRepo.Overwatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class RollbackThread extends Thread 
{
	private String target;
	private int rollbackID;
	private ResultSet result;
	private Player sender;
	private String time;

	public RollbackThread(String target, Player sender)
	{
		this.target = target;
		this.sender = sender;
	}
	
	/**
	 * @param time the time to rollback
	 */
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public void run()
	{
		Overwatchmain.config.load();
		try 
		{
			if (time == null)
			{
				rollbackID = MySQLConnection.sqlGet("SELECT * FROM ow_players WHERE 'player' = '" + target + "';").getInt("player");
				result = MySQLConnection.sqlGet("SELECT * FROM ow_block WHERE 'user_id' = '" + rollbackID + "';");
			}
			else
			{
				rollbackID = MySQLConnection.sqlGet("SELECT * FROM ow_players WHERE 'player' = '" + target + "';").getInt("player");
				result = MySQLConnection.sqlGet("SELECT * FROM ow_block WHERE 'user_id' = '" + rollbackID + "';");
			}
		} 
		catch (SQLException e) 
		{
			sender.sendMessage(Overwatchmain.logPrefix + "Error rolling player " + target + ". See console for details.");
			Overwatchmain.log.warning(Overwatchmain.logPrefix + " Error accessing the MySQL DB.");
			e.printStackTrace();
			this.interrupt();
		}
		
		// Add Code to rollback the blocks. When done, make sure to result.close() to close the resultset and MySQLConnection.st.close() to close the statements!
		
	}
}

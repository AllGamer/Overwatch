package net.CraftRepo.Overwatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.block.Block;
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
		// Add Code to rollback the blocks. When done, make sure to result.close() to close the resultset and MySQLConnection.st.close() to close the statements!
		for(int i=1;i<=100;i++)
		{
			try 
			{
				result.next();
				Block temp = sender.getWorld().getBlockAt(result.getInt("x"), result.getInt("y"), result.getInt("z"));
				temp.setTypeIdAndData(result.getInt("item_id"), result.getByte("data"), false);
				if(result.isLast())
				{
					break;
				}
			} 
			catch (SQLException e) 
			{
				sender.sendMessage(Overwatchmain.logPrefix + " Error rolling player " + target + ". See console for details.");
				Overwatchmain.log.warning(Overwatchmain.logPrefix + " Error accessing the MySQL DB.");
				e.printStackTrace();
				this.interrupt();
			}
		}
		try 
		{
			if(result.isLast())
			{
				result.close();
				MySQLConnection.st.close();
				this.interrupt();
			}
		}
		catch (SQLException e) 
		{
			sender.sendMessage(Overwatchmain.logPrefix + " Error rolling player " + target + ". See console for details.");
			Overwatchmain.log.warning(Overwatchmain.logPrefix + " Error accessing the MySQL DB.");
			e.printStackTrace();
			this.interrupt();
		}
	}
}

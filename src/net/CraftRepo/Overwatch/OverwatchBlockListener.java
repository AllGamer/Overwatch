package net.CraftRepo.Overwatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SignChangeEvent;

/**
 * Overwatch block listener
 * 
 * @author CraftRepo
 */
public class OverwatchBlockListener extends BlockListener 
{
	public String tableName = "ow_block";
	@SuppressWarnings("unused")
	private final Overwatchmain plugin;
	public OverwatchBlockListener(final Overwatchmain plugin)
	{
		this.plugin = plugin;
	}
	
	/**
	 * @param block The block for the current event.
	 * @param player The player (event.getPlayer().getName()) that caused the event environment == creeper or burned block due to fire spread.
	 * @param action The action that occured in the event. 0 is placed, 1 is broke, 2 is flowed, 3 is dropped, 4 is burned, 5 is changed.
	 * @return True if successful; False if failed to query the db for player name. 
	 */
	public boolean MySQLadd(Block block, String player, Integer action)
	{
		try
		{	
			ResultSet playerID = MySQLConnection.sqlGet("SELECT * FROM ow_players WHERE"
			+ "`player` = '" + player + "';");
			
			Overwatchmain.dbdataBlock.add("INSERT INTO "
			+ tableName 
			+ " VALUES (`item_id` = '" + block.getTypeId() 
			+ "', `data` = '" + block.getData()
			+ "', `user_id` = '" + playerID.getString("player") 
			+ "', `action` = '" + action
			+ "', `date` = '" + Overwatchmain.getTime() 
			+ "',`x` = '" + block.getX() 
			+ "', `y` = '" + block.getY() 
			+ "', `z` = '" + block.getZ() 
			+ "');");
			
			MySQLConnection.st.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void onBlockBreak(BlockBreakEvent event) 
	{
		MySQLadd(event.getBlock(), event.getPlayer().getName(), 1);
	}

	public void onBlockBurn(BlockBurnEvent event)
	{
		MySQLadd(event.getBlock(), "Enviornment", 4);
	}

	@Override
	public void onBlockIgnite(BlockIgniteEvent event) 
	{
		// TODO Auto-generated method stub
		super.onBlockIgnite(event);
	}

	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) 
	{
		// TODO Auto-generated method stub
		super.onBlockPhysics(event);
	}

	@Override
	public void onBlockPlace(BlockPlaceEvent event)
	{
		// TODO Auto-generated method stub
		super.onBlockPlace(event);
	}

	@Override
	public void onBlockRedstoneChange(BlockRedstoneEvent event) 
	{
		// TODO Auto-generated method stub
		super.onBlockRedstoneChange(event);
	}

	@Override
	public void onLeavesDecay(LeavesDecayEvent event) 
	{
		// TODO Auto-generated method stub
		super.onLeavesDecay(event);
	}

	@Override
	public void onSignChange(SignChangeEvent event) 
	{
		// TODO Auto-generated method stub
		super.onSignChange(event);
	}

	// put all Block related code here
}

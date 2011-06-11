package net.CraftRepo.Overwatch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockFromToEvent;
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
	private final Overwatchmain plugin;
	public OverwatchBlockListener(final Overwatchmain plugin)
	{
		this.plugin = plugin;
	}
	
	public void onBlockBreak(BlockBreakEvent event) 
	{
		try
		{
			Block block = event.getBlock();
			Player player = event.getPlayer();
			
			ResultSet playerID = MySQLConnection.sqlGet("SELECT * FROM ow_players WHERE"
			+ "`player` = '" + player.getName() + "';");
			
			Overwatchmain.dbdataBlock.add("INSERT INTO "
			+ tableName 
			+ " VALUES (`item_id` = '" + block.getTypeId() 
			+ "', `data` = '" + block.getData()
			+ "', `user_id` = '" + playerID.getString("player") 
			+ "', `action` = '1"
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
		}
	}

	@Override
	public void onBlockBurn(BlockBurnEvent event)
	{
		// TODO Auto-generated method stub
		super.onBlockBurn(event);
	}

	@Override
	public void onBlockCanBuild(BlockCanBuildEvent event)
	{
		// TODO Auto-generated method stub
		super.onBlockCanBuild(event);
	}

	@Override
	public void onBlockDamage(BlockDamageEvent event) 
	{
		// TODO Auto-generated method stub
		super.onBlockDamage(event);
	}

	@Override
	public void onBlockFromTo(BlockFromToEvent event) 
	{
		// TODO Auto-generated method stub
		super.onBlockFromTo(event);
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

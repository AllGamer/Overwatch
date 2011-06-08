package net.CraftRepo.Overwatch;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
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
public class OverwatchBlockListener extends BlockListener {
	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		// TODO Auto-generated method stub
		super.onBlockBreak(event);
	}

	@Override
	public void onBlockBurn(BlockBurnEvent event) {
		// TODO Auto-generated method stub
		super.onBlockBurn(event);
	}

	@Override
	public void onBlockCanBuild(BlockCanBuildEvent event) {
		// TODO Auto-generated method stub
		super.onBlockCanBuild(event);
	}

	@Override
	public void onBlockDamage(BlockDamageEvent event) {
		// TODO Auto-generated method stub
		super.onBlockDamage(event);
	}

	@Override
	public void onBlockFromTo(BlockFromToEvent event) {
		// TODO Auto-generated method stub
		super.onBlockFromTo(event);
	}

	@Override
	public void onBlockIgnite(BlockIgniteEvent event) {
		// TODO Auto-generated method stub
		super.onBlockIgnite(event);
	}

	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) {
		// TODO Auto-generated method stub
		super.onBlockPhysics(event);
	}

	@Override
	public void onBlockPlace(BlockPlaceEvent event) {
		// TODO Auto-generated method stub
		super.onBlockPlace(event);
	}

	@Override
	public void onBlockRedstoneChange(BlockRedstoneEvent event) {
		// TODO Auto-generated method stub
		super.onBlockRedstoneChange(event);
	}

	@Override
	public void onLeavesDecay(LeavesDecayEvent event) {
		// TODO Auto-generated method stub
		super.onLeavesDecay(event);
	}

	@Override
	public void onSignChange(SignChangeEvent event) {
		// TODO Auto-generated method stub
		super.onSignChange(event);
	}

	private final Overwatchmain plugin;

	public OverwatchBlockListener(final Overwatchmain plugin) {
		this.plugin = plugin;
	}

	// put all Block related code here
}

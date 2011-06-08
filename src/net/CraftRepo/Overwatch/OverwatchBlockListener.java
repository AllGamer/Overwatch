package net.CraftRepo.Overwatch;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * Overwatch block listener
 * 
 * @author CraftRepo
 */
public class OverwatchBlockListener extends BlockListener {
	private final Overwatchmain plugin;

	public OverwatchBlockListener(final Overwatchmain plugin) {
		this.plugin = plugin;
	}

	// put all Block related code here
}

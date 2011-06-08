package net.CraftRepo.Overwatch;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * Overwatch Player listener
 * @author CraftRepo
 */
public class OverwatchEntityListener extends BlockListener 
{
    private final Overwatchmain plugin;

    public OverwatchEntityListener(final Overwatchmain plugin) 
    {
        this.plugin = plugin;
    }

    //put all Entity related code here
}

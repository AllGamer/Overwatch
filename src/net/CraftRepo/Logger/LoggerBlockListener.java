package net.CraftRepo.Logger;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * Logger block listener
 * @author CraftRepo
 */
public class LoggerBlockListener extends BlockListener 
{
    private final Loggermain plugin;

    public LoggerBlockListener(final Loggermain plugin) 
    {
        this.plugin = plugin;
    }

    //put all Block related code here
}

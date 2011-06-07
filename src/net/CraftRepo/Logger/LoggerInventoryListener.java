package net.CraftRepo.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Inventory related events
 * @author CraftRepo
 */
public class LoggerInventoryListener extends PlayerListener 
{
    private final Loggermain plugin;

    public LoggerInventoryListener(Loggermain instance) 
    {
        plugin = instance;
    }

    //Insert Inventory related code here
}


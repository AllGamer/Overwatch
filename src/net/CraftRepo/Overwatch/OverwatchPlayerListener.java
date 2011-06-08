package net.CraftRepo.Overwatch;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author CraftRepo
 */
public class OverwatchPlayerListener extends PlayerListener 
{
    private final Overwatchmain plugin;

    public OverwatchPlayerListener(Overwatchmain instance) 
    {
        plugin = instance;
    }

    public void onPlayerLogin(PlayerLoginEvent event)
	{
	// add crap for login logging here.
	}
    //Insert Player related code here
}


package net.CraftRepo.Overwatch;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Handle events for all Player related events
 * @author CraftRepo
 */
public class OverwatchPlayerListener extends PlayerListener 
{
	
    @Override
	public void onPlayerAnimation(PlayerAnimationEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerAnimation(event);
	}

	@Override
	public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerBedEnter(event);
	}

	@Override
	public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerBedLeave(event);
	}

	@Override
	public void onPlayerChat(PlayerChatEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerChat(event);
	}

	@Override
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerCommandPreprocess(event);
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerInteract(event);
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerJoin(event);
	}

	@Override
	public void onPlayerKick(PlayerKickEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerKick(event);
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerMove(event);
	}

	@Override
	public void onPlayerPreLogin(PlayerPreLoginEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerPreLogin(event);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerQuit(event);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerRespawn(event);
	}

	@Override
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerTeleport(event);
	}

	@Override
	public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerToggleSneak(event);
	}

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


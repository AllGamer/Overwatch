package net.CraftRepo.Overwatch;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Handle events for all Inventory related events
 * @author CraftRepo
 */
public class OverwatchInventoryListener extends PlayerListener 
{
    @Override
	public void onInventoryOpen(PlayerInventoryEvent event) 
    {
		// TODO Auto-generated method stub
		super.onInventoryOpen(event);
	}

	@Override
	public void onItemHeldChange(PlayerItemHeldEvent event)
	{
		// TODO Auto-generated method stub
		super.onItemHeldChange(event);
	}

	@Override
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) 
	{
		// TODO Auto-generated method stub
		super.onPlayerBucketEmpty(event);
	}

	@Override
	public void onPlayerBucketFill(PlayerBucketFillEvent event) 
	{
		// TODO Auto-generated method stub
		super.onPlayerBucketFill(event);
	}

	@Override
	public void onPlayerDropItem(PlayerDropItemEvent event) 
	{
		// TODO Auto-generated method stub
		super.onPlayerDropItem(event);
	}

	@Override
	public void onPlayerEggThrow(PlayerEggThrowEvent event)
	{
		// TODO Auto-generated method stub
		super.onPlayerEggThrow(event);
	}

	@Override
	public void onPlayerPickupItem(PlayerPickupItemEvent event) 
	{
		// TODO Auto-generated method stub
		super.onPlayerPickupItem(event);
	}

	private final Overwatchmain plugin;

    public OverwatchInventoryListener(Overwatchmain instance) 
    {
        plugin = instance;
    }

    //Insert Inventory related code here
}


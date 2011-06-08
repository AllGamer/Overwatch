package net.CraftRepo.Overwatch;

import org.bukkit.entity.Creeper;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.painting.PaintingBreakEvent;
import org.bukkit.event.painting.PaintingPlaceEvent;

/**
 * Overwatch Player listener
 * @author CraftRepo
 */
public class OverwatchEntityListener extends EntityListener 
{
    @Override
	public void onCreatureSpawn(CreatureSpawnEvent event)
    {
		// TODO Auto-generated method stub
		super.onCreatureSpawn(event);
	}

	@Override
	public void onCreeperPower(CreeperPowerEvent event)
	{
		// TODO Auto-generated method stub
		super.onCreeperPower(event);
	}

	@Override
	public void onEntityCombust(EntityCombustEvent event) 
	{
		// TODO Auto-generated method stub
		super.onEntityCombust(event);
	}

	@Override
	public void onEntityDamage(EntityDamageEvent event) 
	{
		// TODO Auto-generated method stub
		super.onEntityDamage(event);
	}

	@Override
	public void onEntityDeath(EntityDeathEvent event)
	{
		// TODO Auto-generated method stub
		super.onEntityDeath(event);
	}

	@Override
	public void onEntityExplode(EntityExplodeEvent event)
	{
		// TODO Auto-generated method stub
		super.onEntityExplode(event);
	}

	@Override
	public void onEntityInteract(EntityInteractEvent event) 
	{
		// TODO Auto-generated method stub
		super.onEntityInteract(event);
	}

	@Override
	public void onEntityTarget(EntityTargetEvent event) 
	{
		// TODO Auto-generated method stub
		super.onEntityTarget(event);
	}

	@Override
	public void onExplosionPrime(ExplosionPrimeEvent event) 
	{
		// TODO Auto-generated method stub
		super.onExplosionPrime(event);
	}

	@Override
	public void onPaintingBreak(PaintingBreakEvent event) 
	{
		// TODO Auto-generated method stub
		super.onPaintingBreak(event);
	}

	@Override
	public void onPaintingPlace(PaintingPlaceEvent event)
	{
		// TODO Auto-generated method stub
		super.onPaintingPlace(event);
	}

	@Override
	public void onPigZap(PigZapEvent event)
	{
		// TODO Auto-generated method stub
		super.onPigZap(event);
	}

	private final Overwatchmain plugin;

    public OverwatchEntityListener(final Overwatchmain plugin) 
    {
        this.plugin = plugin;
    }

    //put all Entity related code here
}

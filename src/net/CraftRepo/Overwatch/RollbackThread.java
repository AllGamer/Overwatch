package net.CraftRepo.Overwatch;

import org.bukkit.entity.Player;

public class RollbackThread extends Thread 
{
	private Overwatchmain OverwatchPlugin = null;
	private String target;

	public RollbackThread(Overwatchmain Overwatch, String target)
	{
		this.OverwatchPlugin = Overwatch;
		this.target = target;
	}
	
	public void run()
	{
		Overwatchmain.config.load();
		
		// Add Code to get the sql data and rollback the blocks.
	}
}

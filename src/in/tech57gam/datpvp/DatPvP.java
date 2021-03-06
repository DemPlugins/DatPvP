/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */

package in.tech57gam.datpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;

public class DatPvP extends JavaPlugin
{
	
	public void onEnable() {
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		}
		catch (IOException e) {
			getLogger().info("Error submitting Metrics!");
		}
	}

	public void onDisable()
	{
		// getLogger().info("DatPvP has been disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("pvp"))
			if(args[0].equalsIgnoreCase("enlist"))
			{ // Begin Enlist Block.
				if(player.hasPermission("dat.pvp.activated"))
				{
					player.sendMessage(ChatColor.DARK_RED + "[DatPvP] " + ChatColor.RED + "You are already enlisted!");
					return true;
				}
				if(player.hasPermission("dat.pvp.deactivated"))
				{
					player.sendMessage(ChatColor.GOLD + "[DatPvP] " + ChatColor.YELLOW + player.getName() +  
							" has enlisted in PvP and is now the rank " + ChatColor.GOLD + "Private" + ChatColor.YELLOW + "!");
					Bukkit.getServer().dispatchCommand((Bukkit.getConsoleSender()), "manuadd " + player.getName() + " Private test_pvp_world");
					return true;
				}
				else
				{
					player.sendMessage(ChatColor.DARK_RED + "[DatPvP] " + ChatColor.RED + "You do not have permission.");
					return true;
				}
			}
		
		return false;
		}
	}

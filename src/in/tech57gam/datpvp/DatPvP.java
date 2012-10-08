package in.tech57gam.datpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PvPMain extends JavaPlugin
{
	
	public void onEnable()
	{
		getLogger().info("PvPlugin has been enabled.");
	}
	
	public void onDisable()
	{
		getLogger().info("PvPlugin has been disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("enlist"))
		{ // Begin Enlist Block.
			if(player.hasPermission("dat.pvp.activated"))
			{
				player.sendMessage(ChatColor.DARK_RED + "You're already enlisted!");
				return true;
			} else {
			player.sendMessage(player.getDisplayName() + ChatColor.AQUA +  
					" has enlisted in PvP and is now the rank \"" + 
					ChatColor.GRAY + "[Private]" + ChatColor.AQUA + "\"!");
			Bukkit.getServer().dispatchCommand((Bukkit.getConsoleSender()), "manuadd " + player.getName() + " Private test_pvp_world");
			return true;
			}
		} // End Enlist Block.
		
		
		return false;
	}

}

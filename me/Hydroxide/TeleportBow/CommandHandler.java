package me.Hydroxide.TeleportBow;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

 static ArrayList<Player>enabled = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,	String[] args) {
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tpbow")) {
			if(args.length == 0) {
				player.sendMessage("Specify Args.");
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("on") && !(enabled.contains(player))) {
					enabled.add(player);
				return true;
				} else if (enabled.contains(player)) {
					player.sendMessage(new Main().getConfig().getString("alreadyEnabled").replaceAll("(&([a-f0-9]))", "\u00A7$2").replace("%prefix%", new Main().getConfig().getString("prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2")));
					return false;
				}
				if(args[0].equalsIgnoreCase("off") && (enabled.contains(player))) {
					enabled.remove(player);
					player.sendMessage(new Main().getConfig().getString("disableMessage").replaceAll("(&([a-f0-9]))", "\u00A7$2").replace("%prefix%", new Main().getConfig().getString("prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2")));
					return true;
					} else if (!(enabled.contains(player))) {
						player.sendMessage(new Main().getConfig().getString("alreadyDisabled").replaceAll("(&([a-f0-9]))", "\u00A7$2").replace("%prefix%", new Main().getConfig().getString("prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2")));
						return false;
					}
			}
		}
		
		return false;
	}

}

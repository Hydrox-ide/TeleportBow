package me.Hydroxide.TeleportBow;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class EventListener implements Listener {

	public void onPlayerHitProjectile(ProjectileHitEvent event) {
		if(event.getEntity().getShooter() instanceof Player) {
			Player player = (Player) event.getEntity().getShooter();
			Location tpLoc = event.getEntity().getLocation();
			new CommandHandler();
			if(CommandHandler.enabled.contains(player)) {
			player.teleport(tpLoc);
			player.sendMessage(new Main().getConfig().getString("teleportMessage").replaceAll("(&([a-f0-9]))", "\u00A7$2").replace("%prefix%", new Main().getConfig().getString("prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2")));
			}
		}
	}
	
}

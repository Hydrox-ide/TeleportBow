package me.Hydroxide.TeleportBow;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		FileConfiguration config = getConfig();
		config.addDefault("prefix", "&7[&6TeleportBow&7]");
		config.addDefault("enableMessage", "%prefix% &aTeleportBow has been enabled.");
		config.addDefault("disableMessage", "%prefix% &cTeleportBow has been disabled.");
		config.addDefault("teleportMessage", "%prefix% &eYou have teleported using %prefix%!");
		config.addDefault("alreadyEnabled", "%prefix% &cTeleportBow is already enabled!");
		config.addDefault("alreadyDisabled", "%prefix% &cTeleportBow is already disabled!");
		saveDefaultConfig();
	}
	
}

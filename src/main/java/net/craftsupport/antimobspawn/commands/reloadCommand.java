package net.craftsupport.antimobspawn.commands;

import net.craftsupport.antimobspawn.AntiMobSpawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class reloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        AntiMobSpawn.getPlugin(AntiMobSpawn.class).reloadConfig();
        commandSender.sendMessage("AntiMobRespawn has been reloaded");
        return true;
    }
}

package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BombCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public BombCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("только для игроков)");
            return true;
        }

        else {
            org.bukkit.entity.Player player = (org.bukkit.entity.Player) commandSender;

            player.setVelocity(player.getLocation().getDirection().multiply(2));
            player.sendMessage(ChatColor.GOLD + "You have been bombed!");
            player.getWorld().createExplosion(player.getLocation(), 1.0F, false, false);

            return true;
        }
    }
}

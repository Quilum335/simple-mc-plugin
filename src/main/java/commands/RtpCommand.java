package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import  org.bukkit.entity.Player;
public class RtpCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public RtpCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("Эту команду могут использовать только игроки.");
            return true;
        }

        Player player = (org.bukkit.entity.Player) commandSender;
        double x = Math.random() * 1000;
        double z = Math.random() * 1000;
        player.teleport(new org.bukkit.Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt((int)x, (int)z), z));

        player.sendMessage(ChatColor.WHITE + "Вы рандомно телепортированы!");

        return true;
    }


}

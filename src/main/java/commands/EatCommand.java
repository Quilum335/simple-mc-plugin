package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class EatCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public EatCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("Эту команду могут испоьзовать только люди)");
            return true;
        }

        org.bukkit.entity.Player player = (org.bukkit.entity.Player) commandSender;

        player.getInventory().addItem(new org.bukkit.inventory.ItemStack(org.bukkit.Material.COOKED_BEEF, 1));
        player.sendMessage(org.bukkit.ChatColor.GOLD + "Вы получили стейк! (Погодите реально?)");

        return true;
    }
}

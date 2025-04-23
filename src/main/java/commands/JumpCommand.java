package commands;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.command.CommandExecutor;
import org.bukkit.potion.PotionEffectType;

public class JumpCommand implements CommandExecutor {

    private final org.bukkit.plugin.java.JavaPlugin plugin;

    public JumpCommand(org.bukkit.plugin.java.JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Эту команду нельзя использовать холодильникам."); //ну или другим не игрокам
            return true;
        }

        else if (strings.length == 0) {
            org.bukkit.entity.Player player = (org.bukkit.entity.Player) commandSender;

            player.setVelocity(player.getLocation().getDirection().multiply(2));
            player.sendMessage(org.bukkit.ChatColor.GOLD + "Ты прыгнул.");
            // добавим по приколу эффект усталости от прыжка
            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 1, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 1));
            return true;
        }
        return false;
    }
}

package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.tempis.testCommands.TestCommands;

public class HealCommand implements CommandExecutor {
    public HealCommand(TestCommands testCommands) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Эту команду можно использовать только игрокам.");
            return true;
        }

        Player player = (Player) sender;
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.addPotionEffect(new org.bukkit.potion.PotionEffect(
                org.bukkit.potion.PotionEffectType.REGENERATION,
                20,
                2
        ));
        player.sendMessage("§aВы излечены");
        return true;
    }
}
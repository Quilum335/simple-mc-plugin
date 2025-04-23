package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.tempis.testCommands.TestCommands;

public class SpeeedCommand implements CommandExecutor {
    public SpeeedCommand(TestCommands testCommands) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Проверяем, является ли отправитель игроком
        if (!(sender instanceof Player)) {
            sender.sendMessage("Эту команду можно использовать только в игре.");
            return true;
        }

        Player player = (Player) sender;

        player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 5*20, 10)));
        player.setLevel(1);
        return true;
    }
}





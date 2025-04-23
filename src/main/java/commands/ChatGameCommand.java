package commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.tempis.testCommands.TestCommands;
import org.tempis.testCommands.listeners.ListenerChatGame;

public class ChatGameCommand implements CommandExecutor {
    private final TestCommands plugin;

    public ChatGameCommand(TestCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Эту команду не могут использовать не люди.");
            return true;
        }

        if (strings.length == 0) {
            commandSender.sendMessage("Используйте: /chatgame <start|stop>");
            return true;
        }

        Player player = (Player) commandSender;

        if (strings[0].equalsIgnoreCase("start")) {
            TextComponent message = new TextComponent(ChatColor.GREEN + "[ Нажми чтобы выиграть ]");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/chatgame.win"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder("Нажми для победы!").create()));
            player.spigot().sendMessage(message);
            return true;
        }
        else if (strings[0].equalsIgnoreCase("stop")) {
            player.sendMessage(ChatColor.RED + "Игра остановлена.");
            return true;
        }

        return true;
    }
}
package org.tempis.testCommands;

import commands.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.tempis.testCommands.listeners.ListenerChatGame;
import org.tempis.testCommands.listeners.ListenerGodsCommand;

public final class TestCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("bomb").setExecutor(new BombCommand(this));
        this.getCommand("rtp").setExecutor(new RtpCommand(this));
        this.getCommand("speed").setExecutor(new SpeeedCommand(this));
        this.getCommand("heal").setExecutor(new HealCommand(this));
        this.getCommand("eat").setExecutor(new EatCommand(this));
        this.getCommand("jump").setExecutor(new JumpCommand(this));
        this.getCommand("chatgame").setExecutor(new ChatGameCommand(this));
        this.getCommand("gods").setExecutor(new GodsCommands(this));
        this.getCommand("gods").setTabCompleter(new ListenerGodsCommand());

        this.getServer().getPluginManager().registerEvents(new ListenerChatGame(), this);
    }

    @Override
    public void onDisable() {
        try {
            getLogger().info("'/sudo rm -rf /' - success runtime, wait..."); //Знаю что в проектах не нужно так делать, но в тестах можно))
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

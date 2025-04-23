package commands;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.tempis.testCommands.TestCommands;


public class GodsCommands implements CommandExecutor {
    public GodsCommands(TestCommands testCommands) {
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player )) {
            commandSender.sendMessage("Ты не человек!");
            return true;
        }

        Player player = (Player) commandSender;

        if (strings.length < 1) {return false;}
        else if (strings[0].equalsIgnoreCase("gamemode")) {
            if (strings.length == 1) {return false;}
            String mode = strings[1];
            switch (mode.toLowerCase()) {
                case "survival":
                    player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    player.sendMessage("Вы установили режим выживания.");
                    break;
                case "creative":
                    player.setGameMode(org.bukkit.GameMode.CREATIVE);
                    player.sendMessage("Вы установили режим креатива.");
                    break;
                case "adventure":
                    player.setGameMode(org.bukkit.GameMode.ADVENTURE);
                    player.sendMessage("Вы установили приключенческий режим.");
                    break;
                case "spectator":
                    player.setGameMode(org.bukkit.GameMode.SPECTATOR);
                    player.sendMessage("Вы установили режим наблюдателя.");
                    break;
                default:
                    player.sendMessage("Недопустимый режим игры. Используйте survival, creative, adventure или spectator.");
                    return true;
            }


        }
        else if (strings[0].equalsIgnoreCase("items")) {
            //  массив с вещами с удобным перечеслением
            org.bukkit.inventory.ItemStack[] items;
            items = new org.bukkit.inventory.ItemStack[] {
                new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD, 1),
                new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_PICKAXE, 1),
                new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_AXE, 1),
                new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SHOVEL, 1),
                new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_HELMET, 1),
                new  org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_CHESTPLATE, 1),
                new  org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_LEGGINGS, 1),
                new  org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_BOOTS, 1),
                new  org.bukkit.inventory.ItemStack(Material.BEDROCK, 6400),
                new  org.bukkit.inventory.ItemStack(Material.GOLDEN_APPLE, 64)
            };
            //выдаем игроку все вещи из массива
            for (int i = 0; i < items.length; i++) {
                player.getInventory().addItem(items[i]);
            }
            player.sendMessage("Вы получили набор клоуна!"); //smeshno
            return true;
        }
        else if (strings[0].equalsIgnoreCase("effects")) {
            //  массив с эффектами с удобным перечеслением
            org.bukkit.potion.PotionEffectType[] effects;
            effects = new org.bukkit.potion.PotionEffectType[] {
                org.bukkit.potion.PotionEffectType.SPEED,
                org.bukkit.potion.PotionEffectType.JUMP,
                org.bukkit.potion.PotionEffectType.INCREASE_DAMAGE,
                org.bukkit.potion.PotionEffectType.REGENERATION,
                org.bukkit.potion.PotionEffectType.FIRE_RESISTANCE,
                org.bukkit.potion.PotionEffectType.INVISIBILITY,
                org.bukkit.potion.PotionEffectType.NIGHT_VISION,
                org.bukkit.potion.PotionEffectType.WATER_BREATHING,
                org.bukkit.potion.PotionEffectType.HEALTH_BOOST,
                org.bukkit.potion.PotionEffectType.ABSORPTION
            };
            //выдаем игроку все эффекты из массива
            for (int i = 0; i < effects.length; i++) {
                player.addPotionEffect(new org.bukkit.potion.PotionEffect(effects[i], 999999, 10));
            }
            player.sendMessage("Вы получили набор эффектов");
            return true;
        }
        return false;
    }
}

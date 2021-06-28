package main.java.com.example;

import javax.tools.DocumentationTool.Location;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CutsceneHelper extends JavaPlugin {

    public Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = this;
        sendCommandFeedback("DialogueHelper active");
    }

    @Override
    public void onDisable() {
        sendCommandFeedback("Shutting down, goodbye cruel world.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equals("dialogue")) {
            runCutscene(sender, args); // manage commands
        }
        return false;
    }

    public void runCutscene(CommandSender sender, String[] args) {
        // oh boy oh boy...
        Player player = Bukkit.getPlayer(args[0]);

        setSpectatorMode(player);

        int startX = Integer.parseInt(args[1]);
        int startY = Integer.parseInt(args[2]);
        int startZ = Integer.parseInt(args[3]);

        movePlayerToStartingPos(player, startX, startY, startZ);
    }

    public void setSpectatorMode(Player player) {
        if (player.getGameMode() == GameMode.SPECTATOR) {
            player.setGameMode(GameMode.SURVIVAL);
        } else {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }

    public void movePlayerToStartingPos(Player player, int x, int y, int z) {

        World world = player.getWorld();

        Location loc = new Location(world, x, y, z);

        player.teleport(destination);

    }

    public String formatTextIntoColored(String text) {
        return text.replace('&', '§');
    }

    public void sendCommandFeedback(String message, CommandSender sender) {

        message = formatTextIntoColored(message);

        if (sender instanceof Player) {
            sender.sendMessage(message);
        } else {
            getLogger().info(message);
        }
    }

    public void sendCommandFeedback(String message) {
        sendCommandFeedback(message, null);
    }
}

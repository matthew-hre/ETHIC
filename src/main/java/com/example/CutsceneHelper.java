package main.java.com.example;

import org.bukkit.Bukkit;
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

        int startX = Integer.parseInt(args[1]);
        int startY = Integer.parseInt(args[2]);
        int startZ = Integer.parseInt(args[3]);
        int startAngle = Integer.parseInt(args[4]);

        int endX = Integer.parseInt(args[5]);
        int endY = Integer.parseInt(args[6]);
        int endZ = Integer.parseInt(args[7]);
        int endAngle = Integer.parseInt(args[8]);

        int speed = Integer.parseInt(args[9]);
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

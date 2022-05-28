package main.java.com.example;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ETHIC extends JavaPlugin {

    public Plugin plugin;

    public void onLoad() {

    }

    @Override
    public void onEnable() {
        this.plugin = this;
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        sendCommandFeedback("Enabling ETHIC...");
        sendCommandFeedback("Eco Tracker HUD & Impact Counter (ETHIC) is now active");
    }

    @Override
    public void onDisable() {
        sendCommandFeedback("ETHIC shutting down, goodbye cruel world.");
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

package servercontroll.serverpower_plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerControlPlugin extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("servercontrol")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("stop")) {
                    
                    if (!sender.hasPermission("servercontrol.stop")) {
                        sender.sendMessage("§cDu hast keine Berechtigung, um diesen Befehl auszuführen.");
                        return true;
                    }

                    Bukkit.broadcastMessage("§c[Servercontrol] Der Server wird in 15 Sekunden gestoppt!");

                    Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> Bukkit.shutdown(), 250L);
                    return true;
                } else if (args[0].equalsIgnoreCase("start")) {

                    if (!sender.hasPermission("servercontrol.start")) {
                        sender.sendMessage("§cDu hast keine Berechtigung, um den Server zu stoppen/starten.");
                        return true;
                    }

                    Bukkit.reload();
                    return true;
                }
            }
        }
        return false;
    }
}

package fr.tartur.fnaf.commands;

import fr.tartur.fnaf.commands.common.BaseCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Say extends BaseCommand {

    public Say() {
        super("say", "/say <message>", "say");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;

        Player player = (Player) sender;

        StringBuilder message = new StringBuilder()
                .append("§f[§6").append(player.getName()).append("§f]§e");

        for (String arg : args) {
            message.append(' ').append(arg);
        }

        Bukkit.broadcastMessage(message.toString());

        return true;
    }

}

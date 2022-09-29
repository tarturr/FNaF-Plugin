package fr.tartur.fnaf.common;

import fr.tartur.fnaf.Starter;
import fr.tartur.fnaf.commands.common.BaseCommand;
import fr.tartur.fnaf.commands.common.ParentCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class CommonRecorder {

    private final Starter starter;
    private final PluginManager pluginManager;

    public CommonRecorder(Starter starter) {
        this.starter = starter;
        this.pluginManager = starter.getServer().getPluginManager();
    }

    public CommonRecorder event(Listener event) {
        pluginManager.registerEvents(event, starter);
        return this;
    }

    public CommonRecorder command(BaseCommand baseCommand) {
        PluginCommand command = starter.getCommand(baseCommand.name());

        if (command == null) {
            throw new IllegalArgumentException("The " + baseCommand.name() + " command was not found in the plugin.yml!");
        } else {
            command.setExecutor(baseCommand);
        }

        return this;
    }

    public CommonRecorder command(ParentCommand parentCommand) {
        parentCommand.getSubCommands().forEach(this::command);
        parentCommand.getParentSubCommands().forEach(this::command);

        return this;
    }

}

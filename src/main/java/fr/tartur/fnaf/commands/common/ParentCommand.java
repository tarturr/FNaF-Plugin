package fr.tartur.fnaf.commands.common;

import java.util.ArrayList;
import java.util.List;

public class ParentCommand {

    private final List<BaseCommand> subCommands;
    private final List<ParentCommand> parentSubCommands;

    public ParentCommand() {
        this.subCommands = new ArrayList<>();
        this.parentSubCommands = new ArrayList<>();
    }

    public ParentCommand subCommand(BaseCommand command) {
        this.subCommands.add(command);
        return this;
    }

    public ParentCommand parentSubCommand(ParentCommand command) {
        this.parentSubCommands.add(command);
        return this;
    }

    public List<BaseCommand> getSubCommands() {
        return subCommands;
    }

    public List<ParentCommand> getParentSubCommands() {
        return parentSubCommands;
    }
}

package fr.tartur.fnaf.commands.common;

import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommand implements CommandExecutor {

    protected final String baseName;
    protected final String baseUsage;
    protected final String basePermission;

    protected BaseCommand parent;
    protected final List<BaseCommand> childs;

    public BaseCommand(String name, String usage, String permission) {
        this.baseName = name.toLowerCase();
        this.baseUsage = usage;
        this.basePermission = "fnaf." + permission;
        this.childs = new ArrayList<>();
    }

    public String name() {
        return this.baseName;
    }
}

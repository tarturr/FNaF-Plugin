package fr.tartur.fnaf;

import fr.tartur.fnaf.events.GameEvents;
import fr.tartur.fnaf.events.ItemEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Starter extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new GameEvents(), this);
        manager.registerEvents(new ItemEvents(), this);

        System.out.println("Welcome to the FNaF Minecraft world. Enjoy!");
    }

    @Override
    public void onDisable() {
        System.out.println("See you later in the Freddy's pizzeria!");
    }

}

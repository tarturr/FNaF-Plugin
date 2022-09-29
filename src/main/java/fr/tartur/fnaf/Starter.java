package fr.tartur.fnaf;

import fr.tartur.fnaf.common.CommonRecorder;
import fr.tartur.fnaf.commands.Say;
import fr.tartur.fnaf.events.Join;
import org.bukkit.plugin.java.JavaPlugin;

public final class Starter extends JavaPlugin {

    @Override
    public void onEnable() {
        CommonRecorder recorder = new CommonRecorder(this);

        /*

        recorder.command(
            new ParentCommand()
                    .subCommand(new SubCommand())
                    .subParentCommand(new SubParentCommand())
            )
        );

         */

        recorder.command(new Say());
        recorder.event(new Join());

        System.out.println("Welcome to the FNaF Minecraft world. Enjoy!");
    }

    @Override
    public void onDisable() {
        System.out.println("See you later in the Freddy's pizzeria!");
    }

}

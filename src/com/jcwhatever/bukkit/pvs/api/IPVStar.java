package com.jcwhatever.bukkit.pvs.api;

import com.jcwhatever.bukkit.generic.commands.AbstractCommandHandler;
import com.jcwhatever.bukkit.generic.events.GenericsEventManager;
import com.jcwhatever.bukkit.generic.inventory.KitManager;
import com.jcwhatever.bukkit.generic.language.LanguageManager;
import com.jcwhatever.bukkit.generic.signs.SignManager;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.extensions.ExtensionTypeManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.ArenaManager;
import com.jcwhatever.bukkit.pvs.api.modules.ModuleInfo;
import com.jcwhatever.bukkit.pvs.api.modules.PVStarModule;
import com.jcwhatever.bukkit.pvs.api.points.PointsManager;
import com.jcwhatever.bukkit.pvs.api.scripting.ScriptManager;
import com.jcwhatever.bukkit.pvs.api.spawns.SpawnTypeManager;
import com.jcwhatever.bukkit.pvs.api.stats.StatsManager;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.List;

/**
 *
 * Interface for the PV-Star plugin implementation
 *
 */
public interface IPVStar extends Plugin  {

    /**
     * Determine if PV-Star is in debug mode.
     */
    boolean isDebugging();

    /**
     * Get an arena player wrapper for the player object.
     *
     * @param player  The player object to wrap.
     */
    ArenaPlayer getArenaPlayer(Object player);

    /**
     * Get PV-Stars {@code ArenaManager} implementation.
     */
    ArenaManager getArenaManager();

    /**
     * Get PV-Stars {@code SpawnTypeManager} implementation.
     */
    SpawnTypeManager getSpawnTypeManager();

    /**
     * Get PV-Stars {@code StatsManager} implementation.
     * @return
     */
    StatsManager getStatsManager();

    /**
     * Get PV-Stars {@code GlobalExtensionManager} implementation.
     */
    ExtensionTypeManager getExtensionManager();

    /**
     * Get PV-Stars {@code PointsManager} implementation.
     */
    PointsManager getPointsManager();

    /**
     * Get PV-Stars {@code KitManager}.
     */
    KitManager getKitManager();

    /**
     * Get PV-Stars {@code SignManager}.
     */
    SignManager getSignManager();

    /**
     * Get PV-Stars {@code LanguageManager}.
     */
    LanguageManager getLanguageManager();

    /**
     * Get PV-Stars command handler.
     */
    AbstractCommandHandler getCommandHandler();

    /**
     * Get PV-Stars global arena event manager.
     */
    GenericsEventManager getEventManager();

    /**
     * Get PV-Stars script engine manager.
     */
    ScriptManager getScriptManager();

    /**
     * Get a loaded {@code PVStarModule} instance  by case sensitive module name.
     *
     * @param name  The name of the {@code PVStarModule} module
     */
    @Nullable
    PVStarModule getModule(String name);

    /**
     * Get all loaded {@code PVStarModule} instances.
     */
    List<PVStarModule> getModules();

    /**
     * Get information about a module.
     *
     * @param module  The module to get information about.
     */
    ModuleInfo getModuleInfo(PVStarModule module);

}

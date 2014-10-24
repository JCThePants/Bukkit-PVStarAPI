package com.jcwhatever.bukkit.pvs.api;

import com.jcwhatever.bukkit.generic.commands.AbstractCommandHandler;
import com.jcwhatever.bukkit.generic.events.GenericsEventManager;
import com.jcwhatever.bukkit.generic.inventory.KitManager;
import com.jcwhatever.bukkit.generic.language.LanguageManager;
import com.jcwhatever.bukkit.generic.signs.SignManager;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.extensions.ExtensionTypeManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.ArenaManager;
import com.jcwhatever.bukkit.pvs.api.points.PointsManager;
import com.jcwhatever.bukkit.pvs.api.scripting.ScriptManager;
import com.jcwhatever.bukkit.pvs.api.spawns.SpawnTypeManager;
import com.jcwhatever.bukkit.pvs.api.stats.StatsManager;

/**
 * PV-Star static API
 */
public final class PVStarAPI {

    private PVStarAPI() {}

	private static IPVStar _implementation;

    /**
     * Get an {@code ArenaPlayer} wrapper for the specified player.
     *
     * @param player  The player.
     */
    public static ArenaPlayer getArenaPlayer(Object player) {
        return _implementation.getArenaPlayer(player);
    }

    /**
     * Get the arena manager.
     */
    public static ArenaManager getArenaManager() {
        return _implementation.getArenaManager();
    }

    /**
     * Get the spawn type manager.
     */
    public static SpawnTypeManager getSpawnTypeManager() {
        return _implementation.getSpawnTypeManager();
    }

    /**
     * Get the command handler.
     */
    public static AbstractCommandHandler getCommandHandler() {
        return _implementation.getCommandHandler();
    }

    /**
     * Get the statistics manager.
     */
    public static StatsManager getStatsManager() {
        return _implementation.getStatsManager();
    }

    /**
     * Get the points manager.
     */
    public static PointsManager getPointsManager() {
        return _implementation.getPointsManager();
    }

    /**
     * Get the kit manager.
     */
    public static KitManager getKitManager() {
        return _implementation.getKitManager();
    }

    /**
     * Get the sign manager.
     */
    public static SignManager getSignManager() {
        return _implementation.getSignManager();
    }

    /**
     * Get the language manager.
     */
    public static LanguageManager getLanguageManager() {
        return _implementation.getLanguageManager();
    }

    /**
     * Get the global extension manager.
     */
    public static ExtensionTypeManager getExtensionManager() {
        return _implementation.getExtensionManager();
    }

    /**
     * Get the global arena event manager. Use the arenas
     * event manager instead if you need to subscribe to events
     * for a specific arena.
     */
    public static GenericsEventManager getEventManager() {
        return _implementation.getEventManager();
    }

    /**
     * Get PV-Star's global script manager.
     */
    public static ScriptManager getScriptManager() {
        return _implementation.getScriptManager();
    }

    /**
     * Get the PV-Star plugin implementation.
     */
    public static IPVStar getPlugin() {
        return _implementation;
    }

    /**
     * For Internal Use.
     */
    public static void setImplementation(IPVStar implementation) {
        _implementation = implementation;
    }
	
}

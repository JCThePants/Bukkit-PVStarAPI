/*
 * This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
 *
 * Copyright (c) JCThePants (www.jcwhatever.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package com.jcwhatever.bukkit.pvs.api;

import com.jcwhatever.nucleus.commands.CommandDispatcher;
import com.jcwhatever.nucleus.events.manager.EventManager;
import com.jcwhatever.nucleus.utils.kits.KitManager;
import com.jcwhatever.nucleus.signs.SignManager;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.extensions.ExtensionTypeManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.ArenaManager;
import com.jcwhatever.bukkit.pvs.api.commands.CommandHelper;
import com.jcwhatever.bukkit.pvs.api.points.PointsManager;
import com.jcwhatever.bukkit.pvs.api.spawns.SpawnTypeManager;
import com.jcwhatever.bukkit.pvs.api.stats.StatsManager;

/**
 * PV-Star static API
 */
public final class PVStarAPI {

    private PVStarAPI() {}

	private static IPVStar _implementation;

    /**
     * Get an {@link ArenaPlayer} wrapper for the specified player.
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
    public static CommandDispatcher getCommandHandler() {
        return _implementation.getCommandHandler();
    }

    /**
     * Get the command helper.
     */
    public static CommandHelper getCommandHelper() {
        return _implementation.getCommandHelper();
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
    public static EventManager getEventManager() {
        return _implementation.getEventManager();
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

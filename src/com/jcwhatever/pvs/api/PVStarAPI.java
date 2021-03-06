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


package com.jcwhatever.pvs.api;

import com.jcwhatever.nucleus.events.manager.EventManager;
import com.jcwhatever.nucleus.managed.commands.ICommandDispatcher;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.extensions.IExtensionTypeManager;
import com.jcwhatever.pvs.api.arena.managers.IArenaManager;
import com.jcwhatever.pvs.api.commands.ICommandHelper;
import com.jcwhatever.pvs.api.points.IPointsManager;
import com.jcwhatever.pvs.api.spawns.ISpawnTypeManager;
import com.jcwhatever.pvs.api.stats.IStatsManager;

import javax.annotation.Nullable;

/**
 * PV-Star static API
 */
public final class PVStarAPI {

    private PVStarAPI() {}

	private static IPVStar _implementation;

    /**
     * Get an {@link IArenaPlayer} wrapper for the specified player.
     *
     * @param player  The player.
     *
     * @return The player object or null if the argument is not valid.
     */
    @Nullable
    public static IArenaPlayer getArenaPlayer(Object player) {
        return _implementation.getArenaPlayer(player);
    }

    /**
     * Get the arena manager.
     */
    public static IArenaManager getArenaManager() {
        return _implementation.getArenaManager();
    }

    /**
     * Get the spawn type manager.
     */
    public static ISpawnTypeManager getSpawnTypeManager() {
        return _implementation.getSpawnTypeManager();
    }

    /**
     * Get the command handler.
     */
    public static ICommandDispatcher getCommandDispatcher() {
        return _implementation.getCommandDispatcher();
    }

    /**
     * Get the command helper.
     */
    public static ICommandHelper getCommandHelper() {
        return _implementation.getCommandHelper();
    }

    /**
     * Get the statistics manager.
     */
    public static IStatsManager getStatsManager() {
        return _implementation.getStatsManager();
    }

    /**
     * Get the points manager.
     */
    public static IPointsManager getPointsManager() {
        return _implementation.getPointsManager();
    }

    /**
     * Get the global extension manager.
     */
    public static IExtensionTypeManager getExtensionManager() {
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

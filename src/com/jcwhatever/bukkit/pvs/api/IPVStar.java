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
import com.jcwhatever.nucleus.kits.KitManager;
import com.jcwhatever.nucleus.messaging.IMessenger;
import com.jcwhatever.nucleus.signs.SignManager;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.extensions.ExtensionTypeManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.ArenaManager;
import com.jcwhatever.bukkit.pvs.api.commands.CommandHelper;
import com.jcwhatever.bukkit.pvs.api.modules.ModuleInfo;
import com.jcwhatever.bukkit.pvs.api.modules.PVStarModule;
import com.jcwhatever.bukkit.pvs.api.points.PointsManager;
import com.jcwhatever.bukkit.pvs.api.spawns.SpawnTypeManager;
import com.jcwhatever.bukkit.pvs.api.stats.StatsManager;

import org.bukkit.plugin.Plugin;

import java.util.List;
import javax.annotation.Nullable;

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
     * Get PV-Stars command handler.
     */
    CommandDispatcher getCommandHandler();

    /**
     * Get command helper that contains utilities methods for commands.
     */
    CommandHelper getCommandHelper();

    /**
     * Get PV-Stars global arena event manager.
     */
    EventManager getEventManager();

    /**
     * Get PV-Stars chat and console messenger.
     */
    IMessenger getMessenger();

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

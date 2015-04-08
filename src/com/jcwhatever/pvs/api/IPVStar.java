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
import com.jcwhatever.nucleus.managed.messaging.IMessenger;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.extensions.IExtensionTypeManager;
import com.jcwhatever.pvs.api.arena.managers.IArenaManager;
import com.jcwhatever.pvs.api.commands.ICommandHelper;
import com.jcwhatever.pvs.api.modules.IModuleInfo;
import com.jcwhatever.pvs.api.modules.PVStarModule;
import com.jcwhatever.pvs.api.points.IPointsManager;
import com.jcwhatever.pvs.api.spawns.ISpawnTypeManager;
import com.jcwhatever.pvs.api.stats.IStatsManager;

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
    IArenaPlayer getArenaPlayer(Object player);

    /**
     * Get PV-Stars {@link IArenaManager} implementation.
     */
    IArenaManager getArenaManager();

    /**
     * Get PV-Stars {@link ISpawnTypeManager} implementation.
     */
    ISpawnTypeManager getSpawnTypeManager();

    /**
     * Get PV-Stars {@link IStatsManager} implementation.
     */
    IStatsManager getStatsManager();

    /**
     * Get PV-Stars {@link IExtensionTypeManager} implementation.
     */
    IExtensionTypeManager getExtensionManager();

    /**
     * Get PV-Stars {@link IPointsManager} implementation.
     */
    IPointsManager getPointsManager();

    /**
     * Get PV-Stars command handler.
     */
    ICommandDispatcher getCommandDispatcher();

    /**
     * Get command helper that contains utilities methods for commands.
     */
    ICommandHelper getCommandHelper();

    /**
     * Get PV-Stars global arena event manager.
     */
    EventManager getEventManager();

    /**
     * Get PV-Stars chat and console messenger.
     */
    IMessenger getMessenger();

    /**
     * Get a loaded {@link PVStarModule} instance  by case sensitive module name.
     *
     * @param name  The name of the {@link PVStarModule} module
     */
    @Nullable
    PVStarModule getModule(String name);

    /**
     * Get all loaded {@link PVStarModule} instances.
     */
    List<PVStarModule> getModules();

    /**
     * Get information about a module.
     *
     * @param module  The module to get information about.
     */
    IModuleInfo getModuleInfo(PVStarModule module);
}

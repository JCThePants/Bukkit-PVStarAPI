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


package com.jcwhatever.pvs.api.arena;

import com.jcwhatever.nucleus.events.manager.EventManager;
import com.jcwhatever.nucleus.mixins.INamedInsensitive;
import com.jcwhatever.nucleus.providers.permissions.IPermission;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.pvs.api.arena.extensions.ArenaExtension;
import com.jcwhatever.pvs.api.arena.extensions.IArenaExtensionManager;
import com.jcwhatever.pvs.api.arena.context.IGameContext;
import com.jcwhatever.pvs.api.arena.context.ILobbyContext;
import com.jcwhatever.pvs.api.arena.managers.ISpawnManager;
import com.jcwhatever.pvs.api.arena.context.ISpectatorContext;
import com.jcwhatever.pvs.api.arena.managers.ITeamManager;
import com.jcwhatever.pvs.api.arena.settings.IArenaSettings;
import com.jcwhatever.pvs.api.modules.PVStarModule;

import java.io.File;
import java.util.UUID;

/**
 * Arena interface
 */
public interface IArena extends INamedInsensitive {

    /**
     * Get the arenas name in lower case letters.
     */
    @Override
    String getSearchName();

    /**
     * Set the name of the arena.
     *
     * @param name  The arena name.
     */
    void setName(String name);

    /**
     * Get the arenas unique ID.
     */
    UUID getId();

    /**
     * Determine if the arena is busy.
     *
     * <p>No actions can be performed while the arena is busy.</p>
     *
     * <p>Arena may be busy after a game ends while it performs cleanup.</p>
     */
    boolean isBusy();

    /**
     * Set the arenas busy state.
     */
    void setBusy();

    /**
     * Set the idles busy state to idle.
     */
    void setIdle();

    /**
     * Get the arenas event manager.
     */
    EventManager getEventManager();

    /**
     * Get the arenas lobby manager.
     */
    ILobbyContext getLobby();

    /**
     * Get the arenas game manager.
     */
    IGameContext getGame();

    /**
     * Get the arenas spectator manager.
     */
    ISpectatorContext getSpectators();

    /**
     * Get the arenas team manager.
     */
    ITeamManager getTeams();

    /**
     * Get the arenas spawn point manager.
     */
    ISpawnManager getSpawns();

    /**
     * Get the arenas extension manager.
     */
    IArenaExtensionManager getExtensions();

    /**
     * Get the arenas settings.
     */
    IArenaSettings getSettings();

    /**
     * Get the arenas data folder.
     *
     * <p>This is where modules should store data for an arena.</p>
     */
    File getDataFolder(PVStarModule module);

    /**
     * Get the arenas data folder.
     *
     * <p>This is where arena extensions should store data for an arena.</p>
     */
    File getDataFolder(ArenaExtension module);

    /**
     * Get a data storage node from the arena.
     */
    IDataNode getDataNode(String nodeName);

    /**
     * Get the permission players must have in order to join the arena.
     */
    IPermission getPermission();

    /**
     * Get the arenas region.
     */
    ArenaRegion getRegion();

    /**
     * Get the number of available player slots left to join.
     */
    int getAvailableSlots();

    /**
     * Determine if players can join the arena.
     */
    boolean canJoin();

    /**
     * Join a player to the arena.
     *
     * @param player  The joining player.
     *
     * @return  True if the player was added to the arena.
     */
    boolean join(IArenaPlayer player);
}

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


package com.jcwhatever.bukkit.pvs.api.arena;

import com.jcwhatever.nucleus.events.manager.EventManager;
import com.jcwhatever.nucleus.mixins.IDisposable;
import com.jcwhatever.nucleus.mixins.INamedInsensitive;
import com.jcwhatever.nucleus.providers.permissions.IPermission;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.bukkit.pvs.api.arena.extensions.ArenaExtension;
import com.jcwhatever.bukkit.pvs.api.arena.extensions.ArenaExtensionManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.GameManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.LobbyManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.SpawnManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.SpectatorManager;
import com.jcwhatever.bukkit.pvs.api.arena.managers.TeamManager;
import com.jcwhatever.bukkit.pvs.api.arena.options.RemovePlayerReason;
import com.jcwhatever.bukkit.pvs.api.arena.settings.ArenaSettings;
import com.jcwhatever.bukkit.pvs.api.modules.PVStarModule;

import java.io.File;
import java.util.UUID;

/**
 * Arena interface
 */
public interface Arena extends INamedInsensitive, IDisposable {

    /**
     * Get the arenas name.
     */
    @Override
    String getName();

    /**
     * Set the arenas name.
     *
     * @param name  The name of the arena.
     */
    void setName(String name);

    /**
     * Get the arenas name in lower case letters.
     */
    @Override
    String getSearchName();

    /**
     * Get the arenas unique ID.
     */
    UUID getId();

    /**
     * Determine if the arena is busy. No actions
     * can be performed while the arena is busy.
     *
     * Arena may be busy after a game ends while it performs cleanup.
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
    LobbyManager getLobbyManager();

    /**
     * Get the arenas game manager.
     */
    GameManager getGameManager();

    /**
     * Get the arenas spectator manager.
     */
    SpectatorManager getSpectatorManager();

    /**
     * Get the arenas team manager.
     */
    TeamManager getTeamManager();

    /**
     * Get the arenas spawn point manager.
     */
    SpawnManager getSpawnManager();

    /**
     * Get the arenas extension manager.
     */
    ArenaExtensionManager getExtensionManager();

    /**
     * Get the arenas settings.
     */
    ArenaSettings getSettings();

    /**
     * Get the arenas data folder. This is where modules should
     * store data for an arena.
     */
    File getDataFolder(PVStarModule module);

    /**
     * Get the arenas data folder. This is where arena extensions
     * should store data for an arena.
     */
    File getDataFolder(ArenaExtension module);

    /**
     * Get a data storage node from the arena.
     */
    IDataNode getDataNode(String nodeName);

    /**
     * Get the permission players must have in order
     * to join the arena.
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
     * Determine if the specified player is in the arena.
     * 
     * @param player  The player to check.
     */
    boolean hasPlayer(ArenaPlayer player);

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
    boolean join(ArenaPlayer player);

    /**
     * Remove a player from the arena. Should not be used for arena relation
     * changes or forwarding.
     *
     * @param player  The player to remove.
     * @param reason  The reason the player is being removed.
     *
     * @return  True if the player was removed.
     */
    boolean remove(ArenaPlayer player, RemovePlayerReason reason);

    /**
     * Invoked when the arena is initialized by the arena manager.
     * For arena manager use only.
     *
     * @param id        The arenas id.
     * @param name      The name of the arena.
     */
    void init(UUID id, String name);

    /**
     * Invoked when an arena is permanently removed.
     * For arena manager use only.
     */
    @Override
    void dispose();
}

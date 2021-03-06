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


package com.jcwhatever.pvs.api.arena.managers;

import com.jcwhatever.pvs.api.arena.ArenaTeam;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.mixins.IArenaOwned;
import com.jcwhatever.pvs.api.arena.options.ArenaContext;
import com.jcwhatever.pvs.api.spawns.SpawnType;
import com.jcwhatever.pvs.api.spawns.Spawnpoint;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * Manages an arenas spawn points.
 */
public interface ISpawnManager extends IArenaOwned {

    /**
     * Determine if there are lobby spawns available.
     */
    boolean hasLobbySpawns();

    /**
     * Determine if there are game spawns available.
     */
    boolean hasGameSpawns();

    /**
     * Determine if there are spectator spawns available.
     */
    boolean hasSpectatorSpawns();

    /**
     * Get all spawn points for a specific context.
     */
    List<Spawnpoint> getAll(ArenaContext context);

    /**
     * Get all spawnpoints
     */
    List<Spawnpoint> getAll();

    /**
     * Get all spawnpoints from a comma delimited string of spawn names.
     *
     * @param names  The names of the spawns to retrieve.
     */
    List<Spawnpoint> getAll(String names);

    /**
     * Get all spawns of the specified type.
     *
     * @param type  The spawn type.
     */
    List<Spawnpoint> getAll(SpawnType type);

    /**
     * Get all spawns for the specified team.
     *
     * @param team  The arena team.
     */
    List<Spawnpoint> getAll(ArenaTeam team);

    /**
     * Get all spawns for the specified team.
     *
     * @param team     The arena team.
     * @param context  The context of the spawn type.
     */
    List<Spawnpoint> getAll(ArenaTeam team, ArenaContext context);

    /**
     * Get all spawns for the specified team and type.
     *
     * @param type  The spawn type.
     * @param team  The arena team.
     */
    List<Spawnpoint> getAll(SpawnType type, ArenaTeam team);

    /**
     * Get a spawn by it's name.
     *
     * @param name  The name of the spawn.
     */
    @Nullable
    Spawnpoint get(String name);

    /**
     * Add a spawnpoint.
     *
     * @param spawn  The spawnpoint to add.
     */
    boolean add(Spawnpoint spawn);

    /**
     * Add a collection of spawnpoints.
     *
     * @param spawns  The collection to add
     */
    void addAll(Collection<? extends Spawnpoint> spawns);

    /**
     * Remove a spawnpoint.
     *
     * @param spawn  The spawnpoint to remove.
     *
     * @return  True if the spawnpoint was found and removed.
     */
    boolean remove(Spawnpoint spawn);

    /**
     * Remove a collection of spawnpoints.
     *
     * @param spawns  The collection to remove.
     */
    void removeAll(Collection<? extends Spawnpoint> spawns);

    /**
     * Reserves a spawn point for a player by removing it as a candidate
     * for the managers getter methods (getRandomSpawn, getSpawns, etc).
     *
     * @param player  The player to reserve the spawn for.
     * @param spawn   The spawnpoint to reserve.
     */
    void reserve(IArenaPlayer player, Spawnpoint spawn);

    /**
     * Removes the reserved status of the spawnpoint reserved for a player
     * and makes it available via the managers spawnpoint getter methods.
     *
     * @param player  The player the spawn was reserved for.
     */
    void unreserve(IArenaPlayer player);

    /**
     * Clear all reserved spawns and make them available via the managers
     * spawnpoint getter methods.
     */
    void clearReserved();

    /**
     * Get the total number of reserved spawns.
     */
    int totalReserved();

    /**
     * Get the number of spawns of the specified type that are reserved.
     *
     * @param spawnType  The spawn type.
     */
    int totalReserved(SpawnType spawnType);
}


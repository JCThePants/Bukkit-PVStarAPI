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

import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.ArenaTeam;
import com.jcwhatever.pvs.api.spawns.SpawnType;
import com.jcwhatever.pvs.api.spawns.Spawnpoint;

import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Manages an arenas spawn points.
 */
public interface ISpawnManager {

    /**
     * Get the arena the spawn manager is managing.
     */
    IArena getArena();

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
     * Get all lobby spawn points. If there are no
     * lobby spawns, returns all game spawns.
     */
    List<Spawnpoint> getLobbyOrGameSpawns();

    /**
     * Get all lobby spawn points.
     */
    List<Spawnpoint> getLobbySpawns();

    /**
     * Get all game spawn points.
     */
    List<Spawnpoint> getGameSpawns();

    /**
     * Get all spectator spawn points.
     */
    List<Spawnpoint> getSpectatorSpawns();

    /**
     * Get a random spawn for a player. The spawn returned correlates
     * to the players current arena relation. (i.e player in lobby gets a lobby spawn)
     *
     * @param player  The player to get a random spawn for.
     *
     * @return  Null if the player is not in an arena.
     */
    @Nullable
    Spawnpoint getRandomSpawn(IArenaPlayer player);

    /**
     * Get a random lobby spawn.
     *
     * @param team  The team the spawn is for.
     */
    @Nullable
    Spawnpoint getRandomLobbySpawn(ArenaTeam team);


    /**
     * Get a random game spawn.
     *
     * @param team  The team the spawn is for.
     */
    @Nullable
    Spawnpoint getRandomGameSpawn(ArenaTeam team);

    /**
     * Get a random spectator spawn.
     *
     * @param team  The team the spawn is for.
     */
    @Nullable
    Spawnpoint getRandomSpectatorSpawn(ArenaTeam team);

    /**
     * Get all spawnpoints
     */
    List<Spawnpoint> getSpawns();

    /**
     * Get all spawnpoints from a comma delimited string of spawn names.
     *
     * @param names  The names of the spawns to retrieve.
     */
    List<Spawnpoint> getSpawns(String names);

    /**
     * Get all spawns of the specified type.
     *
     * @param type  The spawn type.
     */
    List<Spawnpoint> getSpawns(SpawnType type);

    /**
     * Get all spawns for the specified team.
     *
     * @param team  The arena team.
     */
    List<Spawnpoint> getSpawns(ArenaTeam team);

    /**
     * Get all spawns for the specified team and type.
     *
     * @param type  The spawn type.
     * @param team  The arena team.
     */
    List<Spawnpoint> getSpawns(SpawnType type, ArenaTeam team);

    /**
     * Get a spawn by it's name.
     *
     * @param name  The name of the spawn.
     */
    @Nullable
    Spawnpoint getSpawn(String name);

    /**
     * Add a spawnpoint.
     *
     * @param spawn  The spawnpoint to add.
     */
    boolean addSpawn(Spawnpoint spawn);

    /**
     * Add a collection of spawnpoints.
     *
     * @param spawns  The collection to add
     */
    void addSpawns(Collection<? extends Spawnpoint> spawns);

    /**
     * Remove a spawnpoint.
     *
     * @param spawn  The spawnpoint to remove.
     *
     * @return  True if the spawnpoint was found and removed.
     */
    boolean removeSpawn(Spawnpoint spawn);

    /**
     * Remove a collection of spawnpoints.
     *
     * @param spawns  The collection to remove.
     */
    void removeSpawns(Collection<? extends Spawnpoint> spawns);


    /**
     * Reserves a spawn point for a player by removing it as a candidate
     * for the managers getter methods (getRandomSpawn, getSpawns, etc).
     *
     * @param player  The player to reserve the spawn for.
     * @param spawn   The spawnpoint to reserve.
     */
    void reserveSpawn(IArenaPlayer player, Spawnpoint spawn);

    /**
     * Removes the reserved status of the spawnpoint reserved for a player
     * and makes it available via the managers spawnpoint getter methods.
     *
     * @param player  The player the spawn was reserved for.
     */
    void unreserveSpawn(IArenaPlayer player);

    /**
     * Clear all reserved spawns and make them available via the managers
     * spawnpoint getter methods.
     */
    void clearReserved();
}


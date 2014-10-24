package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.spawns.SpawnType;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Manages an arenas spawn points.
 */
public interface SpawnManager {

    /**
     * Get the arena the spawn manager is managing.
     */
    Arena getArena();

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
    Spawnpoint getRandomSpawn(ArenaPlayer player);

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
     * Get all teams available from the spawns
     */
    Set<ArenaTeam> getTeams();

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
    void addSpawns(Collection<Spawnpoint> spawns);

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
    void removeSpawns(Collection<Spawnpoint> spawns);


    /**
     * Reserves a spawn point for a player by removing it as a candidate
     * for the managers getter methods (getRandomSpawn, getSpawns, etc).
     *
     * @param p      The player to reserve the spawn for.
     * @param spawn  The spawnpoint to reserve.
     */
    void reserveSpawn(ArenaPlayer p, Spawnpoint spawn);

    /**
     * Removes the reserved status of the spawnpoint reserved for a player
     * and makes it available via the managers spawnpoint getter methods.
     *
     * @param p  The player the spawn was reserved for.
     */
    void unreserveSpawn(ArenaPlayer p);

    /**
     * Clear all reserved spawns and make them available via the managers
     * spawnpoint getter methods.
     */
    void clearReserved();


}


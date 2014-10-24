package com.jcwhatever.bukkit.pvs.api.arena;

import java.util.Collection;
import java.util.List;

/**
 * A group of players associated with each other due
 * to starting an arena together, regardless of team.
 *
 * <p>Players stay in the same group when they are forwarded
 * to other arenas.</p>
 */
public interface ArenaPlayerGroup {

    /**
     * Determine if the group has a player.
     *
     * @param player  The player to check for.
     * @return
     */
    boolean hasPlayer(ArenaPlayer player);

    /**
     * Get the number of players in the group.
     * @return
     */
    int size();

    /**
     * Get the number of players of the group who are in the specified arena.
     *
     * @param arena  The arena.
     */
    int size(Arena arena);

    /**
     * Determine if players in the provided collection are ready.
     *
     * <p>Disregards players that are not in the group.</p>
     *
     * @param players  The players to check.
     */
    boolean isReady(Collection<ArenaPlayer> players);

    /**
     * Filters the collection of players to players that are in the group
     *
     * @param players  The collection of players to filter.
     * @return
     */
    List<ArenaPlayer> filterPlayers(Collection<ArenaPlayer> players);

    /**
     * Tell a message to all players in the group.
     *
     * @param message  The message to send.
     * @param params   The message parameters.
     */
    void tell(String message, Object... params);

    /**
     * Add a player to the group.
     *
     * <p>Automatically removes a player from their current group, if any.</p>
     *
     * @param player  The player to add.
     */
    void addPlayer(ArenaPlayer player);

    /**
     * Remove a player from the group.
     *
     * @param player  The player to remove.
     */
    void removePlayer(ArenaPlayer player);

    /**
     * Get all players in the group
     */
    List<ArenaPlayer> getPlayers();

    /**
     * Get players in the group who are in the specified arena.
     *
     * @param arena  The arena.
     */
    List<ArenaPlayer> getPlayers(Arena arena);


}

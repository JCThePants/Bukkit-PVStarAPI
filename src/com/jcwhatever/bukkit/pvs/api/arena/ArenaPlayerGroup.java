/* This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
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

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


package com.jcwhatever.pvs.api.events.players;

import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.collections.IArenaPlayerCollection;
import com.jcwhatever.pvs.api.events.AbstractArenaEvent;
import com.jcwhatever.pvs.api.utils.ArenaPlayerHashSet;

import java.util.Collection;

/**
 * Use to check if other modules are willing to allow a player to join an arena
 * without the player actually joining the arena.
 *
 * <p>To prevent a player from joining, handle the {@link PlayerPreJoinArenaEvent}
 * instead.</p>
 *
 * <p>Multiple players can be checked at the same time. The players should be
 * rechecked by the calling module in case other modules remove or add players.
 * Adding players to the player collection implies that the players are part of
 * a party.</p>
 */
public class PlayerJoinQueryEvent extends AbstractArenaEvent {

    private IArenaPlayerCollection _players;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player to check.
     */
    public PlayerJoinQueryEvent(IArena arena, IArenaPlayer player) {
        super(arena);

        _players = new ArenaPlayerHashSet(5);
        _players.add(player);
    }

    /**
     * Constructor.
     *
     * @param arena    The event arena.
     * @param players  The players to check.
     */
    public PlayerJoinQueryEvent(IArena arena, Collection<IArenaPlayer> players) {
        super(arena);

        _players = new ArenaPlayerHashSet(players.size() * 2);
        _players.addAll(players);
    }

    /**
     * Get the players being checked.
     */
    public IArenaPlayerCollection getPlayers() {
        return _players;
    }
}

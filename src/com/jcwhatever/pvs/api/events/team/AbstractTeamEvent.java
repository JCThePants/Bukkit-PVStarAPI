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


package com.jcwhatever.pvs.api.events.team;

import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.collections.IArenaPlayerCollection;
import com.jcwhatever.pvs.api.arena.ArenaTeam;
import com.jcwhatever.pvs.api.events.AbstractArenaEvent;

/**
 * An arena event that deals with a team
 */
public abstract class AbstractTeamEvent extends AbstractArenaEvent {

    private final ArenaTeam _team;
    private final IArenaPlayerCollection _teamPlayers;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param team           The event team.
     * @param teamPlayers    The players on the team.
     */
    public AbstractTeamEvent(IArena arena, ArenaTeam team, IArenaPlayerCollection teamPlayers) {
        super(arena);

        PreCon.notNull(team);
        PreCon.notNull(teamPlayers);

        _team = team;
        _teamPlayers = teamPlayers;
    }

    /**
     * Get the event team.
     */
    public ArenaTeam getTeam() {
        return _team;
    }

    /**
     * Get the players on the team in an unmodifiable list.
     */
    public IArenaPlayerCollection getTeamPlayers() {
        return _teamPlayers;
    }
}


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

import com.jcwhatever.pvs.api.arena.Arena;
import com.jcwhatever.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.pvs.api.arena.ArenaTeam;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Called when an arena team loses.
 */
public class TeamLoseEvent extends AbstractTeamEvent {

    private final String _initialMessage;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena         The event arena.
     * @param team          The event team.
     * @param teamPlayers   The players on the team.
     * @param loseMessage   The message to display to players in the game.
     */
    public TeamLoseEvent(Arena arena, ArenaTeam team, Collection<ArenaPlayer> teamPlayers, @Nullable String loseMessage) {
        super(arena, team, teamPlayers);

        _initialMessage = loseMessage;
        _message = loseMessage;
    }

    /**
     * Get the initial message set when the
     * event was called.
     */
    @Nullable
    public String getInitialMessage() {
        return _initialMessage;
    }

    /**
     * Get the message to be displayed to the
     * arena game players.
     */
    @Nullable
    public String getLoseMessage() {
        return _message;
    }

    /**
     * Set the message to be displayed to the
     * arena game players.
     *
     * @param message  The message.
     */
    public void setLoseMessage(@Nullable String message) {
        _message = message;
    }
}

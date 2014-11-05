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


package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.arena.options.TeamChangeReason;

/**
 * Called after a players team is set.
 */
public class PlayerTeamChangedEvent extends AbstractPlayerEvent {

    private final ArenaTeam _previousTeam;
    private final TeamChangeReason _reason;

    /**
     * Constructor.
     *
     * @param arena         The event arena.
     * @param player        The event player.
     */
    public PlayerTeamChangedEvent(Arena arena, ArenaPlayer player, ArenaTeam previousTeam, TeamChangeReason reason) {
        super(arena, player);

        PreCon.notNull(previousTeam);
        PreCon.notNull(reason);

        _previousTeam = previousTeam;
        _reason = reason;
    }

    /**
     * Get the team the player is on.
     */
    public ArenaTeam getTeam() {
        return getPlayer().getTeam();
    }

    /**
     * Get the team the player was previously on.
     */
    public ArenaTeam getPreviousTeam() {
        return _previousTeam;
    }

    /**
     * Get the reason for the team change.
     */
    public TeamChangeReason getReason() {
        return _reason;
    }
}

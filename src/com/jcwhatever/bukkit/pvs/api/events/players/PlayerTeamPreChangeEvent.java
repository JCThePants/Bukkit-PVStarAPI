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

import com.jcwhatever.bukkit.generic.mixins.ICancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.arena.managers.PlayerManager;
import com.jcwhatever.bukkit.pvs.api.arena.options.TeamChangeReason;

/**
 * Called before a players team is set.
 */
public class PlayerTeamPreChangeEvent extends AbstractPlayerEvent implements ICancellable {

    private final TeamChangeReason _reason;
    private ArenaTeam _team;
    private boolean _isCancelled;


    /**
     * Constructor.
     *
     * @param arena         The event arena.
     * @param player        The event player.
     */
    public PlayerTeamPreChangeEvent(Arena arena, ArenaPlayer player, PlayerManager relatedManager,
                                    ArenaTeam team, TeamChangeReason reason) {
        super(arena, player, relatedManager);

        PreCon.notNull(team);
        PreCon.notNull(reason);

        _team = team;
        _reason = reason;
    }

    /**
     * Get the players current team.
     */
    public ArenaTeam getTeam() {
        return getPlayer().getTeam();
    }

    /**
     * Get the players new team.
     */
    public ArenaTeam getNewTeam() {
        return _team;
    }

    /**
     * Get the reason the team is being changed.
     */
    public TeamChangeReason getReason() {
        return _reason;
    }

    /**
     * Set the new team
     *
     * @param team  The team.
     */
    public void setNewTeam(ArenaTeam team) {
        _team = team;
    }

    @Override
    public boolean isCancelled() {
        return _isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        _isCancelled = isCancelled;
    }
}

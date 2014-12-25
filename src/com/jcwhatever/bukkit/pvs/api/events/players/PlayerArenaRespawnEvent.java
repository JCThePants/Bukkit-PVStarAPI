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

import com.jcwhatever.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.managers.PlayerManager;

import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Called when a player is respawned in an arena.
 */
public class PlayerArenaRespawnEvent extends AbstractPlayerEvent {

    private Location _respawnLocation;
    private Location _originalRespawnLocation;

    /**
     * Constructor.
     *
     * @param arena            The event arena.
     * @param player           The player being respawned.
     * @param respawnLocation  The location the player will be respawned at.
     */
    public PlayerArenaRespawnEvent(Arena arena, ArenaPlayer player,
                                   @Nullable PlayerManager relatedManager, Location respawnLocation) {
        super(arena, player, relatedManager);

        PreCon.notNull(respawnLocation);

        _respawnLocation = respawnLocation;
        _originalRespawnLocation = respawnLocation;
    }

    /**
     * Get the respawn location set when the event was called.
     */
    public Location getInitialRespawnLocation() {
        return _originalRespawnLocation;
    }

    /**
     * Get the respawn location.
     */
    public Location getRespawnLocation() {
        return _respawnLocation;
    }

    /**
     * Set the respawn location.
     *
     * @param location  The location.
     */
    public void setRespawnLocation(Location location) {
        PreCon.notNull(location);

        _respawnLocation = location;
    }
}

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


package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.options.AddPlayerReason;
import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Called when player is added to an arena.
 */
public class PlayerAddedEvent extends AbstractPlayerEvent {

    private final AddPlayerReason _reason;
    private Location _initialSpawnLocation;
    private Location _spawnLocation;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param player         The player being added.
     * @param reason         The reason the player is being added.
     * @param spawnLocation  The location the player will be teleported to, if any.
     */
    public PlayerAddedEvent(Arena arena, ArenaPlayer player, AddPlayerReason reason,
                            @Nullable Location spawnLocation, @Nullable String message) {
        super(arena, player, false);

        PreCon.notNull(reason);

        _reason = reason;
        _initialSpawnLocation = spawnLocation;
        _spawnLocation = spawnLocation;
        _message = message;
    }

    /**
     * Get the reason the player is being added.
     */
    public AddPlayerReason getReason() {
        return _reason;
    }

    /**
     * Get the spawn location set when the event was called.
     */
    @Nullable
    public Location getInitialSpawnLocation() {
        return _initialSpawnLocation;
    }

    /**
     * Get the current spawn location.
     * @return
     */
    @Nullable
    public Location getSpawnLocation() {
        return _spawnLocation;
    }

    /**
     * Set the players spawn location.
     *
     * @param location  The location to spawn the player. Null to prevent teleport.
     */
    public void setSpawnLocation(@Nullable Location location) {
        _spawnLocation = location;
    }

    /**
     * Get the message to display to players in the related player manager.
     */
    @Nullable
    public String getMessage() {
        return _message;
    }

    /**
     * Set the message to display to players in the related player manager.
     *
     * @param message  The message to display.
     */
    public void setMessage(@Nullable String message) {
        _message = message;
    }

}

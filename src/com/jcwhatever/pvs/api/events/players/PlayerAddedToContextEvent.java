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

import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.context.IContextManager;
import com.jcwhatever.pvs.api.arena.options.AddToContextReason;
import com.jcwhatever.pvs.api.arena.options.ArenaContext;

import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Called when player is added to an arena context.
 */
public class PlayerAddedToContextEvent extends AbstractPlayerEvent {

    private final AddToContextReason _reason;
    private final ArenaContext _context;
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
    public PlayerAddedToContextEvent(IArena arena,
                                     IArenaPlayer player,
                                     IContextManager relatedManager,
                                     ArenaContext context,
                                     AddToContextReason reason,
                                     @Nullable Location spawnLocation,
                                     @Nullable String message) {

        super(arena, player, relatedManager);

        PreCon.notNull(context);
        PreCon.notNull(reason);
        PreCon.notNull(relatedManager);

        _context = context;
        _reason = reason;
        _initialSpawnLocation = spawnLocation;
        _spawnLocation = spawnLocation;
        _message = message;
    }

    /**
     * Get the context of the manager the player is being
     * added to.
     */
    public ArenaContext getContext() {
        return _context;
    }

    /**
     * Get the reason the player is being added.
     */
    public AddToContextReason getReason() {
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

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

import com.jcwhatever.bukkit.generic.mixins.ICancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Called when a player in an arena moves.
 */
public class PlayerArenaMoveEvent extends AbstractPlayerEvent implements ICancellable{

    private PlayerMoveEvent _event;
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The moving player.
     * @param event   The parent event.
     */
    public PlayerArenaMoveEvent(Arena arena, ArenaPlayer player, PlayerMoveEvent event) {
        super(arena, player);

        PreCon.notNull(event);

        _event = event;
    }

    /**
     * Get the location the player is moving from.
     */
    public Location getFrom() {
        return _event.getFrom();
    }

    /**
     * Get the location the player is moving to.
     */
    public Location getTo() {
        return _event.getTo();
    }

    /**
     * Set the location the player is moving from.
     *
     * @param location  The location.
     */
    public void setFrom(Location location) {
        _event.setFrom(location);
    }

    /**
     * Set the location the player is moving to.
     *
     * @param location  The location.
     */
    public void setTo(Location location) {
        _event.setTo(location);
    }

    /**
     * Get the parent event.
     */
    public PlayerMoveEvent getParentEvent() {
        return _event;
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

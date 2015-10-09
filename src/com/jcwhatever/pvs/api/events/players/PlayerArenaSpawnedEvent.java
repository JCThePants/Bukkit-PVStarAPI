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
import com.jcwhatever.nucleus.utils.coords.LocationUtils;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.context.IContextManager;
import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Called after a player is spawned in an arena.
 */
public class PlayerArenaSpawnedEvent extends AbstractPlayerEvent {

    private Location _location;

    /**
     * Constructor.
     *
     * @param arena            The event arena.
     * @param player           The player being respawned.
     * @param spawnLocation  The location the player will be respawned at.
     */
    public PlayerArenaSpawnedEvent(IArena arena,
                                   IArenaPlayer player,
                                   @Nullable IContextManager relatedManager,
                                   Location spawnLocation) {

        super(arena, player, relatedManager);

        PreCon.notNull(spawnLocation);

        _location = spawnLocation;
    }

    /**
     * Get the respawn location.
     */
    public Location getSpawnLocation() {
        return _location.clone();
    }

    /**
     * Get the respawn location.
     */
    public Location getSpawnLocation(Location output) {
        PreCon.notNull(output);

        return LocationUtils.copy(_location, output);
    }
}


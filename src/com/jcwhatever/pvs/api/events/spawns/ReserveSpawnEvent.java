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


package com.jcwhatever.pvs.api.events.spawns;

import com.jcwhatever.nucleus.mixins.ICancellable;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.arena.Arena;
import com.jcwhatever.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.pvs.api.spawns.Spawnpoint;

/**
 * Called when a spawnpoint is reserved in an arena.
 */
public class ReserveSpawnEvent extends AbstractSpawnEvent implements ICancellable {

    private ArenaPlayer _player;
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player the spawnpoint is being reserved for.
     * @param spawn   The spawnpoint being reserved.
     */
    public ReserveSpawnEvent(Arena arena, ArenaPlayer player, Spawnpoint spawn) {
        super(arena, spawn);

        PreCon.notNull(player);

        _player = player;
    }

    /**
     * Get the player the spawnpoint is being reserved for.
     */
    public ArenaPlayer getPlayer() {
        return _player;
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

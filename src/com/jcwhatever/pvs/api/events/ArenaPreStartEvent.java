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


package com.jcwhatever.pvs.api.events;

import com.jcwhatever.nucleus.mixins.ICancellable;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.collections.IArenaPlayerCollection;
import com.jcwhatever.pvs.api.arena.options.ArenaStartReason;

/**
 * Called before an arena is started.
 */
public class ArenaPreStartEvent extends AbstractArenaEvent implements ICancellable {

    private final ArenaStartReason _reason;
    private final IArenaPlayerCollection _joiningPlayers;
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena   The arena.
     * @param reason  The reason the arena is starting.
     */
    public ArenaPreStartEvent(IArena arena, IArenaPlayerCollection joiningPlayers, ArenaStartReason reason) {
        super(arena);

        PreCon.notNull(reason);

        _reason = reason;
        _joiningPlayers = joiningPlayers;
    }

    /**
     * Get the reason the arena is starting.
     */
    public ArenaStartReason getReason() {
        return _reason;
    }

    /**
     * Get the players joining the game.
     */
    public IArenaPlayerCollection getJoiningPlayers() {
        return _joiningPlayers;
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

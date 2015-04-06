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
import com.jcwhatever.pvs.api.arena.options.ArenaContext;

/**
 * Called when a players arena context is changed.
 */
public class PlayerContextChangeEvent  extends AbstractPlayerEvent {

    private final ArenaContext _previousContext;
    private final ArenaContext _newContext;

    /**
     * Constructor.
     *
     * @param arena            The event arena.
     * @param player           The player being added.
     * @param previousContext  The players previous arena context.
     * @param newContext       The players new arena context.
     */
    public PlayerContextChangeEvent(IArena arena,
                                    IArenaPlayer player,
                                    ArenaContext previousContext,
                                    ArenaContext newContext) {

        super(arena, player, player.getContextManager());

        PreCon.notNull(previousContext);
        PreCon.notNull(newContext);

        _previousContext = previousContext;
        _newContext = newContext;
    }

    /**
     * Get the players previous context.
     */
    public ArenaContext getPreviousContext() {
        return _previousContext;
    }

    /**
     * Get the players new arena context.
     */
    public ArenaContext getContext() {
        return _newContext;
    }
}
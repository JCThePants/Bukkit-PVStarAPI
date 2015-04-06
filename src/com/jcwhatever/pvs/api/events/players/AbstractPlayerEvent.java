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
import com.jcwhatever.pvs.api.arena.managers.IPlayerManager;
import com.jcwhatever.pvs.api.events.AbstractArenaEvent;
import javax.annotation.Nullable;

/**
 * An arena event that deals with a player
 */
public abstract class AbstractPlayerEvent extends AbstractArenaEvent {

    private final IArenaPlayer _player;
    private final IPlayerManager _relatedManager;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param player         The event player.
     */
    public AbstractPlayerEvent(IArena arena, IArenaPlayer player, @Nullable IPlayerManager relatedManager) {
        super(arena);

        PreCon.notNull(player);

        _player = player;
        _relatedManager = relatedManager;
    }

    /**
     * Get the event player.
     */
    public IArenaPlayer getPlayer() {
        return _player;
    }

    /**
     * Get the arena player manager (Lobby, Game, or Spectator) related to the event.
     */
    @Nullable
    public IPlayerManager getRelatedManager() {
        return _relatedManager;
    }
}

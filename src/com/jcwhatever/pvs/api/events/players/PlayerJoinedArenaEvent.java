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
import com.jcwhatever.pvs.api.arena.context.IGameContext;
import com.jcwhatever.pvs.api.arena.context.IContextManager;
import com.jcwhatever.pvs.api.arena.options.PlayerJoinArenaReason;

import javax.annotation.Nullable;

/**
 * Event called when player joins an arena through the arena method
 * {@link IArena#join} or game manager method {@link IGameContext#forwardPlayer}.
 */
public class PlayerJoinedArenaEvent extends AbstractPlayerEvent {

    private final PlayerJoinArenaReason _reason;

    /**
     * Constructor.
     *
     * @param arena           The arena being joined.
     * @param player          The player joining.
     * @param reason          The reason the player is joining.
     * @param relatedManager  The context manager that initiated the event.
     */
    public PlayerJoinedArenaEvent(IArena arena,
                                  IArenaPlayer player,
                                  PlayerJoinArenaReason reason,
                                  @Nullable IContextManager relatedManager) {

        super(arena, player, relatedManager);

        PreCon.notNull(reason);

        _reason = reason;
    }

    /**
     * Determine the reason the player is joining the arena.
     */
    public PlayerJoinArenaReason getReason() {
        return _reason;
    }
}

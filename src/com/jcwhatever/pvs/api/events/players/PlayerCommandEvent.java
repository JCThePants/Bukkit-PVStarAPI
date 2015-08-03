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

import com.jcwhatever.nucleus.mixins.ICancellable;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.context.IContextManager;

import javax.annotation.Nullable;

/**
 * Called when a command is used by a player in an arena.
 */
public class PlayerCommandEvent extends AbstractPlayerEvent implements ICancellable {

    private final String _command;
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena           The arena the event is in.
     * @param player          The player executing the command.
     * @param relatedManager  The manager context of the player.
     * @param command         The root command being executed.
     * @param isCancelled     The initial cancelled state.
     */
    public PlayerCommandEvent(IArena arena, IArenaPlayer player,
                              @Nullable IContextManager relatedManager,
                              String command, boolean isCancelled) {
        super(arena, player, relatedManager);

        PreCon.notNull(command);

        _command = command;
        _isCancelled = isCancelled;
    }

    /**
     * Get the root of the command being executed.
     */
    public String getCommand() {
        return _command;
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

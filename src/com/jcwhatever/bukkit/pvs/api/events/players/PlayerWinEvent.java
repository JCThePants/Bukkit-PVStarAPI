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

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;

import javax.annotation.Nullable;

/**
 * Called when a player wins a match in an arena.
 */
public class PlayerWinEvent extends AbstractPlayerEvent {

    private final String _initialMessage;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The winning player.
     */
    public PlayerWinEvent(Arena arena, ArenaPlayer player, @Nullable String message) {
        super(arena, player, false);

        _initialMessage = message;
        _message = message;
    }

    /**
     * Get the win message that was set when the event
     * was called.
     */
    @Nullable
    public String getInitialMessage() {
        return _initialMessage;
    }

    /**
     * Get the win message.
     */
    @Nullable
    public String getWinMessage() {
        return _message;
    }

    /**
     * Set the win message displayed to arena game.
     *
     * @param message  The message.
     */
    public void setWinMessage(@Nullable String message) {
        _message = message;
    }
}

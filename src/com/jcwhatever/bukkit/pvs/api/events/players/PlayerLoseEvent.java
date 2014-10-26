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
 * Called when a player loses a match in an arena.
 */
public class PlayerLoseEvent extends AbstractPlayerEvent {

    private final String _initialMessage;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player who lost.
     */
    public PlayerLoseEvent(Arena arena, ArenaPlayer player, @Nullable String loseMessage) {
        super(arena, player, false);

        _initialMessage = loseMessage;
        _message = loseMessage;
    }

    /**
     * Get the initial message set when the event
     * was called.
     */
    @Nullable
    public String getInitialMessage() {
        return _initialMessage;
    }

    /**
     * Get the message to be displayed to the arena game.
     */
    @Nullable
    public String getLoseMessage() {
        return _message;
    }

    /**
     * Set the message displayed to the arena game.
     *
     * @param message  The message to display
     */
    public void setLoseMessage(@Nullable String message) {
        _message = message;
    }
}

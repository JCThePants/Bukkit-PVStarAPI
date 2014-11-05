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


package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Describes reasons for a player to be removed
 * from an arena or arena player manager.
 */
public enum RemovePlayerReason {

    /**
     * The player lost.
     */
    LOSE,

    /**
     * The game has ended.
     */
    GAME_ENDED,

    /**
     * The player logged out of the server.
     */
    LOGOUT,

    /**
     * The player left the arena.
     */
    PLAYER_LEAVE,

    /**
     * The players relationship to the arena
     * is being changed.
     */
    ARENA_RELATION_CHANGE,

    /**
     * The player is being kicked from the arena.
     *
     * <p>Not to be confused with removal due to being
     * kicked from the server, in which case {@code LOGOUT}
     * is used.</p>
     */
    KICK,

    /**
     * The player is being forwarded to or from another
     * arena.
     */
    FORWARDING
}

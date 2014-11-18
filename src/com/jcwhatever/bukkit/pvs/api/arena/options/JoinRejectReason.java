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

/*
 * Reasons a player is rejected from joining an arena
 */
public enum JoinRejectReason {

    /**
     * The player is not rejected.
     */
    NONE,

    /**
     * Player is already in an arena and cannot join
     * another.
     */
    IN_OTHER_ARENA,

    /**
     * The arena the player is trying to join is
     * disabled.
     */
    ARENA_DISABLED,

    /**
     * The player does not have permission to join
     * the arena.
     */
    NO_PERMISSION,

    /**
     * The arena is currently busy.
     */
    ARENA_BUSY,

    /**
     * The arenas max player limit has been reached.
     */
    JOIN_LIMIT_REACHED,

    /**
     * The arena game is already in progress.
     */
    ARENA_RUNNING,

    /**
     * Other reasons.
     */
    OTHER
}

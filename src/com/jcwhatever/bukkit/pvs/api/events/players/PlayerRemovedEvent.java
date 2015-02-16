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


package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.managers.PlayerManager;
import com.jcwhatever.bukkit.pvs.api.arena.options.RemovePlayerReason;

/**
 * Called after a player is removed from an arena player manager (lobby, game or spectator).
 *
 * <p>Not to be confused with {@link PlayerLeaveEvent}, which is used when a player is
 * removed from the arena.</p>
 */
public class PlayerRemovedEvent extends AbstractPlayerEvent {

    private final RemovePlayerReason _reason;

    /**
     * Constructor.
     *
     * @param arena           The event arena.
     * @param player          The player who was removed.
     * @param relatedManager  The manager the player is being removed from.
     * @param reason          The reason the player was removed.
     */
    public PlayerRemovedEvent(Arena arena, ArenaPlayer player, PlayerManager relatedManager,
                              RemovePlayerReason reason) {
        super(arena, player, relatedManager);

        PreCon.notNull(reason);
        PreCon.notNull(relatedManager);

        _reason = reason;
    }

    /**
     * Get the reason the player was removed.
     */
    public RemovePlayerReason getReason() {
        return _reason;
    }
}

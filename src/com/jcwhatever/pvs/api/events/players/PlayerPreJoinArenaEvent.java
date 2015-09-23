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
import com.jcwhatever.pvs.api.arena.options.JoinRejectReason;
import com.jcwhatever.pvs.api.arena.options.PlayerJoinArenaReason;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Event called before a player joins an arena through the arena method
 * {@link IArena#join}.
 */
public class PlayerPreJoinArenaEvent extends AbstractPlayerEvent implements ICancellable {

    private final PlayerJoinArenaReason _reason;
    private final Map<JoinRejectReason, String> _rejectReasons = new EnumMap<>(JoinRejectReason.class);
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena   The arena being joined.
     * @param player  The player joining.
     */
    public PlayerPreJoinArenaEvent(IArena arena, IArenaPlayer player, PlayerJoinArenaReason reason) {
        super(arena, player, null);

        PreCon.notNull(reason);

        _reason = reason;
    }

    /**
     * Get the reason the player is joining the arena.
     */
    public PlayerJoinArenaReason getReason() {
        return _reason;
    }

    /**
     * Get the number of reasons the join was rejected for.
     */
    public int getRejectReasonCount() {
        return _rejectReasons.size();
    }

    /**
     * Get the reason the player join was rejected.
     */
    public Set<JoinRejectReason> getJoinRejectReasons() {
        return EnumSet.copyOf(_rejectReasons.keySet());
    }

    /**
     * Determine if the event is rejected for a specific reason.
     *
     * @param reason  The reason to check.
     */
    public boolean isRejectedFor(JoinRejectReason reason) {
        PreCon.notNull(reason);

        return _rejectReasons.containsKey(reason);
    }

    /**
     * Get the message displayed to the player if the event is cancelled.
     */
    @Nullable
    public String getRejectionMessage(JoinRejectReason reason) {
        PreCon.notNull(reason);

        return _rejectReasons.get(reason);
    }

    /**
     * Get rejections messages.
     */
    public List<String> getRejectionMessages() {
        List<String> result = new ArrayList<>(_rejectReasons.values().size());
        for (String message : _rejectReasons.values()) {
            if (message != null && !message.isEmpty())
                result.add(message);
        }
        return result;
    }

    /**
     * Reject the player join request.
     *
     * @param reason   The reason the player is being rejected.
     * @param message  The message to display to the player.
     */
    public void rejectJoin(JoinRejectReason reason, @Nullable CharSequence message) {
        PreCon.notNull(reason);

        if (reason == JoinRejectReason.NONE)
            return;

        _rejectReasons.put(reason, message != null ? message.toString() : null);
        _isCancelled = true;
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
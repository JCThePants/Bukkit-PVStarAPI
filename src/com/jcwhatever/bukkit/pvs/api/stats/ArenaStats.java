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


package com.jcwhatever.bukkit.pvs.api.stats;

import com.jcwhatever.bukkit.pvs.api.stats.StatTracking.StatTrackType;

import java.util.Set;
import java.util.UUID;

/**
 * Represents that statistics recorded for an arena.
 */
public interface ArenaStats {

    /**
     * The id of the arena the statistics are from.
     */
    UUID getArenaId();

    /**
     * Get a statistics value.
     *
     * @param type          The statistic type.
     * @param playerId      The id of the player.
     * @param trackingType  The tracking type.
     */
    double getValue(StatType type, UUID playerId, StatTrackType trackingType);

    /**
     * Get a statistics value.
     *
     * @param type          The statistic type.
     * @param playerId      The id of the player as a {@link java.lang.String}.
     * @param trackingType  The tracking type.
     */
    double getValue(StatType type, String playerId, StatTrackType trackingType);

    /**
     * Adds a player score to the arena statistics. A score is an amount compiled during the
     * running of an arena and whose final result is added here once the arena ends.
     *
     * @param type      The statistic type.
     * @param playerId  The id of the player.
     * @param amount    The players score in the statistic type.
     *
     * @return  The new total statistic value.
     */
    double addScore(StatType type, UUID playerId, double amount);

    /**
     * Get the ids of all players with a statistic type recorded in the arena as a
     * {@link java.util.Set} of {@link java.lang.String}.
     *
     * @param type  The statistic type.
     */
    Set<String> getRawPlayerIds(StatType type);
}

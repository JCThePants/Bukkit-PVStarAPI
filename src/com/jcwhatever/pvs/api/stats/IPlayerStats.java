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

package com.jcwhatever.pvs.api.stats;

import java.util.UUID;

/**
 * Container for player statistics data.
 */
public interface IPlayerStats {

    /**
     * Get the ID of the player the statistics are for.
     */
    UUID getPlayerId();

    /**
     * Get a players statistic score.
     *
     * @param type          The statistic type.
     * @param trackingType  The tracking type.
     */
    double getScore(StatType type, StatTracking.StatTrackType trackingType);

    /**
     * Adds a score to the statistics.
     *
     * <p>A score is an amount compiled during the running of an arena and
     * whose final result is added here once the arena ends.</p>
     *
     * @param type    The statistic type.
     * @param amount  The players score in the statistic type.
     */
    void addScore(StatType type, double amount);
}

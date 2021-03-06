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

import com.jcwhatever.nucleus.utils.observer.future.IFutureResult;

import java.util.UUID;

/**
 * Represents that statistics recorded for an arena.
 */
public interface IArenaStats {

    /**
     * The ID of the arena the statistics are from.
     */
    UUID getArenaId();

    /**
     * Get a players statistics for the arena.
     *
     * @param playerId  The ID of the player.
     */
    IFutureResult<IPlayerStats> get(UUID playerId);

    /**
     * Adds a score to a players statistics.
     *
     * <p>A score is an amount compiled during the running of an arena and
     * whose final result is added here once the arena ends.</p>
     *
     * @param playerId  The ID of the player to add the score to.
     * @param type      The statistic type.
     * @param amount    The players score in the statistic type.
     */
    void addScore(UUID playerId, StatType type, double amount);
}

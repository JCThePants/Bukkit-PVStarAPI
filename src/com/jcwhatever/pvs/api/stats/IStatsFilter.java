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

import java.util.List;
import java.util.UUID;

/**
 * One-time statistics filter.
 */
public interface IStatsFilter {

    /**
     * Add an arena to retrieve data from.
     *
     * @param arenaId  The ID of the arena to add.
     */
    void addArena(UUID arenaId);

    /**
     * Add a statistic to sort by.
     *
     * <p>The order statistics are added determines the priority.</p>
     *
     * @param type       The statistic type.
     * @param trackType  The tracking type.
     */
    void addStat(StatType type, StatTracking.StatTrackType trackType);

    /**
     * Filter statistics based on pre-specified parameters.
     *
     * @param limit  The max number of results to return.
     *
     * @return  A future to retrieve the results with.
     */
    IFutureResult<List<IPlayerStats>> filter(int offset, int limit);
}

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

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * Manages statistics data storage and statistic types.
 */
public interface StatsManager {

    /**
     * Register a statistic type.
     *
     * @param type  The statistic type.
     */
    public void registerType(StatType type);

    /**
     * Get available statistic types.
     * @return
     */
    public List<StatType> getTypes();

    /**
     * Get a statistic type by name.
     *
     * @param name  The name of the statistic.
     */
    @Nullable
    public StatType getType(String name);


    /**
     * Get statistics for an arena.
     *
     * @param arenaId  The id of the arena.
     */
    public ArenaStats getArenaStats(UUID arenaId);

}

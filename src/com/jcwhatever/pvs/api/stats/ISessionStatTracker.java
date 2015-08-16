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

import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.UUID;

/**
 * Tracker for arena session statistics.
 *
 * <p>Scores accumulated during the arena session are recorded
 * once the arena ends and/or the player leaves the arena.</p>
 */
public interface ISessionStatTracker {

    /**
     * Get the arena the player is in.
     *
     * @return  The arena or null if the player is not in an arena.
     */
    @Nullable
    IArena getArena();

    /**
     * Get the ID of the player the session tracker is for.
     */
    UUID getPlayerId();

    /**
     * Get the arena player object.
     */
    IArenaPlayer getArenaPlayer();

    /**
     * Get the players current score in the session for the specified
     * statistic type.
     *
     * @param type  The statistic type.
     */
    double getScore(StatType type);

    /**
     * Increment the players score in the current session for the specified
     * statistic type.
     *
     * @param type    The statistic type.
     * @param amount  The amount to increment.
     */
    void increment(StatType type, double amount);

    /**
     * Get a collection of all the {@link StatType}'s that have a recorded
     * value in the session.
     */
    Collection<StatType> getStatTypes();

    /**
     * Copy the collection of all the {@link StatType}'s that have a recorded
     * value in the session into the specified output collection.
     *
     * @param output  The output collection.
     *
     * @return  The output collection.
     */
    <T extends Collection<StatType>> T getStatTypes(T output);
}

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


package com.jcwhatever.pvs.api.arena.settings;

import com.jcwhatever.pvs.api.arena.options.LivesBehavior;
import com.jcwhatever.pvs.api.arena.options.PointsBehavior;

/**
 * Provides settings for an arenas game manager
 */
public interface GameManagerSettings extends PlayerManagerSettings {

    /**
     * Get the number of lives the players
     * start with.
     */
    int getStartLives();

    /**
     * Set the number of lives the players
     * start with.
     */
    void setStartLives(int lives);

    /**
     * Get the number of points players start with.
     */
    int getStartPoints();

    /**
     * Set the number of points players start with.
     */
    void setStartPoints(int points);

    /**
     * Get the behavior of lives when players are
     * forwarded to the arena.
     */
    LivesBehavior getLivesBehavior();

    /**
     * Set the behavior of lives when players are
     * forwarded to the arena.
     */
    void setLivesBehavior(LivesBehavior behavior);

    /**
     * Get the behavior of points when players are
     * forwarded to the arena.
     */
    PointsBehavior getPointsBehavior();

    /**
     * Set the behavior of points when players are
     * forwarded to the arena.
     */
    void setPointsBehavior(PointsBehavior behavior);

    /**
     * Set entities such dropped items removed
     * when the game ends.
     *
     * @param isEnabled  True to remove entities on game end.
     */
    void setPostGameEntityCleanup(boolean isEnabled);
}

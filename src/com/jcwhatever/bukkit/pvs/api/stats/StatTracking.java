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

/**
 * Represents the types of tracking performed by
 * a statistics type.
 */
public enum StatTracking {

    /**
     * Statistics type only tracks total of all scores earned.
     */
    TOTAL           (StatTrackType.TOTAL),

    /**
     * Statistic type records total of all scores and
     * the max score achieved.
     */
    TOTAL_MAX       (StatTrackType.TOTAL, StatTrackType.MAX),

    /**
     * Statistic type records total of all scores and
     * the minimum score achieved.
     */
    TOTAL_MIN       (StatTrackType.TOTAL, StatTrackType.MIN),

    /**
     * Statistic type records total of all scores, the
     * minimum score achieved, and the max score achieved.
     */
    TOTAL_MIN_MAX   (StatTrackType.TOTAL, StatTrackType.MIN, StatTrackType.MAX);

    /**
     * Represents a specific statistic tracking type.
     */
    public enum StatTrackType {
        /**
         * Total of all scores earned.
         */
        TOTAL  (0),

        /**
         *  Minimum score achieved.
         */
        MIN    (1),

        /**
         * Maximum score achieved.
         */
        MAX    (2);

        private final byte _flag;

        StatTrackType(int flag) {
            _flag = (byte)flag;
        }

        public byte getFlag() {
            return _flag;
        }
    }

    private byte _typeFlags = 0;

    StatTracking(StatTrackType... types) {
        for (StatTrackType type : types) {
            _typeFlags |= type.getFlag();
        }
    }

    /**
     * Determine if a specific type is employed.
     *
     * @param type  The statistic tracking type.
     */
    public boolean hasType(StatTrackType type) {
        return (type.getFlag() & _typeFlags) == type.getFlag();
    }
}

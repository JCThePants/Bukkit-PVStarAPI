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

import com.jcwhatever.bukkit.generic.mixins.INamed;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.generic.utils.text.TextUtils;

import java.text.DecimalFormat;

/**
 * Represents a type of statistic that is tracked.
 */
public class StatType implements INamed {

    private static final DecimalFormat DEFAULT_FORMATTER = new DecimalFormat("0");

    private final String _statName;
    private final String _displayName;
    private final StatTracking _tracking;
    private final DecimalFormat _format;

    /**
     * Constructor. Uses a whole number decimal formatter.
     *
     * @param statName     The name.
     * @param displayName  The display name.
     * @param tracking     The tracking types.
     */
    public StatType(String statName, String displayName, StatTracking tracking) {
        this(statName, displayName, tracking, DEFAULT_FORMATTER);
    }

    /**
     * Constructor.
     *
     * @param statName     The name.
     * @param displayName  The display name.
     * @param tracking     The tracking types.
     * @param format       The decimal formatter to use when display values.
     */
    public StatType(String statName, String displayName, StatTracking tracking, DecimalFormat format) {
        PreCon.notNullOrEmpty(statName);
        PreCon.notNullOrEmpty(displayName);
        PreCon.isValid(TextUtils.isValidName(statName), "Invalid StatType name.");

        _statName = statName;
        _displayName = displayName;
        _tracking = tracking;
        _format = format;
    }

    /**
     * Get the name of the statistic.
     */
    @Override
    public String getName() {
        return _statName;
    }

    /**
     * Get the display name.
     */
    public String getDisplayName() {
        return _displayName;
    }

    /**
     * Get the tracking types.
     */
    public StatTracking getTracking() {
        return _tracking;
    }

    /**
     * Format a statistic value using the types decimal formatter
     * into a {@code String}.
     *
     * @param value  The value to format.
     */
    public String formatDisplay(double value) {
        return _format.format(value);
    }

}

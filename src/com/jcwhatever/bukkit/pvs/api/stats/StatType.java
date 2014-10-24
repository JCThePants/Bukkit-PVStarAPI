package com.jcwhatever.bukkit.pvs.api.stats;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.generic.utils.TextUtils;

import java.text.DecimalFormat;

/**
 * Represents a type of statistic that is tracked.
 */
public class StatType {

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

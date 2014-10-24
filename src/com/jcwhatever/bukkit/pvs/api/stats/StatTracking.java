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

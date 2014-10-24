package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Options for how a players points are handled when forwarded to another arena.
 */
public enum PointsBehavior {

    /**
     * Forwarded players keep the points they
     * already have without modification.
     */
    STATIC,

    /**
     * Forwarded players get their points reset to 0.
     */
    RESET,

    /**
     * Forwarded players get points added from
     * the current arena points setting.
     */
    ADDITIVE
}

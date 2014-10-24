package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Options for how a players lives are handled when forwarded to another arena.
 */
public enum LivesBehavior {
    /**
     * Forwarded players keep the lives they
     * already have without modification.
     */
    STATIC,
    /**
     * Forwarded players get their lives reset
     * to the new arenas lives setting.
     */
    RESET,

    /**
     * Forwarded players get lives added from
     * the current arena lives setting.
     */
    ADDITIVE
}

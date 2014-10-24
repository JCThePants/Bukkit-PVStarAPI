package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Reasons for adding a player to an arena
 * or arena player manager.
 */
public enum AddPlayerReason {

    /**
     * The player is joining the arena.
     */
    PLAYER_JOIN,

    /**
     * The players relation to the arena
     * is changing.
     */
    ARENA_RELATION_CHANGE,

    /**
     * The player is being forwarded to
     * the arena.
     */
    FORWARDING
}

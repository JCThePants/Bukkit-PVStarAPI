package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Describes reasons for a player to be removed
 * from an arena or arena player manager.
 */
public enum RemovePlayerReason {

    /**
     * The player lost.
     */
    LOSE,

    /**
     * The game has ended.
     */
    GAME_ENDED,

    /**
     * The player logged out of the server.
     */
    LOGOUT,

    /**
     * The player left the arena.
     */
    PLAYER_LEAVE,

    /**
     * The players relationship to the arena
     * is being changed.
     */
    ARENA_RELATION_CHANGE,

    /**
     * The player is being kicked from the arena.
     *
     * <p>Not to be confused with removal due to being
     * kicked from the server, in which case {@code LOGOUT}
     * is used.</p>
     */
    KICK,

    /**
     * The player is being forwarded to or from another
     * arena.
     */
    FORWARDING
}

package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Determines how an outsider entering the arena region is handled.
 *
 * <p>An outsider is a player who has not joined the arena.</p>
 */
public enum OutsidersAction {

    /**
     * Do nothing.
     */
    NONE,

    /**
     * Kick the player from the arena region.
     */
    KICK,

    /**
     * Add the player to the game.
     */
    JOIN
}

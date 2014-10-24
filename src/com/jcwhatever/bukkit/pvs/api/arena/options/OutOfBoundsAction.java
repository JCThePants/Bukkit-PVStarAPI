package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Describes an action to take when a player
 * leaves the arena region.
 */
public enum OutOfBoundsAction {

    /**
     * Do nothing.
     */
    NONE,

    /**
     * Kick the player from the arena.
     */
    KICK,

    /**
     * Declare the player the winner.
     */
    WIN,

    /**
     * The player loses.
     */
    LOSE,

    /**
     * Respawn the player.
     */
    RESPAWN
    // TODO
}

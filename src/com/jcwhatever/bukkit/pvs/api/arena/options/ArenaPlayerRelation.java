package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Describes a players relationship
 * to a an arena.
 */
public enum ArenaPlayerRelation {

    /**
     * The player is not in an arena and has
     * no relation.
     */
    NONE,

    /**
     * The player is in the lobby.
     */
    LOBBY,

    /**
     * The player is in game.
     */
    GAME,

    /**
     * The player is a spectator.
     */
    SPECTATOR


}


package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;

/**
 * Called when a player is ready to play in an arena.
 */
public class PlayerReadyEvent extends AbstractPlayerEvent {

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player who is ready.
     */
    public PlayerReadyEvent(Arena arena, ArenaPlayer player) {
        super(arena, player, false);
    }
}
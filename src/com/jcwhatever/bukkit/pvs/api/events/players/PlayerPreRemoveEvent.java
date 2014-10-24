package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.options.RemovePlayerReason;

/**
 * Called before a player is removed from an arena.
 */
public class PlayerPreRemoveEvent extends AbstractPlayerEvent {

    private final RemovePlayerReason _reason;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player to be removed.
     * @param reason  The reason the player is being removed.
     */
    public PlayerPreRemoveEvent(Arena arena, ArenaPlayer player, RemovePlayerReason reason) {
        super(arena, player, true);

        PreCon.notNull(reason);

        _reason = reason;
    }

    /**
     * Get the reason the player is being removed.
     */
    public RemovePlayerReason getReason() {
        return _reason;
    }

}

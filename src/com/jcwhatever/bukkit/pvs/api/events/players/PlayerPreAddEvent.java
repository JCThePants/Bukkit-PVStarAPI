package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.options.AddPlayerReason;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;

/**
 * Called before a player is added to an arena.
 */
@Cancellable
public class PlayerPreAddEvent extends AbstractPlayerEvent {

    private final AddPlayerReason _reason;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player to be added.
     * @param reason  The reason the player is being added.
     */
    public PlayerPreAddEvent(Arena arena, ArenaPlayer player, AddPlayerReason reason) {
        super(arena, player, true);

        PreCon.notNull(reason);

        _reason = reason;
    }

    /**
     * Get the reason the player is to be added.
     */
    public AddPlayerReason getReason() {
        return _reason;
    }
}
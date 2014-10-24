package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;

import javax.annotation.Nullable;

/**
 * Called when a player loses a match in an arena.
 */
public class PlayerLoseEvent extends AbstractPlayerEvent {

    private final String _initialMessage;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player who lost.
     */
    public PlayerLoseEvent(Arena arena, ArenaPlayer player, @Nullable String loseMessage) {
        super(arena, player, false);

        _initialMessage = loseMessage;
        _message = loseMessage;
    }

    /**
     * Get the initial message set when the event
     * was called.
     */
    @Nullable
    public String getInitialMessage() {
        return _initialMessage;
    }

    /**
     * Get the message to be displayed to the arena game.
     */
    @Nullable
    public String getLoseMessage() {
        return _message;
    }

    /**
     * Set the message displayed to the arena game.
     *
     * @param message  The message to display
     */
    public void setLoseMessage(@Nullable String message) {
        _message = message;
    }
}

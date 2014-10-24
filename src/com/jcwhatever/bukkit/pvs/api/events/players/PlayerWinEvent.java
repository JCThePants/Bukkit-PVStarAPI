package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;

import javax.annotation.Nullable;

/**
 * Called when a player wins a match in an arena.
 */
public class PlayerWinEvent extends AbstractPlayerEvent {

    private final String _initialMessage;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The winning player.
     */
    public PlayerWinEvent(Arena arena, ArenaPlayer player, @Nullable String message) {
        super(arena, player, false);

        _initialMessage = message;
        _message = message;
    }

    /**
     * Get the win message that was set when the event
     * was called.
     */
    @Nullable
    public String getInitialMessage() {
        return _initialMessage;
    }

    /**
     * Get the win message.
     */
    @Nullable
    public String getWinMessage() {
        return _message;
    }

    /**
     * Set the win message displayed to arena game.
     *
     * @param message  The message.
     */
    public void setWinMessage(@Nullable String message) {
        _message = message;
    }
}

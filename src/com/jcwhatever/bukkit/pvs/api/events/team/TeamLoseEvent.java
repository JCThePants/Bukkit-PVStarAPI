package com.jcwhatever.bukkit.pvs.api.events.team;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Called when an arena team loses.
 */
public class TeamLoseEvent extends AbstractTeamEvent {

    private final String _initialMessage;
    private String _message;

    /**
     * Constructor.
     *
     * @param arena         The event arena.
     * @param team          The event team.
     * @param teamPlayers   The players on the team.
     * @param loseMessage   The message to display to players in the game.
     */
    public TeamLoseEvent(Arena arena, ArenaTeam team, Collection<ArenaPlayer> teamPlayers, @Nullable String loseMessage) {
        super(arena, team, teamPlayers, false);

        _initialMessage = loseMessage;
        _message = loseMessage;
    }

    /**
     * Get the initial message set when the
     * event was called.
     */
    @Nullable
    public String getInitialMessage() {
        return _initialMessage;
    }

    /**
     * Get the message to be displayed to the
     * arena game players.
     */
    @Nullable
    public String getLoseMessage() {
        return _message;
    }

    /**
     * Set the message to be displayed to the
     * arena game players.
     *
     * @param message  The message.
     */
    public void setLoseMessage(@Nullable String message) {
        _message = message;
    }
}

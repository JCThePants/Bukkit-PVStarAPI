package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.arena.options.TeamChangeReason;

/**
 * Called before a players team is set.
 */
@Cancellable
public class PlayerTeamPreChangeEvent extends AbstractPlayerEvent {

    private final TeamChangeReason _reason;
    private ArenaTeam _team;


    /**
     * Constructor.
     *
     * @param arena         The event arena.
     * @param player        The event player.
     */
    public PlayerTeamPreChangeEvent(Arena arena, ArenaPlayer player, ArenaTeam team, TeamChangeReason reason) {
        super(arena, player, true);

        PreCon.notNull(team);
        PreCon.notNull(reason);

        _team = team;
        _reason = reason;
    }

    /**
     * Get the players current team.
     */
    public ArenaTeam getTeam() {
        return getPlayer().getTeam();
    }

    /**
     * Get the players new team.
     */
    public ArenaTeam getNewTeam() {
        return _team;
    }

    /**
     * Get the reason the team is being changed.
     */
    public TeamChangeReason getReason() {
        return _reason;
    }

    /**
     * Set the new team
     *
     * @param team  The team.
     */
    public void setNewTeam(ArenaTeam team) {
        _team = team;
    }
}

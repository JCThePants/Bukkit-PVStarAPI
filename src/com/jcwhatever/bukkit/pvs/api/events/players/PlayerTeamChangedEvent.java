package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.arena.options.TeamChangeReason;

/**
 * Called after a players team is set.
 */
public class PlayerTeamChangedEvent extends AbstractPlayerEvent {

    private final ArenaTeam _previousTeam;
    private final TeamChangeReason _reason;

    /**
     * Constructor.
     *
     * @param arena         The event arena.
     * @param player        The event player.
     */
    public PlayerTeamChangedEvent(Arena arena, ArenaPlayer player, ArenaTeam previousTeam, TeamChangeReason reason) {
        super(arena, player, false);

        PreCon.notNull(previousTeam);
        PreCon.notNull(reason);

        _previousTeam = previousTeam;
        _reason = reason;
    }

    /**
     * Get the team the player is on.
     */
    public ArenaTeam getTeam() {
        return getPlayer().getTeam();
    }

    /**
     * Get the team the player was previously on.
     */
    public ArenaTeam getPreviousTeam() {
        return _previousTeam;
    }

    /**
     * Get the reason for the team change.
     */
    public TeamChangeReason getReason() {
        return _reason;
    }
}

package com.jcwhatever.bukkit.pvs.api.events.team;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * An arena event that deals with a team
 */
public abstract class AbstractTeamEvent extends AbstractArenaEvent {

    private final ArenaTeam _team;
    private final List<ArenaPlayer> _teamPlayers;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param team           The event team.
     * @param teamPlayers    The players on the team.
     * @param isCancellable  True if the event is cancellable.
     */
    public AbstractTeamEvent(Arena arena, ArenaTeam team, Collection<ArenaPlayer> teamPlayers, boolean isCancellable) {
        super(arena, isCancellable);

        PreCon.notNull(team);
        PreCon.notNull(teamPlayers);

        _team = team;
        _teamPlayers = Collections.unmodifiableList(new ArrayList<>(teamPlayers));
    }

    /**
     * Get the event team.
     */
    public ArenaTeam getTeam() {
        return _team;
    }

    /**
     * Get the players on the team in an unmodifiable list.
     */
    public List<ArenaPlayer> getTeamPlayers() {
        return _teamPlayers;
    }

}


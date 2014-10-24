package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;

import java.util.Set;

/**
 * Manages teams in an arena.
 */
public interface TeamManager {

    /**
     * Get the owning arena.
     */
    Arena getArena();

    /**
     * Get available teams in the arena. Available teams
     * are determined by the teams set on spawnpoints in
     * the spawn manager.
     *
     * @return
     */
    Set<ArenaTeam> getTeams();

}

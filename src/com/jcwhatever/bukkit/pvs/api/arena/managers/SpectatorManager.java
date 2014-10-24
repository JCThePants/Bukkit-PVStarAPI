package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.settings.SpectatorManagerSettings;

/**
 * Manages an arenas spectators.
 */
public interface SpectatorManager extends PlayerManager {

    /**
     * Get the spectator manager settings.
     */
    SpectatorManagerSettings getSettings();

}

package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.settings.LobbyManagerSettings;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Manages an arenas lobby.
 */
public interface LobbyManager extends PlayerManager {

    /**
     * Determine if the countdown till the next game is running.
     */
    boolean isCountdownRunning();

    /**
     * Cancel the countdown.
     */
    void cancelCountdown();


    /**
     * Get the next group of players that are all ready.
     *
     * @return Null if non available.
     */
    @Nullable
    List<ArenaPlayer> getReadyGroup();

    /**
     * Get the next group of players that meat minimum players
     * and minimum auto start players settings.
     *
     * @return Null if none available.
     */
    @Nullable
    List<ArenaPlayer> getNextGroup();

    /**
     * Get the lobby manager settings.
     */
    abstract LobbyManagerSettings getSettings();

}


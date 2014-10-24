package com.jcwhatever.bukkit.pvs.api.arena.settings;

/**
 * Provides settings for an arenas lobby manager.
 */
public interface LobbyManagerSettings extends PlayerManagerSettings {

    /**
     * Determine if players are immobilized in the lobby.
     */
    boolean isImmobilized();

    /**
     * Set players immobilized in the lobby.
     *
     * @param isEnabled  True to immobilize players.
     */
    void setImmobilized(boolean isEnabled);


    /**
     * Determine if auto start is enabled.
     */
    boolean hasAutoStart();

    /**
     * Set auto start enabled.
     */
    void setAutoStart(boolean isEnabled);

    /**
     * Get the number of seconds to countdown from
     * before the game starts.
     */
    int getStartCountdownSeconds();

    /**
     * Set the number of seconds to countdown from
     * before the game starts.
     */
    void setStartCountdownSeconds(int seconds);

    /**
     * Get the minimum number of players required
     * to auto start.
     */
    int getMinAutoStartPlayers();

    /**
     * Set the minimum number of players required
     * to auto start.
     */
    void setMinAutoStartPlayers(int minPlayers);

}
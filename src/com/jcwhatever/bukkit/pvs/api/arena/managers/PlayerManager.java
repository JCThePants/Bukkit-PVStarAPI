package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.options.AddPlayerReason;
import com.jcwhatever.bukkit.pvs.api.arena.options.RemovePlayerReason;

import java.util.List;

/**
 * The base implementation for player managers
 * (LobbyManager, GameManager, SpectatorManager)
 */
public interface PlayerManager {

    /**
     * Get the managers owning arena.
     */
    public Arena getArena();

    /**
     * Get the players being managed.
     */
    public List<ArenaPlayer> getPlayers();

    /**
     * Get the number of players being managed.
     */
    public int getPlayerCount();

    /**
     * Determine if the manager is managing the specified player.
     *
     * @param player  The player to check.
     */
    public boolean hasPlayer(ArenaPlayer player);

    /**
     * Respawn the specified player if the player is being managed
     * by the manager instance.
     *
     * @param player  The player to respawn.
     */
    public boolean respawnPlayer(ArenaPlayer player);

    /**
     * Add a player to the manager instance to be managed.
     *
     * @param player  The player to add.
     * @param reason  The reason the player is being added.
     *
     * @return  True if the player was added.
     */
    public boolean addPlayer(ArenaPlayer player, AddPlayerReason reason);

    /**
     * Remove a player from the manager instance.
     *
     * @param player  The player to remove.
     * @param reason  The reason the player is being removed.
     *
     * @return  True if the player was being managed by the instance and was removed.
     */
    public boolean removePlayer(ArenaPlayer player, RemovePlayerReason reason);

    /**
     * Tell all players being managed.
     *
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public void tell(String message, Object... params);


}

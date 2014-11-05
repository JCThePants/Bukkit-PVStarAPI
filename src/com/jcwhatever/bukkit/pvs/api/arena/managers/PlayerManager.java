/*
 * This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
 *
 * Copyright (c) JCThePants (www.jcwhatever.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


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

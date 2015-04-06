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


package com.jcwhatever.pvs.api.arena.managers;

import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.ArenaTeam;
import com.jcwhatever.pvs.api.arena.options.ArenaStartReason;
import com.jcwhatever.pvs.api.arena.settings.IGameSettings;

import java.util.Date;
import javax.annotation.Nullable;

/**
 * Manages an arenas game session/players.
 */
public interface IGameManager extends IPlayerManager {

    /**
     * Get the start time of the last game.
     */
    @Nullable
    Date getStartTime();

    /**
     * Determine if the arena game is running.
     */
    boolean isRunning();

    /**
     * Determine if the game is over, but the arena is still running.
     *
     * @return  Always returns false if the arena is not running.
     */
    boolean isGameOver();

    /**
     * Get the game manager settings.
     */
    IGameSettings getSettings();

    /**
     * Determine if the arena can be started.
     */
    boolean canStart();

    /**
     * Start the game. Transfers the next group of players from the lobby.
     *
     * @param reason  The reason the game is starting.
     *
     * @return  True if the game was started.
     */
    boolean start(ArenaStartReason reason);

    /**
     * End the current game.
     *
     * @return  True if the game was ended.
     */
    boolean end();

    /**
     * Forward a player in the current game to another arena.
     *
     * @param player     The player to forward.
     * @param nextArena  The arena to forward the player to.
     *
     * @return  True if the player was forwarded.
     */
    boolean forwardPlayer(IArenaPlayer player, IArena nextArena);

    /**
     * Set the winner of an arena and end the game.
     *
     * @param player  The winning player.
     *
     * @return  True if the player was set as the winner.
     */
    boolean setWinner(IArenaPlayer player);

    /**
     * Set the specified team as the winner and
     * end the game.
     *
     * @param team  The winning team.
     */
    boolean setWinner(ArenaTeam team);

    /**
     * Set the specified team as the losers of a match and
     * remove all players in the team from the game.
     *
     * @param team  The losing team.
     *
     * @return  True if the team was set as losing.
     */
    boolean setLoser(ArenaTeam team);
}


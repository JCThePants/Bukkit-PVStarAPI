/* This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
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


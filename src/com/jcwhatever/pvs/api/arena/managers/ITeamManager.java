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
import com.jcwhatever.pvs.api.arena.ArenaTeam;

import java.util.Set;

/**
 * Manages teams in an arena.
 */
public interface ITeamManager {

    /**
     * Get the owning arena.
     */
    IArena getArena();

    /**
     * Get available teams in the arena. Available teams
     * are determined by the teams set on spawnpoints in
     * the spawn manager.
     */
    Set<ArenaTeam> getTeams();

    /**
     * Get the teams currently in the arena.
     */
    Set<ArenaTeam> getCurrentTeams();

    /**
     * Get the total number of teams possible in the arena.
     */
    int totalTeams();

    /**
     * Get the number of teams currently in the arena.
     */
    int totalCurrentTeams();
}

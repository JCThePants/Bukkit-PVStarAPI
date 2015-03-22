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
import com.jcwhatever.bukkit.pvs.api.arena.options.NameMatchMode;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

/**
 * Manages arenas.
 */
public interface ArenaManager {

    /**
     * Get the command senders selected arena.
     *
     * @param sender  The command sender.
     */
    @Nullable
    Arena getSelectedArena(CommandSender sender);

    /**
     * Set the command senders selected arena.
     *
     * @param sender  The command sender.
     * @param arena   The arena.
     */
    void setSelectedArena(CommandSender sender, Arena arena);

    /**
     * Change an arenas name.
     *
     * @param arenaId  The id of the arena.
     * @param name     The new arena name.
     */
    boolean setArenaName(UUID arenaId, String name);

    /**
     * Get an arena by id.
     *
     * @param arenaId  The id of the arena.
     */
    @Nullable
    Arena getArena(UUID arenaId);

    /**
     * Get the arena the player is in.
     *
     * @param player  The player to check.
     */
    @Nullable
    Arena getArena(Player player);

    /**
     * Get the arena the location is in.
     *
     * @param location  The location.
     */
    @Nullable
    Arena getArena(Location location);

    /**
     * Get a list of arenas by name and match mode.
     *
     * @param arenaName  The name to search.
     * @param matchMode  The search match mode.
     */
    List<Arena> getArena(String arenaName, NameMatchMode matchMode);

    /**
     * Get a list of all arenas.
     */
    List<Arena> getArenas();

    /**
     * Get the total number of arenas.
     */
    int getArenaCount();

    /**
     * Add an arena.
     *
     * @param arenaName  The name of the arena.
     * @param typeName   The name of the type.
     *
     * @return  Null if failed to create arena.
     */
    @Nullable
    Arena addArena(String arenaName, String typeName);

    /**
     * Remove an arena.
     *
     * @param arenaId  The id of the arena.
     *
     * @return  True if the arena was found and removed.
     */
    boolean removeArena(UUID arenaId);
}

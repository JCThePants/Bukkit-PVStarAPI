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

package com.jcwhatever.pvs.api.arena.collections;

import com.jcwhatever.nucleus.mixins.IReadOnly;
import com.jcwhatever.nucleus.providers.npc.INpc;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.INpcPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Collection of {@link IArenaPlayer}.
 *
 * <p>Should store instances of {@link INpcPlayer} separately to be retrieved
 * via {@link #getNpcPlayers} method.</p>
 */
public interface IArenaPlayerCollection extends Collection<IArenaPlayer>, IReadOnly {

    /**
     * Determine if the list can be modified.
     *
     * @return  True if the list cannot be modified, otherwise false.
     */
    @Override
    boolean isReadOnly();

    /**
     * Get all Bukkit players in the collection, not including Npc players.
     */
    Collection<Player> toBukkit();

    /**
     * Add all Bukkit players in the collection to the specified output collection,
     * not including Npc players.
     *
     * @param output  The output collection.
     *
     * @return  The output collection.
     */
    <T extends Collection<Player>> T toBukkit(T output);

    /**
     * Get all Npc players in the collection.
     */
    Collection<INpc> getNpcPlayers();

    /**
     * Add all Npc players in the collection to the specified output collection.
     *
     * @param output  The output collection.
     *
     * @return  The output collection.
     */
    <T extends Collection<INpc>> T getNpcPlayers(T output);

    /**
     * Determine if there are any Npc players in the collection.
     */
    boolean hasNpcPlayers();

    /**
     * Get the number of Npc's in the collection.
     */
    int totalNpcPlayers();

}

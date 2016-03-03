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

package com.jcwhatever.pvs.api.utils;

import com.jcwhatever.nucleus.collections.wrap.IteratorWrapper;
import com.jcwhatever.nucleus.providers.npc.INpc;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.IBukkitPlayer;
import com.jcwhatever.pvs.api.arena.INpcPlayer;
import com.jcwhatever.pvs.api.arena.collections.IArenaPlayerCollection;
import com.jcwhatever.pvs.api.arena.collections.IArenaPlayerSet;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * {@link HashSet} implementation of {@link IArenaPlayerCollection}.
 */
public class ArenaPlayerHashSet extends HashSet<IArenaPlayer> implements IArenaPlayerSet {

    public static final ArenaPlayerHashSet EMPTY = new ArenaPlayerHashSet(0).seal();

    private boolean _isReadonly;
    private Set<Player> _players;
    private Set<INpc> _npcs;

    /**
     * Constructor.
     */
    public ArenaPlayerHashSet() {
        super(15);
    }

    /**
     * Constructor.
     *
     * @param capacity  The initial capacity of the set.
     */
    public ArenaPlayerHashSet(int capacity) {
        super(capacity);
    }

    /**
     * Constructor.
     *
     * @param players     The players to initialize the set with.
     * @param isReadonly  True to make the set readonly, otherwise false.
     */
    public ArenaPlayerHashSet(Collection<? extends IArenaPlayer> players, boolean isReadonly) {
        super(players);
        _isReadonly = isReadonly;
    }

    /**
     * Constructor.
     *
     * @param players     The players to initialize the collection with.
     * @param isReadonly  True to make the list readonly, otherwise false.
     */
    public ArenaPlayerHashSet(ArenaPlayerHashSet players, boolean isReadonly) {
        super(players);
        _players = players._players;
        _npcs = players._npcs;
        _isReadonly = isReadonly;
    }

    /**
     * Make the set read-only.
     */
    public ArenaPlayerHashSet seal() {
        _isReadonly = true;

        return this;
    }

    @Override
    public boolean isReadOnly() {
        return _isReadonly;
    }

    @Override
    public Collection<Player> toBukkit() {
        if (_players != null)
            return _players;

        Set<Player> players = new HashSet<>(size());

        for (IArenaPlayer arenaPlayer : this) {
            if (arenaPlayer instanceof IBukkitPlayer)
                players.add(((IBukkitPlayer) arenaPlayer).getPlayer());
        }

        return _players = Collections.unmodifiableSet(players);
    }

    @Override
    public <T extends Collection<Player>> T toBukkit(T output) {
        PreCon.notNull(output);

        if (output instanceof ArrayList)
            ((ArrayList) output).ensureCapacity(output.size() + size());

        output.addAll(toBukkit());
        return output;
    }

    @Override
    public Collection<INpc> getNpcPlayers() {
        if (_npcs != null)
            return _npcs;

        Set<INpc> npcs = new HashSet<>(size());

        for (IArenaPlayer arenaPlayer : this) {
            if (arenaPlayer instanceof INpcPlayer)
                npcs.add(((INpcPlayer) arenaPlayer).getNpc());
        }

        return _npcs = Collections.unmodifiableSet(npcs);
    }

    @Override
    public <T extends Collection<INpc>> T getNpcPlayers(T output) {
        PreCon.notNull(output);

        if (output instanceof ArrayList)
            ((ArrayList) output).ensureCapacity(output.size() + size());

        output.addAll(getNpcPlayers());
        return output;
    }

    @Override
    public boolean hasNpcPlayers() {
        return !getNpcPlayers().isEmpty();
    }

    @Override
    public int totalNpcPlayers() {
        return getNpcPlayers().size();
    }

    @Override
    public boolean add(IArenaPlayer iArenaPlayer) {
        onModify();
        return super.add(iArenaPlayer);
    }

    @Override
    public boolean remove(Object o) {
        onModify();
        return super.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends IArenaPlayer> c) {
        onModify();
        return super.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        onModify();
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        onModify();
        return super.retainAll(c);
    }

    @Override
    public Iterator<IArenaPlayer> iterator() {
        return new IteratorWrapper<IArenaPlayer>() {

            Iterator<IArenaPlayer> iterator =  ArenaPlayerHashSet.super.iterator();

            @Override
            protected Iterator<IArenaPlayer> iterator() {
                return iterator;
            }

            @Override
            protected boolean onRemove(IArenaPlayer player) {
                onModify();
                return true;
            }
        };
    }

    @Override
    public void clear() {
        onModify();
        super.clear();
    }

    private void onModify() {
        if (_isReadonly)
            throw new UnsupportedOperationException("The ArenaPlayer set is readonly.");

        _players = null;
        _npcs = null;
    }
}

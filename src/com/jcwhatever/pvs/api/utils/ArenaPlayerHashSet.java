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

import com.jcwhatever.nucleus.collections.wrap.ConversionSetWrapper;
import com.jcwhatever.nucleus.collections.wrap.SetWrapper;
import com.jcwhatever.nucleus.utils.player.PlayerUtils;
import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.pvs.api.arena.collections.ArenaPlayerCollection;
import com.jcwhatever.pvs.api.arena.collections.ArenaPlayerSet;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link HashSet} implementation of {@link ArenaPlayerCollection}.
 */
public class ArenaPlayerHashSet extends SetWrapper<ArenaPlayer> implements ArenaPlayerSet {

    public static final ArenaPlayerHashSet EMPTY = new ArenaPlayerHashSet(0).seal();

    private final Set<ArenaPlayer> _set;
    private final Set<Player> _asPlayerSet = new PlayerSet();

    private boolean _isReadonly;

    /**
     * Constructor.
     */
    public ArenaPlayerHashSet() {
        _set = new HashSet<>(15);
    }

    /**
     * Constructor.
     *
     * @param capacity  The initial capacity of the set.
     */
    public ArenaPlayerHashSet(int capacity) {
        _set = new HashSet<>(capacity);
    }

    /**
     * Constructor.
     *
     * @param players     The players to initialize the set with.
     * @param isReadonly  True to make the set readonly, otherwise false.
     */
    public ArenaPlayerHashSet(Collection<? extends ArenaPlayer> players, boolean isReadonly) {
        _set = new HashSet<>(players);
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
    public Set<Player> asPlayers() {
        return _asPlayerSet;
    }

    @Override
    protected Set<ArenaPlayer> set() {
        return _set;
    }

    @Override
    protected boolean onPreAdd(ArenaPlayer player) {

        if (_isReadonly)
            throw new UnsupportedOperationException("The ArenaPlayer list is readonly.");

        return true;
    }

    @Override
    protected boolean onPreRemove(Object o) {

        if (_isReadonly)
            throw new UnsupportedOperationException("The ArenaPlayer list is readonly.");

        return true;
    }

    private class PlayerSet extends ConversionSetWrapper<Player, ArenaPlayer> {

        @Override
        protected Set<ArenaPlayer> set() {
            return _set;
        }

        @Override
        protected Player convert(ArenaPlayer internal) {
            return PlayerUtils.getPlayer(internal);
        }

        @Override
        protected ArenaPlayer unconvert(Object external) {
            return PVStarAPI.getArenaPlayer(external);
        }
    }
}

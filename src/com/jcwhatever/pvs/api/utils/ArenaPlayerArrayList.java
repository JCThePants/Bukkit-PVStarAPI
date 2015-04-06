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

import com.jcwhatever.nucleus.collections.wrap.ConversionListWrapper;
import com.jcwhatever.nucleus.collections.wrap.ListWrapper;
import com.jcwhatever.nucleus.utils.player.PlayerUtils;
import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import com.jcwhatever.pvs.api.arena.collections.IArenaPlayerList;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@link ArrayList} implementation of {@link IArenaPlayerList}.
 */
public class ArenaPlayerArrayList extends ListWrapper<IArenaPlayer> implements IArenaPlayerList {

    public static final ArenaPlayerArrayList EMPTY = new ArenaPlayerArrayList(0).seal();

    private final List<IArenaPlayer> _list;
    private final List<Player> _asPlayerList = new PlayerList();

    private boolean _isReadonly;

    /**
     * Constructor.
     */
    public ArenaPlayerArrayList() {
        _list = new ArrayList<>(15);
    }

    /**
     * Constructor.
     *
     * @param capacity  The initial capacity.
     */
    public ArenaPlayerArrayList(int capacity) {
        _list = new ArrayList<>(capacity);
    }

    /**
     * Constructor.
     *
     * @param players     The players to initialize the collection with.
     * @param isReadonly  True to make the list readonly, otherwise false.
     */
    public ArenaPlayerArrayList(Collection<? extends IArenaPlayer> players, boolean isReadonly) {
        _list = new ArrayList<>(players);
        _isReadonly = isReadonly;
    }

    /**
     * Make the list read-only.
     */
    public ArenaPlayerArrayList seal() {
        _isReadonly = true;

        return this;
    }

    @Override
    public boolean isReadOnly() {
        return _isReadonly;
    }

    @Override
    public List<Player> asPlayers() {
        return _asPlayerList;
    }

    @Override
    protected List<IArenaPlayer> list() {
        return _list;
    }

    @Override
    protected boolean onPreAdd(IArenaPlayer player) {

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

    private class PlayerList extends ConversionListWrapper<Player, IArenaPlayer> {

        @Override
        protected List<IArenaPlayer> list() {
            return _list;
        }

        @Override
        protected Player convert(IArenaPlayer internal) {
            return PlayerUtils.getPlayer(internal);
        }

        @Override
        protected IArenaPlayer unconvert(Object external) {
            return PVStarAPI.getArenaPlayer(external);
        }
    }
}

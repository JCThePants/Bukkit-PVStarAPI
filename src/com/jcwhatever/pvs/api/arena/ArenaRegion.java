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


package com.jcwhatever.pvs.api.arena;

import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.events.region.ArenaRegionPreRestoreEvent;
import com.jcwhatever.pvs.api.events.region.ArenaRegionPreSaveEvent;
import com.jcwhatever.pvs.api.events.region.ArenaRegionRestoredEvent;
import com.jcwhatever.pvs.api.events.region.ArenaRegionSavedEvent;
import com.jcwhatever.pvs.api.events.region.PlayerEnterArenaRegionEvent;
import com.jcwhatever.pvs.api.events.region.PlayerLeaveArenaRegionEvent;
import com.jcwhatever.nucleus.regions.RegionPriorityInfo;
import com.jcwhatever.nucleus.regions.RestorableRegion;
import com.jcwhatever.nucleus.regions.options.EnterRegionReason;
import com.jcwhatever.nucleus.regions.options.LeaveRegionReason;
import com.jcwhatever.nucleus.regions.options.RegionEventPriority;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.nucleus.utils.MetaKey;

import org.bukkit.entity.Player;

/**
 * A region that represents the bounds of an arena.
 */
@RegionPriorityInfo(enter = RegionEventPriority.HIGH, leave = RegionEventPriority.LOW)
public class ArenaRegion extends RestorableRegion {

    public static final MetaKey<ArenaRegion>
            ARENA_REGION_KEY = new MetaKey<ArenaRegion>(ArenaRegion.class);

    private final Arena _arena;

    /**
     * Constructor.
     *
     * @param arena     The owning arena.
     * @param dataNode  The regions data node.
     */
    public ArenaRegion(Arena arena, IDataNode dataNode) {
        super(PVStarAPI.getPlugin(), arena.getId().toString(), dataNode);
        _arena = arena;

        getMeta().set(ARENA_REGION_KEY, this);

        setEventListener(true);
    }

    /**
     * Get the owning arena.
     */
    public Arena getArena() {
        return _arena;
    }

    /**
     * Determine if {@link #onPlayerEnter} can be called.
     *
     * @param player  The player entering the region.
     *
     * @return  True to allow calling {@link #onPlayerEnter}.
     */
    @Override
    protected boolean canDoPlayerEnter(Player player, EnterRegionReason reason) {
        return getArena().getSettings().isEnabled() &&
                PVStarAPI.getPlugin().isEnabled();
    }

    /**
     * Called when a player enters the region.
     *
     * @param p  The player entering the region.
     */
    @Override
    protected void onPlayerEnter(Player p, EnterRegionReason reason) {

        final ArenaPlayer player = PVStarAPI.getArenaPlayer(p);

        _arena.getEventManager().call(this, new PlayerEnterArenaRegionEvent(_arena, player, reason));
    }

    /**
     * Determine if {@link #onPlayerLeave} can be called.
     *
     * @param player  The player leaving the region.
     *
     * @return  True to allow calling {@link #onPlayerLeave}.
     */
    @Override
    protected boolean canDoPlayerLeave(Player player, LeaveRegionReason reason) {
        return getArena().getSettings().isEnabled() &&
               PVStarAPI.getPlugin().isEnabled();
    }

    /**
     * Called when a player leaves the region.
     *
     * @param p  The player leaving the region.
     */
    @Override
    protected void onPlayerLeave(Player p, LeaveRegionReason reason) {

        ArenaPlayer player = PVStarAPI.getArenaPlayer(p);

        _arena.getEventManager().call(this, new PlayerLeaveArenaRegionEvent(_arena, player, reason));
    }

    /**
     * The file prefix of region save files.
     */
    @Override
    protected final String getFilePrefix() {
        return "arena." + _arena.getId();
    }

    /**
     * Called when the arena region is saved to disk.
     */
    @Override
    protected void onSave() {
        getArena().setBusy();
        _arena.getEventManager().call(this, new ArenaRegionPreSaveEvent(_arena));
    }

    /**
     * Called when the arena region save operation is completed.
     */
    @Override
    protected void onSaveComplete() {
        getArena().setIdle();
        _arena.getEventManager().call(this, new ArenaRegionSavedEvent(_arena));
    }

    /**
     * Called when the arena region is restored from disk.
     */
    @Override
    protected void onRestore() {
        getArena().setBusy();
        _arena.getEventManager().call(this, new ArenaRegionPreRestoreEvent(_arena));
    }

    /**
     * Called when the arena region restore operation is complete.
     */
    @Override
    protected void onRestoreComplete() {
        getArena().setIdle();
        _arena.getEventManager().call(this, new ArenaRegionRestoredEvent(_arena));
    }
}

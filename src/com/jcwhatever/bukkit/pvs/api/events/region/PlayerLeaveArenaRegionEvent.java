package com.jcwhatever.bukkit.pvs.api.events.region;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * Called when a player leaves an arena region.
 */
public class PlayerLeaveArenaRegionEvent extends AbstractArenaEvent {

    private ArenaPlayer _player;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player leaving the arena.
     */
    public PlayerLeaveArenaRegionEvent(Arena arena, ArenaPlayer player) {
        super(arena, false);
        PreCon.notNull(player);

        _player = player;
    }

    /**
     * Get the player leaving the arena region.
     */
    public ArenaPlayer getPlayer() {
        return _player;
    }
}

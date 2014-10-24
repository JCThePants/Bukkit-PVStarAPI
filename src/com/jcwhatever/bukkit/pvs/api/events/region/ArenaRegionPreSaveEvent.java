package com.jcwhatever.bukkit.pvs.api.events.region;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * Called before an arena region is saved.
 */
public class ArenaRegionPreSaveEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaRegionPreSaveEvent(Arena arena) {
        super(arena, false);
    }
}

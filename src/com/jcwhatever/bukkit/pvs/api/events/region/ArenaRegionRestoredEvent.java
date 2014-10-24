package com.jcwhatever.bukkit.pvs.api.events.region;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * Called after an arena region is restored.
 */
public class ArenaRegionRestoredEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaRegionRestoredEvent(Arena arena) {
        super(arena, false);
    }
}

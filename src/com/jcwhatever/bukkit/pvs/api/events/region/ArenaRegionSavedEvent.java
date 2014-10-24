package com.jcwhatever.bukkit.pvs.api.events.region;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * Called after an arena region is saved.
 */
public class ArenaRegionSavedEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaRegionSavedEvent(Arena arena) {
        super(arena, false);
    }

}


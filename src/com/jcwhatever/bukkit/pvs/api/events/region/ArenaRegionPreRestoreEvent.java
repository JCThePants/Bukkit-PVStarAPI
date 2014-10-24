package com.jcwhatever.bukkit.pvs.api.events.region;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * Called before an arena region is restored.
 */
public class ArenaRegionPreRestoreEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaRegionPreRestoreEvent(Arena arena) {
        super(arena, false);
    }
}

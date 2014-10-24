package com.jcwhatever.bukkit.pvs.api.events.spawns;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * Called when reserved spawns are cleared for an arena.
 */
@Cancellable
public class ClearReservedSpawnsEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ClearReservedSpawnsEvent (Arena arena) {
        super(arena, true);
    }
}

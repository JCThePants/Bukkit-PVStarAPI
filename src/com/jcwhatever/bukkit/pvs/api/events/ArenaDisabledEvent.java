package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Called when an arena is disabled.
 */
public class ArenaDisabledEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaDisabledEvent(Arena arena) {
        super(arena, false);
    }
}

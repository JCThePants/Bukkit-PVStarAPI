package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Called after an arena is enabled.
 */
public class ArenaEnabledEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaEnabledEvent(Arena arena) {
        super(arena, false);
    }
}


package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Called when an arena is being permanently removed.
 */
public class ArenaDisposeEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaDisposeEvent(Arena arena) {
        super(arena, false);
    }
}
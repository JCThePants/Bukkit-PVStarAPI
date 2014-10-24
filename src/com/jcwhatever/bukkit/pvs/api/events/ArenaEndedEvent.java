package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Called when an arena game ends.
 */
public class ArenaEndedEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaEndedEvent(Arena arena) {
        super(arena, false);
    }
}
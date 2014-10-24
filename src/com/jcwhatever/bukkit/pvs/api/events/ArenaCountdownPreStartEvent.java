package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Called before an arena game start countdown begins.
 */
@Cancellable
public class ArenaCountdownPreStartEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaCountdownPreStartEvent(Arena arena) {
        super(arena, true);
    }
}

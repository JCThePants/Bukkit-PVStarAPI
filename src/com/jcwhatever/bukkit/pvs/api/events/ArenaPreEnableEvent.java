package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Called before an arena is enabled.
 */
@Cancellable
public class ArenaPreEnableEvent extends AbstractArenaEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     */
    public ArenaPreEnableEvent(Arena arena) {
        super(arena, true);
    }
}

package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.options.ArenaStartReason;

/**
 * Called before an arena is started.
 */
@Cancellable
public class ArenaPreStartEvent extends AbstractArenaEvent {

    private ArenaStartReason _reason;

    /**
     * Constructor.
     *
     * @param arena   The arena.
     * @param reason  The reason the arena is starting.
     */
    public ArenaPreStartEvent(Arena arena, ArenaStartReason reason) {
        super(arena, true);

        PreCon.notNull(reason);

        _reason = reason;
    }

    /**
     * Get the reason the arena is starting.
     */
    public ArenaStartReason getReason() {
        return _reason;
    }
}

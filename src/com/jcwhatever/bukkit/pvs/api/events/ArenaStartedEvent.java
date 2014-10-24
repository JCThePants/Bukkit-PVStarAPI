package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.options.ArenaStartReason;

/**
 * Called when an arena game starts.
 */
public class ArenaStartedEvent extends AbstractArenaEvent {

    private ArenaStartReason _reason;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param reason  The reason the arena was started.
     */
    public ArenaStartedEvent(Arena arena, ArenaStartReason reason) {
        super(arena, false);

        PreCon.notNull(reason);

        _reason = reason;
    }

    /**
     * Get the reason the arena was started.
     */
    public ArenaStartReason getReason() {
        return _reason;
    }
}

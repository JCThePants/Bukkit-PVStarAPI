package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

public class ArenaCountdownStartedEvent extends AbstractArenaEvent {

    public ArenaCountdownStartedEvent(Arena arena) {
        super(arena, false);
    }
}

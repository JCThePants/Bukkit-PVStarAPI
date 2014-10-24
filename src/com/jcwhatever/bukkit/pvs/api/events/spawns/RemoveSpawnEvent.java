package com.jcwhatever.bukkit.pvs.api.events.spawns;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;

/**
 * Called when a spawnpoint is removed from an arena.
 */
@Cancellable
public class RemoveSpawnEvent extends AbstractSpawnEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     * @param spawn  The spawnpoint being removed.
     */
    public RemoveSpawnEvent(Arena arena, Spawnpoint spawn) {
        super(arena, spawn, true);
    }
}

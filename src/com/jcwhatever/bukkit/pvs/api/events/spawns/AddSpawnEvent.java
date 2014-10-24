package com.jcwhatever.bukkit.pvs.api.events.spawns;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;

/**
 * Called when a spawn is added to an arena.
 */
@Cancellable
public class AddSpawnEvent extends AbstractSpawnEvent {

    /**
     * Constructor.
     *
     * @param arena  The event arena.
     * @param spawn  The spawnpoint being added.
     */
    public AddSpawnEvent(Arena arena, Spawnpoint spawn) {
        super(arena, spawn, true);
    }
}

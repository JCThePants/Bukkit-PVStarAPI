package com.jcwhatever.bukkit.pvs.api.events.spawns;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;

/**
 * Base class for spawn events.
 */
public abstract class AbstractSpawnEvent extends AbstractArenaEvent {

    private Spawnpoint _spawn;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param spawn          The event spawnpoint.
     * @param isCancellable  True if the event is cancellable.
     */
    public AbstractSpawnEvent(Arena arena, Spawnpoint spawn, boolean isCancellable) {
        super(arena, isCancellable);

        PreCon.notNull(spawn);

        _spawn = spawn;
    }

    public Spawnpoint getSpawnpoint() {
        return _spawn;
    }
}

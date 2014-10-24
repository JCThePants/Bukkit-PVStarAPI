package com.jcwhatever.bukkit.pvs.api.events.spawns;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;

/**
 * Called when a spawnpoint is reserved in an arena.
 */
@Cancellable
public class ReserveSpawnEvent extends AbstractSpawnEvent {

    private ArenaPlayer _player;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player the spawnpoint is being reserved for.
     * @param spawn   The spawnpoint being reserved.
     */
    public ReserveSpawnEvent(Arena arena, ArenaPlayer player, Spawnpoint spawn) {
        super(arena, spawn, true);

        PreCon.notNull(player);

        _player = player;
    }

    /**
     * Get the player the spawnpoint is being reserved for.
     */
    public ArenaPlayer getPlayer() {
        return _player;
    }
}

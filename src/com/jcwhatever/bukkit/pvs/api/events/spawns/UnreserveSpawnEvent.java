package com.jcwhatever.bukkit.pvs.api.events.spawns;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;

/**
 * Called when a spawnpoint reservation is removed in an arena.
 */
@Cancellable
public class UnreserveSpawnEvent extends AbstractSpawnEvent {

    private ArenaPlayer _player;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player the spawnpoint was reserved for.
     * @param spawn   The spawnpoint being unreserved.
     */
    public UnreserveSpawnEvent(Arena arena, ArenaPlayer player, Spawnpoint spawn) {
        super(arena, spawn, true);

        PreCon.notNull(player);

        _player = player;
    }

    /**
     * Get the player the spawnpoint was reserved for.
     * @return
     */
    public ArenaPlayer getPlayer() {
        return _player;
    }
}
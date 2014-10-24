package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

/**
 * An arena event that deals with a player
 */
public abstract class AbstractPlayerEvent extends AbstractArenaEvent {

    private final ArenaPlayer _player;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param player         The event player.
     * @param isCancellable  True if the event is cancellable.
     */
    public AbstractPlayerEvent(Arena arena, ArenaPlayer player, boolean isCancellable) {
        super(arena, isCancellable);

        PreCon.notNull(player);

        _player = player;
    }

    /**
     * Get the event player.
     */
    public ArenaPlayer getPlayer() {
        return _player;
    }

}

package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Called when a player in an arena moves.
 */
@Cancellable
public class PlayerArenaMoveEvent extends AbstractPlayerEvent {

    private PlayerMoveEvent _event;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The moving player.
     * @param event   The parent event.
     */
    public PlayerArenaMoveEvent(Arena arena, ArenaPlayer player, PlayerMoveEvent event) {
        super(arena, player, true);

        PreCon.notNull(event);

        _event = event;
    }

    /**
     * Get the location the player is moving from.
     */
    public Location getFrom() {
        return _event.getFrom();
    }

    /**
     * Get the location the player is moving to.
     */
    public Location getTo() {
        return _event.getTo();
    }

    /**
     * Set the location the player is moving from.
     *
     * @param location  The location.
     */
    public void setFrom(Location location) {
        _event.setFrom(location);
    }

    /**
     * Set the location the player is moving to.
     *
     * @param location  The location.
     */
    public void setTo(Location location) {
        _event.setTo(location);
    }

    /**
     * Get the parent event.
     */
    public PlayerMoveEvent getParentEvent() {
        return _event;
    }
}

package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.options.RemovePlayerReason;
import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Called after a player is removed from an arena.
 */
public class PlayerRemovedEvent extends AbstractPlayerEvent {

    private final RemovePlayerReason _reason;
    private final Location _initialRestoreLocation;
    private Location _restoreLocation;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player who was removed.
     * @param reason  The reason the player was removed.
     */
    public PlayerRemovedEvent(Arena arena, ArenaPlayer player, RemovePlayerReason reason, @Nullable Location restoreLocation) {
        super(arena, player, false);

        PreCon.notNull(reason);

        _reason = reason;
        _initialRestoreLocation = restoreLocation;
        _restoreLocation = restoreLocation;
    }

    /**
     * Get the reason the player was removed.
     */
    public RemovePlayerReason getReason() {
        return _reason;
    }

    /**
     * Determine if the player is being restored to a location.
     */
    public boolean isRestoring() {
        return _reason != RemovePlayerReason.FORWARDING &&
               _reason != RemovePlayerReason.ARENA_RELATION_CHANGE &&
               _reason != RemovePlayerReason.LOGOUT;
    }

    /**
     * Get the restore location initially set when
     * the event was called.
     */
    public Location getInitialRestoreLocation() {
        return isRestoring() ? _initialRestoreLocation : null;
    }

    /**
     * Get the restore location.
     */
    public Location getRestoreLocation() {
        return isRestoring() ? _restoreLocation : null;
    }

    /**
     * Set the restore location.
     *
     * @param location The location.
     */
    public void setRestoreLocation(Location location) {
        _restoreLocation = location;
    }
}

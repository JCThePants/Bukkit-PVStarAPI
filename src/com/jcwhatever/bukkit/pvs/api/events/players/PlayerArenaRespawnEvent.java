package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import org.bukkit.Location;

/**
 * Called when a player is respawned in an arena.
 */
public class PlayerArenaRespawnEvent extends AbstractPlayerEvent {

    private Location _respawnLocation;
    private Location _originalRespawnLocation;

    /**
     * Constructor.
     *
     * @param arena            The event arena.
     * @param player           The player being respawned.
     * @param respawnLocation  The location the player will be respawned at.
     */
    public PlayerArenaRespawnEvent(Arena arena, ArenaPlayer player, Location respawnLocation) {
        super(arena, player, false);

        PreCon.notNull(respawnLocation);

        _respawnLocation = respawnLocation;
        _originalRespawnLocation = respawnLocation;
    }

    /**
     * Get the respawn location set when the event was called.
     */
    public Location getInitialRespawnLocation() {
        return _originalRespawnLocation;
    }

    /**
     * Get the respawn location.
     */
    public Location getRespawnLocation() {
        return _respawnLocation;
    }

    /**
     * Set the respawn location.
     *
     * @param location  The location.
     */
    public void setRespawnLocation(Location location) {
        PreCon.notNull(location);

        _respawnLocation = location;
    }
}

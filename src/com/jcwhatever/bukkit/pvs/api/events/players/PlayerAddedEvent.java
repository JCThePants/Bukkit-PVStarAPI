package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.options.AddPlayerReason;
import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Called when player is added to an arena.
 */
public class PlayerAddedEvent extends AbstractPlayerEvent {

    private final AddPlayerReason _reason;
    private Location _initialSpawnLocation;
    private Location _spawnLocation;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param player         The player being added.
     * @param reason         The reason the player is being added.
     * @param spawnLocation  The location the player will be teleported to, if any.
     */
    public PlayerAddedEvent(Arena arena, ArenaPlayer player, AddPlayerReason reason, @Nullable Location spawnLocation) {
        super(arena, player, false);

        PreCon.notNull(reason);

        _reason = reason;
        _initialSpawnLocation = spawnLocation;
        _spawnLocation = spawnLocation;
    }

    /**
     * Get the reason the player is being added.
     */
    public AddPlayerReason getReason() {
        return _reason;
    }

    /**
     * Get the spawn location set when the event was called.
     */
    @Nullable
    public Location getInitialSpawnLocation() {
        return _initialSpawnLocation;
    }

    /**
     * Get the current spawn location.
     * @return
     */
    @Nullable
    public Location getSpawnLocation() {
        return _spawnLocation;
    }

    /**
     * Set the players spawn location.
     *
     * @param location  The location to spawn the player. Null to prevent teleport.
     */
    public void setSpawnLocation(@Nullable Location location) {
        _spawnLocation = location;
    }

}

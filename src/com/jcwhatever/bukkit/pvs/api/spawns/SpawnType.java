package com.jcwhatever.bukkit.pvs.api.spawns;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents the type of spawn of a spawn point. If the spawn type
 * represents a mob, the mob can be spawned using the instance.
 */
public abstract class SpawnType {

    private String _searchName;

    /**
     * Get the spawn type name.
     */
    public abstract String getName();

    /**
     * Get the spawn type name in lowercase.
     */
    public final String getSearchName() {
        if (_searchName == null)
            _searchName = getName().toLowerCase();

        return _searchName;
    }

    /**
     * Get the spawn type description.
     * @return
     */
    public abstract String getDescription();


    /**
     * Determine if the spawn type can spawn entities.
     */
    public abstract boolean isSpawner();

    /**
     * Determine if the spawn type spawns a living entity.
     */
    public abstract boolean isAlive();

    /**
     * Determine if the spawn type spawns a living entity that is
     * hostile or can be hostile.
     */
    public abstract boolean isHostile();

    /**
     * Get an array of entity types the spawn type can spawn.
     *
     * <p>Returns null if the spawn type cannot spawn mobs.</p>
     */
    @Nullable
    public abstract EntityType[] getEntityTypes();


    /**
     * Spawn a mob.
     *
     * <p>Returns null if the spawn type is not capable of spawning mobs.</p>
     *
     * @param arena     The arena the mob is being spawned for.
     * @param location  The location to spawn the mob at.
     * @return
     */
    @Nullable
    public abstract List<Entity> spawn(Arena arena, Location location, int count);

}

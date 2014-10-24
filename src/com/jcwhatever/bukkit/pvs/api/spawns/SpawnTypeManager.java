package com.jcwhatever.bukkit.pvs.api.spawns;

import org.bukkit.entity.EntityType;

import javax.annotation.Nullable;
import java.util.List;

public interface SpawnTypeManager {

    /**
     * Get the spawn type used to mark lobby spawn points.
     */
    SpawnType getLobbySpawnType();

    /**
     * Get the spawn type used to mark game spawn points.
     */
    SpawnType getGameSpawnType();

    /**
     * Get the spawn type used to mark spectator spawn points.
     * @return
     */
    SpawnType getSpectatorSpawnType();

    /**
     * Get all registered spawn types.
     */
    List<SpawnType> getSpawnTypes();

    /**
     * Get spawn types that can spawn the specified entity type.
     *
     * @param entityType  The entity type to check.
     */
    List<SpawnType> getSpawnTypes(EntityType entityType);

    /**
     * Get a spawn type by type name.
     *
     * @param typeName  The type name.
     */
    @Nullable
    SpawnType getType(String typeName);

    /**
     * Register a spawn type
     *
     * @param spawnType  The type to register
     * @return
     */
    boolean registerType(SpawnType spawnType);

}

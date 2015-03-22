/*
 * This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
 *
 * Copyright (c) JCThePants (www.jcwhatever.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package com.jcwhatever.bukkit.pvs.api.spawns;

import org.bukkit.entity.EntityType;

import java.util.List;
import javax.annotation.Nullable;

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
     *
     * @return  The {@link SpawnType} or null if not found.
     */
    @Nullable
    SpawnType getType(String typeName);

    /**
     * Register a spawn type
     *
     * @param spawnType  The type to register
     *
     * @return  True if the type was registered successfully.
     */
    boolean registerType(SpawnType spawnType);
}

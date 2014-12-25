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

import com.jcwhatever.generic.mixins.INamedInsensitive;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.List;
import javax.annotation.Nullable;

/**
 * Represents the type of spawn of a spawn point. If the spawn type
 * represents a mob, the mob can be spawned using the instance.
 */
public abstract class SpawnType implements INamedInsensitive {

    private String _searchName;

    /**
     * Get the spawn type name.
     */
    @Override
    public abstract String getName();

    /**
     * Get the spawn type name in lowercase.
     */
    @Override
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

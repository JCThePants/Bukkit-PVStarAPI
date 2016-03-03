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


package com.jcwhatever.pvs.api.spawns;

import com.jcwhatever.nucleus.managed.teleport.TeleportMode;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.nucleus.utils.coords.NamedLocation;
import com.jcwhatever.pvs.api.arena.ArenaTeam;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.IArenaPlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;
import java.util.List;

/**
 * A named location used for specifying locations within arenas.
 *
 * @author JC The Pants
 *
 */
public class Spawnpoint extends NamedLocation {

    private final SpawnType _type;
    private ArenaTeam _team = ArenaTeam.NONE;

    /**
     * Constructor.
     *
     * @param name   The spawn point name.
     * @param type   The spawn type.
     * @param world  The world.
     * @param x      X coordinates.
     * @param y      Y coordinates.
     * @param z      Z coordinates.
     */
    public Spawnpoint(String name, SpawnType type, World world, double x, double y, double z) {
        this(name, type, world, x, y, z, 0.0f, 0.0f);
    }

    /**
     * Constructor.
     *
     * @param name   The spawn point name.
     * @param type   The spawn type.
     * @param world  The world.
     * @param x      X coordinates.
     * @param y      Y coordinates.
     * @param z      Z coordinates.
     * @param yaw    Yaw angle.
     * @param pitch  Pitch angle.
     */
    public Spawnpoint(String name, SpawnType type, World world,
                      double x, double y, double z, float yaw, float pitch) {
        super(name, world, x, y, z, yaw, pitch);

        PreCon.notNull(type);

        _type = type;
    }

    /**
     * Constructor.
     *
     * @param name      The spawn point name.
     * @param type      The spawn type.
     * @param location  The location data to duplicate.
     */
    public Spawnpoint(String name, SpawnType type, Location location) {
        super(name, location);

        PreCon.notNull(type);

        _type = type;
    }

    /**
     * Constructor.
     *
     * @param name   The spawn point name.
     * @param type   The spawn type.
     * @param team   The spawn team.
     * @param world  The world.
     * @param x      X coordinates.
     * @param y      Y coordinates.
     * @param z      Z coordinates.
     */
    public Spawnpoint(String name, SpawnType type, ArenaTeam team, World world,
                      double x, double y, double z) {
        this(name, type, world, x, y, z);

        PreCon.notNull(team);

        _team = team;
    }

    /**
     * Constructor.
     *
     * @param name   The spawn point name.
     * @param type   The spawn type.
     * @param team   The spawn team.
     * @param world  The world.
     * @param x      X coordinates.
     * @param y      Y coordinates.
     * @param z      Z coordinates.
     * @param yaw    Yaw angle.
     * @param pitch  Pitch angle.
     */
    public Spawnpoint(String name, SpawnType type, ArenaTeam team, World world,
                      double x, double y, double z, float yaw, float pitch) {
        this(name, type, world, x, y, z, yaw, pitch);

        PreCon.notNull(team);

        _team = team;
    }

    /**
     * Constructor.
     *
     * @param name      The spawn point name.
     * @param type      The spawn type.
     * @param team      The spawn team.
     * @param location  The location data to duplicate.
     */
    public Spawnpoint(String name, SpawnType type, ArenaTeam team, Location location) {
        this(name, type, location);

        PreCon.notNull(team);

        _team = team;
    }

    /**
     * Get the type of spawn point.
     */
    public SpawnType getSpawnType() {
        return _type;
    }

    /**
     * Get the spawn point team.
     */
    public ArenaTeam getTeam() {
        return _team;
    }

    /**
     * Spawn an entity if the spawn type allows.
     *
     * @param arena  The arena to spawn for.
     * @param count  The number of entities to spawn.
     *
     * @return Null if the spawn type is not a spawner.
     */
    @Nullable
    public List<Entity> spawn(IArena arena, int count) {
        PreCon.notNull(arena);
        PreCon.greaterThanZero(count);

        if (!_type.isSpawner())
            return null;

        return _type.spawn(arena, this, count);
    }

    /**
     * Teleport an arena player to the spawnpoint.
     *
     * @param player  The player to spawn.
     */
    public void spawn(IArenaPlayer player) {
        PreCon.notNull(player);

        player.teleport(this, TeleportMode.TARGET_ONLY);
    }
}

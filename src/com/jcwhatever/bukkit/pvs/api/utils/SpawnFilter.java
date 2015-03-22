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


package com.jcwhatever.bukkit.pvs.api.utils;

import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.spawns.SpawnType;
import com.jcwhatever.bukkit.pvs.api.spawns.Spawnpoint;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.nucleus.utils.Rand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Utilities to filter collections of spawns.
 */
public class SpawnFilter {

    private SpawnFilter() {}

    /**
     * Filter a collection of {@link Spawnpoint} by team.
     *
     * @param team    The team to return.
     * @param spawns  The spawns to filter.
     */
    public static <T extends Spawnpoint> List<T> filter(ArenaTeam team, Collection<T> spawns) {
        PreCon.notNull(team);
        PreCon.notNull(spawns);

        List<T> results = new ArrayList<>(spawns.size());

        for (T spawn : spawns) {
            if (spawn.getTeam() == team) {
                results.add(spawn);
            }
        }

        return results;
    }

    /**
     * Filter a collection of {@link Spawnpoint} by type.
     *
     * @param type    The spawn type.
     * @param spawns  The spawns to filter.
     */
    public static <T extends Spawnpoint> List<T> filter(SpawnType type, Collection<T> spawns) {
        PreCon.notNull(type);
        PreCon.notNull(spawns);

        List<T> results = new ArrayList<>(spawns.size());

        for (T spawn : spawns) {
            if (type.equals(spawn.getSpawnType())) {
                results.add(spawn);
            }
        }

        return results;
    }

    /**
     * Filter a collection of {@link Spawnpoint} by tyoe and team.
     *
     * @param type    The spawn type.
     * @param team    The team.
     * @param spawns  The spawns to filter.
     */
    public static <T extends Spawnpoint> List<T> filter(SpawnType type, ArenaTeam team, Collection<T> spawns) {
        PreCon.notNull(type);
        PreCon.notNull(team);
        PreCon.notNull(spawns);

        List<T> results = new ArrayList<>(spawns.size());

        for (T spawn : spawns) {
            if (type.equals(spawn.getSpawnType()) && team.equals(spawn.getTeam())) {
                results.add(spawn);
            }
        }

        return results;
    }

    /**
     * Get a random {@link Spawnpoint} from a collection of spawns.
     *
     * @param spawnpoints  The spawnpoint candidates.
     */
    @Nullable
    public static <T extends Spawnpoint> T getRandomSpawn(Collection<T> spawnpoints) {
        PreCon.notNull(spawnpoints);

        if (spawnpoints.size() == 0)
            return null;

        List<T> list;

        list = spawnpoints instanceof List<?>
                ? (List<T>) spawnpoints
                : new ArrayList<T>(spawnpoints.size());

        // choose a random spawn
        return Rand.get(list);
    }

    /**
     * Get a random {@link Spawnpoint} from a collection of spawns that is of the
     * specified team.
     *
     * @param team         The team.
     * @param spawnpoints  The spawn candidates.
     */
    @Nullable
    public static <T extends Spawnpoint> T getRandomSpawn(ArenaTeam team, Collection<T> spawnpoints) {
        PreCon.notNull(team);
        PreCon.notNull(spawnpoints);

        if (spawnpoints.size() == 0)
            return null;

        List<T> filtered = filter(team, spawnpoints);

        if (filtered.size() == 0)
            return null;

        // choose a random spawn
        return Rand.get(filtered);
    }

    /**
     * Get a random {@link Spawnpoint} from a collection of spawns that is of the
     * specified type.
     *
     * @param type         The spawn type.
     * @param spawnpoints  The spawn candidates.
     */
    @Nullable
    public static <T extends Spawnpoint> T getRandomSpawn(SpawnType type, Collection<T> spawnpoints) {
        PreCon.notNull(type);
        PreCon.notNull(spawnpoints);

        if (spawnpoints.size() == 0)
            return null;

        List<T> filtered = filter(type, spawnpoints);

        if (filtered.size() == 0)
            return null;

        // choose a random spawn
        return Rand.get(filtered);
    }

    /**
     * Get a random {@link Spawnpoint} from a collection of spawns that is of the
     * specified type and team.
     *
     * @param type         The spawn type.
     * @param team         The team.
     * @param spawnpoints  The spawn candidates.
     */
    @Nullable
    public static <T extends Spawnpoint> T getRandomSpawn(SpawnType type, ArenaTeam team,
                                                          Collection<T> spawnpoints) {
        PreCon.notNull(type);
        PreCon.notNull(team);
        PreCon.notNull(spawnpoints);

        if (spawnpoints.size() == 0)
            return null;

        List<T> filtered = filter(type, team, spawnpoints);

        if (filtered.size() == 0)
            return null;

        // choose a random spawn
        return Rand.get(filtered);
    }
}

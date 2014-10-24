package com.jcwhatever.bukkit.pvs.api.stats;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * Manages statistics data storage and statistic types.
 */
public interface StatsManager {

    /**
     * Register a statistic type.
     *
     * @param type  The statistic type.
     */
    public void registerType(StatType type);

    /**
     * Get available statistic types.
     * @return
     */
    public List<StatType> getTypes();

    /**
     * Get a statistic type by name.
     *
     * @param name  The name of the statistic.
     */
    @Nullable
    public StatType getType(String name);


    /**
     * Get statistics for an arena.
     *
     * @param arenaId  The id of the arena.
     */
    public ArenaStats getArenaStats(UUID arenaId);

}

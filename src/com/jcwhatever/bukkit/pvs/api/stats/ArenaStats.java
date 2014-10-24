package com.jcwhatever.bukkit.pvs.api.stats;

import com.jcwhatever.bukkit.pvs.api.stats.StatTracking.StatTrackType;

import java.util.Set;
import java.util.UUID;

/**
 * Represents that statistics recorded for an arena.
 */
public interface ArenaStats {

    /**
     * The id of the arena the statistics are from.
     */
    UUID getArenaId();

    /**
     * Get a statistics value.
     *
     * @param type          The statistic type.
     * @param playerId      The id of the player.
     * @param trackingType  The tracking type.
     */
    double getValue(StatType type, UUID playerId, StatTrackType trackingType);

    /**
     * Get a statistics value.
     *
     * @param type          The statistic type.
     * @param playerId      The id of the player as a {@code String}.
     * @param trackingType  The tracking type.
     */
    double getValue(StatType type, String playerId, StatTrackType trackingType);

    /**
     * Adds a player score to the arena statistics. A score is an amount compiled during the
     * running of an arena and whose final result is added here once the arena ends.
     *
     * @param type      The statistic type.
     * @param playerId  The id of the player.
     * @param amount    The players score in the statistic type.
     *
     * @return  The new total statistic value.
     */
    double addScore(StatType type, UUID playerId, double amount);

    /**
     * Get the ids of all players with a statistic type recorded in the arena as a {@code Set} of {@code String}.
     *
     * @param type  The statistic type.
     * @return
     */
    Set<String> getRawPlayerIds(StatType type);
}

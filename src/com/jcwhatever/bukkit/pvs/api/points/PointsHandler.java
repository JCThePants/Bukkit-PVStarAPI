package com.jcwhatever.bukkit.pvs.api.points;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * A points handler that handles incrementing points for
 * players in an arena.
 */
public interface PointsHandler {

    /**
     * Get the owning arena.
     */
    Arena getArena();

    /**
     * Get the points type the handler is for.
     */
    PointsType getPointsType();

    /**
     * Get the number of points a player receives
     * for the points type.
     */
    int getPoints();

    /**
     * Set the number of points a player receives
     * for the points type.
     *
     * @param points  The number of points.
     */
    void setPoints(int points);

}

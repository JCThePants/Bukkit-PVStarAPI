package com.jcwhatever.bukkit.pvs.api.arena.settings;

import com.jcwhatever.bukkit.pvs.api.arena.options.LivesBehavior;
import com.jcwhatever.bukkit.pvs.api.arena.options.OutOfBoundsAction;
import com.jcwhatever.bukkit.pvs.api.arena.options.PointsBehavior;

/**
 * Provides settings for an arenas game manager
 */
public interface GameManagerSettings extends PlayerManagerSettings {

    /**
     * Get action to take when player leaves the arena region.
     */
    OutOfBoundsAction getOutOfBoundsAction();

    /**
     * Set out of bounds action.
     */
    void setOutOfBoundsAction(OutOfBoundsAction action);

    /**
     * Get the number of lives the players
     * start with.
     */
    int getStartLives();

    /**
     * Set the number of lives the players
     * start with.
     */
    void setStartLives(int lives);

    /**
     * Get the number of points players start with.
     */
    int getStartPoints();

    /**
     * Set the number of points players start with.
     */
    void setStartPoints(int points);

    /**
     * Get the behavior of lives when players are
     * forwarded to the arena.
     */
    LivesBehavior getLivesBehavior();

    /**
     * Set the behavior of lives when players are
     * forwarded to the arena.
     */
    void setLivesBehavior(LivesBehavior behavior);

    /**
     * Get the behavior of points when players are
     * forwarded to the arena.
     */
    PointsBehavior getPointsBehavior();

    /**
     * Set the behavior of points when players are
     * forwarded to the arena.
     */
    void setPointsBehavior(PointsBehavior behavior);

    /**
     * Determine if entities such as dropped items
     * should be removed when the game ends.
     */
    boolean hasPostGameEntityCleanup();

    /**
     * Set entities such dropped items removed
     * when the game ends.
     *
     * @param isEnabled  True to remove entities on game end.
     */
    void setPostGameEntityCleanup(boolean isEnabled);
}

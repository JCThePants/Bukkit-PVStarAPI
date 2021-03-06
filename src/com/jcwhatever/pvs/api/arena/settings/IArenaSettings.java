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


package com.jcwhatever.pvs.api.arena.settings;

import com.jcwhatever.pvs.api.arena.options.DropsCleanup;
import org.bukkit.Location;

import javax.annotation.Nullable;

/**
 * Provides settings for an arena.
 */
public interface IArenaSettings {

    /**
     * Determine if the arena is enabled.
     *
     * <p>May return false if the conditions required
     * for an arena to be enabled are not met.</p>
     *
     * <p>This method should be used to determine if
     * the arena is currently enabled.</p>
     */
    boolean isEnabled();

    /**
     * Returns the enabled setting as configured.
     * Used to determine the desired setting.</p>
     *
     * <p>Should not be used to determine if the arena is
     * currently enabled.</p>
     */
    boolean isConfigEnabled();

    /**
     * Set arena enabled.
     *
     * @param isEnabled  True to enable.
     */
    void setEnabled(boolean isEnabled);

    /**
     * Sets the arenas enabled state without changing
     * config settings.
     *
     * @param isEnabled  True to enable.
     */
    void setTransientEnabled(boolean isEnabled);

    /**
     * Determine if the arena is visible to players
     * in arena lists and joinable via commands.
     */
    boolean isVisible();

    /**
     * Set the arenas visibility to players.
     */
    void setVisible(boolean isVisible);

    /**
     * Get a custom type name for display.
     */
    String getTypeDisplayName();

    /**
     * Set a custom type display name for the arena
     *
     * @param typeDisplayName  The new type display name.
     */
    void setTypeDisplayName(@Nullable String typeDisplayName);

    /**
     * Get the minimum players needed to play the arena.
     */
    int getMinPlayers();

    /**
     * Set the minimum players needed to play the arena.
     *
     * @param minPlayers  The number of players.
     */
    void setMinPlayers(int minPlayers);

    /**
     * Get the maximum players allowed in the arena.
     */
    int getMaxPlayers();

    /**
     * Set the maximum players allowed in the arena.
     *
     * @param maxPlayers  The number of players.
     */
    void setMaxPlayers(int maxPlayers);

    /**
     * Determine if natural mob spawns are enabled
     * in the arena.
     */
    boolean isMobSpawnEnabled();

    /**
     * Set flag for natural mob spawns in the arena.
     */
    void setMobSpawnEnabled(boolean isEnabled);

    /**
     * Get the location a player is teleported to when
     * they are removed from the arena region.
     *
     * <p>If the location is not set, the world spawn is returned.</p>
     */
    Location getRemoveLocation();

    /**
     * Set the location a player is teleported to when
     * they are removed from the arena.
     *
     * @param location  The location. Null to use the world spawn location.
     */
    void setRemoveLocation(@Nullable Location location);

    /**
     * Determine how item drops in the arena region are cleaned up.
     */
    DropsCleanup getDropsCleanup();

    /**
     * Set item drops cleanup behaviour.
     *
     * @param cleanup  The cleanup behaviour.
     */
    void setDropsCleanup(DropsCleanup cleanup);
}

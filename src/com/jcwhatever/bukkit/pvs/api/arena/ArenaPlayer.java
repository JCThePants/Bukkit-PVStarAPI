/* This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
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


package com.jcwhatever.bukkit.pvs.api.arena;

import com.jcwhatever.bukkit.generic.mixins.IPlayerWrapper;
import com.jcwhatever.bukkit.pvs.api.arena.managers.PlayerManager;
import com.jcwhatever.bukkit.pvs.api.arena.options.ArenaPlayerRelation;
import com.jcwhatever.bukkit.pvs.api.arena.options.TeamChangeReason;
import com.jcwhatever.bukkit.pvs.api.arena.settings.PlayerManagerSettings;
import org.bukkit.Location;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Wraps the {@code Player} object and carries extra arena related meta data regarding
 * the player.
 */
public interface ArenaPlayer extends IPlayerWrapper {

    /**
     * Get the players unique minecraft Id.
     */
    UUID getUniqueId();

    /**
     * Get the players minecraft name.
     */
    String getName();

    /**
     * Get the players display name. Returns the player name
     * if the player has no display name set.
     */
    String getDisplayName();

    /**
     * Get the players current location.
     */
    Location getLocation();

    /**
     * Get the arena the player is currently in.
     * @return
     */
    @Nullable
    Arena getArena();

    /**
     * Get the players team.
     */
    ArenaTeam getTeam();

    /**
     * Set the players team.
     *
     * @param team  The team to set.
     */
    void setTeam(ArenaTeam team, TeamChangeReason reason);

    /**
     * Get the number of lives the player has left.
     */
    int getLives();

    /**
     * Get the total points earned in the current session.
     */
    int getTotalPoints();

    /**
     * Get the number of points the player has in the current session.
     */
    int getPoints();

    /**
     * Increment player points by the specified amount.
     *
     * @param amount  The amount to increment. Can be negative.
     *
     * @return  The new points value.
     */
    int incrementPoints(int amount);

    /**
     * Get the {@code ArenaPlayerGroup} the player is part of.
     */
    @Nullable
    ArenaPlayerGroup getPlayerGroup();

    /**
     * Determine if the player is ready to play.
     */
    boolean isReady();

    /**
     * Set the player ready variable.
     *
     * @param isReady  True if the player is ready.
     */
    void setReady(boolean isReady);

    /**
     * Determine if the player is immobilized.
     */
    boolean isImmobilized();

    /**
     * Set the players immobilized flag.
     *
     * @param isImmobilized  True to immobilize player.
     */
    void setImmobilized(boolean isImmobilized);

    /**
     * Determine if the player is invulnerable to damage.
     */
    boolean isInvulnerable();

    /**
     * Set the players invulnerability flag.
     *
     * @param isInvulnerable  True to make the player invulnerable to damage.
     */
    void setInvulnerable(boolean isInvulnerable);

    /**
     * Get the players relation to the arena.
     */
    ArenaPlayerRelation getArenaRelation();

    /**
     * Get the manager responsible for the players current arena relation.
     * (i.e. Lobby, Game, Spectator)
     */
    @Nullable
    PlayerManager getRelatedManager();

    /**
     * Get {@code PlayerSettings} implementation from the
     * arena the player is in based on their current arena relation.
     * i.e. If the player is in the lobby, returns the lobby managers
     * settings.
     */
    @Nullable
    PlayerManagerSettings getRelatedSettings();

    /**
     * Get the players meta data object for a specific arena,
     * which is used until the {@code ArenaPlayer} instance is disposed.
     *
     * @param arenaId  The id of the arena.
     */
    PlayerMeta getMeta(UUID arenaId);

    /**
     * Get the players session meta data object,
     * which is used until the player joins another arena.
     */
    PlayerMeta getSessionMeta();

    /**
     * Kill the player
     */
    void kill();

    /**
     * Kill the player and blame the specified arena player.
     *
     * @param blame  The arena player to blame.
     */
    void kill(@Nullable ArenaPlayer blame);

    /**
     * Register the player as being part of
     * the specified arena.
     *
     * <p>Intended for internal use.</p>
     *
     * @param arena  The arena the player is in.
     */
    void setCurrentArena(Arena arena);


    /**
     * Clear all flags related to the players current arena. Effectively
     * updates the player to "Not in an arena" status.
     *
     * <p>Intended for internal use.</p>
     */
    void clearArena();

    /**
     * Set the player group the player is in.
     *
     * <p>Intended for internal use.</p>
     *
     * @param playerGroup  The player group.
     */
    void setPlayerGroup(@Nullable ArenaPlayerGroup playerGroup);

}


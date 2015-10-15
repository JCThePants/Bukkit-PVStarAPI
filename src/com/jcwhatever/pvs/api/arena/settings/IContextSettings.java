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

import com.jcwhatever.nucleus.managed.teleport.TeleportMode;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.pvs.api.arena.mixins.IArenaOwned;

/**
 * Basic settings for player managers.
 * (lobby, game, spectator)
 */
public interface IContextSettings extends IArenaOwned {

    /**
     * Get the data node.
     */
    IDataNode getDataNode();

    /**
     * Determine if pvp is enabled.
     */
    boolean isPvpEnabled();

    /**
     * Set pvp enabled.
     */
    void setPvpEnabled(boolean isEnabled);

    /**
     * Determine if team pvp is enabled.
     */
    boolean isTeamPvpEnabled();

    /**
     * Set team pvp enabled.
     */
    void setTeamPvpEnabled(boolean isEnabled);

    /**
     * Determine if item sharing is enabled.
     */
    boolean isSharingEnabled();

    /**
     * Set item sharing is enabled.
     */
    void setSharingEnabled(boolean isEnabled);

    /**
     * Determine if hunger is enabled.
     */
    boolean isHungerEnabled();

    /**
     * Set hunger enabled.
     */
    void setHungerEnabled(boolean isEnabled);

    /**
     * Determine if player armor is damageable.
     */
    boolean isArmorDamageable();

    /**
     * Set player armor damageable.
     */
    void setArmorDamageable(boolean isDamageable);

    /**
     * Determine if player weapons are damageable.
     */
    boolean isWeaponsDamageable();

    /**
     * Set player weapons damageable.
     */
    void setWeaponsDamageable(boolean isDamageable);

    /**
     * Determine if player tools are damageable.
     */
    boolean isToolsDamageable();

    /**
     * Set tools damageable.
     */
    void setToolsDamageable(boolean isDamageable);

    /**
     * Determine if players have fall damage.
     */
    boolean hasFallDamage();

    /**
     * Set fall damage.
     */
    void setFallDamage(boolean hasFallDamage);

    /**
     * Determine if spawns are reserved after a player uses it.
     */
    boolean isPlayerSpawnsReserved();

    /**
     * Set player spawns reserved for player after first use.
     * (until player removed)
     *
     * @param isEnabled  True to enable spawn reserving.
     */
    void setPlayerSpawnsReserved(boolean isEnabled);

    /**
     * Get the teleport mode used when the player teleports to or within
     * the context.
     */
    TeleportMode getTeleportMode();

    /**
     * Set the teleport mode used when the player teleports to or within
     * the context.
     *
     * @param mode  The teleport mode.
     */
    void setTeleportMode(TeleportMode mode);
}

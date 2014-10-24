package com.jcwhatever.bukkit.pvs.api.arena.settings;

import com.jcwhatever.bukkit.generic.storage.IDataNode;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Basic settings for player managers
 * (lobby, game, spectator)
 */
public interface PlayerManagerSettings {

    /**
     * Get the owning arena.
     */
    Arena getArena();

    /**
     * Get the data node.
     * @return
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

}

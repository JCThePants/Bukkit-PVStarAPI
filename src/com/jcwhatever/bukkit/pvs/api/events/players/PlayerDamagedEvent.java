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


package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.mixins.ICancellable;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.projectiles.ProjectileSource;

import javax.annotation.Nullable;

/**
 * Called when an arena player is damaged.
 */
public class PlayerDamagedEvent extends AbstractPlayerEvent implements ICancellable {

    private EntityDamageEvent _event;
    private Entity _damagerEntity;
    private ArenaPlayer _damagerPlayer;
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player being damaged.
     * @param event   The parent event.
     */
    public PlayerDamagedEvent(Arena arena, ArenaPlayer player, EntityDamageEvent event) {
        super(arena, player);

        _event = event;

        if (event instanceof EntityDamageByEntityEvent) {
            _damagerEntity = ((EntityDamageByEntityEvent) event).getDamager();

            // get arena player
            if (_damagerEntity instanceof Player) {
                _damagerPlayer = PVStarAPI.getArenaPlayer(_damagerEntity);
            }
            // get arena player from projectile source
            else if (_damagerEntity instanceof Projectile) {
                ProjectileSource source = ((Projectile) _damagerEntity).getShooter();

                if (source instanceof Player) {
                    _damagerPlayer = PVStarAPI.getArenaPlayer(source);
                }
            }
        }

    }

    /**
     * Get the arena player who damaged the event player,
     * if applicable.
     */
    @Nullable
    public ArenaPlayer getDamagerPlayer() {
        return _damagerPlayer;
    }

    /**
     * Get the entity that damaged the player,
     * if applicable.
     */
    @Nullable
    public Entity getDamagerEntity() {
        return _damagerEntity;
    }

    /**
     * Get the amount of damage.
     */
    public double getDamage() {
        return _event.getDamage();
    }

    /**
     * Set the amount of damage.
     *
     * @param damage  The damage value.
     */
    public void setDamage(double damage) {
        _event.setDamage(damage);
    }

    /**
     * Get the cause of the damage.
     */
    public DamageCause getCause() {
        return _event.getCause();
    }

    @Override
    public boolean isCancelled() {
        return _isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        _isCancelled = isCancelled;
    }
}

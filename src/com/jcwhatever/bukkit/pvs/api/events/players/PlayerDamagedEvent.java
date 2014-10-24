package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.events.Cancellable;
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
@Cancellable
public class PlayerDamagedEvent extends AbstractPlayerEvent {

    private EntityDamageEvent _event;
    private Entity _damagerEntity;
    private ArenaPlayer _damagerPlayer;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player being damaged.
     * @param event   The parent event.
     */
    public PlayerDamagedEvent(Arena arena, ArenaPlayer player, EntityDamageEvent event) {
        super(arena, player, true);

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
}

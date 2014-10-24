package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Called when a player kills a living entity in an arena.
 */
public class PlayerArenaKillEvent extends AbstractPlayerEvent {

    private final LivingEntity _deadEntity;
    private final ArenaPlayer _deadPlayer;
    private final EntityDeathEvent _event;

    /**
     * Constructor.
     *
     * @param arena       The event arena.
     * @param killer      The player who killed a living entity.
     * @param event       The parent event.
     * @param deadEntity  The living entity that was killed.
     */
    public PlayerArenaKillEvent(Arena arena, ArenaPlayer killer, EntityDeathEvent event, LivingEntity deadEntity) {
        super(arena, killer, false);

        PreCon.notNull(event);
        PreCon.notNull(deadEntity);

        _event = event;
        _deadEntity = deadEntity;

        _deadPlayer = deadEntity instanceof Player
                ? PVStarAPI.getArenaPlayer(deadEntity)
                : null;
    }

    /**
     * Get the living entity that was killed.
     */
    public LivingEntity getDeadEntity() {
        return _deadEntity;
    }

    /**
     * Returns the {@code ArenaPlayer} that was killed,
     * if applicable.
     */
    @Nullable
    public ArenaPlayer getDeadPlayer() {
        return _deadPlayer;
    }

    /**
     * Get the drops of the killed living entity.
     */
    public List<ItemStack> getDrops() {
        return _event.getDrops();
    }

    /**
     * Get the number of exp to be dropped by the
     * killed living entity.
     */
    public int getDroppedExp() {
        return _event.getDroppedExp();
    }

    /**
     * Set the number of exp to be dropped by the
     * killed living entity.
     *
     * @param value  The number of exp.
     */
    public void setDroppedExp(int value) {
        _event.setDroppedExp(value);
    }

    /**
     * Get the parent event.
     */
    public EntityDeathEvent getParentEvent() {
        return _event;
    }
}

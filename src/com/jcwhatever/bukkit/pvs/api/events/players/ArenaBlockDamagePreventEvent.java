package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.generic.events.Cancellable;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Called before a player is prevented from interacting with a block by
 * PV-Star. Cancel the event to allow interaction.
 */
@Cancellable
public class ArenaBlockDamagePreventEvent extends AbstractPlayerEvent {

    private PlayerInteractEvent _event;


    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player prevented from damaging a block.
     * @param event   The parent event.
     */
    public ArenaBlockDamagePreventEvent(Arena arena, ArenaPlayer player, PlayerInteractEvent event) {
        super(arena, player, true);

        PreCon.notNull(event);

        _event = event;
    }

    /**
     * Get the block that is being damaged.
     */
    public Block getBlock() {
        return _event.getClickedBlock();
    }

    /**
     * Get the player action towards the block.
     */
    public Action getAction() {
        return _event.getAction();
    }

    /**
     * Get the item in the player hand used to damage the block.
     */
    public ItemStack getItem() {
        return _event.getItem();
    }

    /**
     * Get the face of the block the player interacted with.
     * @return
     */
    public BlockFace getBlockFace() {
        return _event.getBlockFace();
    }

    /**
     * Get the parent event.
     */
    public PlayerInteractEvent getParentEvent() {
        return _event;
    }
}

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
 * Called when a player in an arena interacts with a block.
 */
@Cancellable
public class PlayerBlockInteractEvent extends AbstractPlayerEvent {

    private PlayerInteractEvent _event;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player interacting.
     * @param event   The parent event.
     */
    public PlayerBlockInteractEvent(Arena arena, ArenaPlayer player, PlayerInteractEvent event) {
        super(arena, player, true);

        PreCon.notNull(event);

        _event = event;
    }

    /**
     * Get the block the player is interacting with.
     */
    public Block getBlock() {
        return _event.getClickedBlock();
    }

    /**
     * Get the action taken by the player on the block.
     */
    public Action getAction() {
        return _event.getAction();
    }

    /**
     * Get the item in the players hand used to interact
     * with the block.
     */
    public ItemStack getItem() {
        return _event.getItem();
    }

    /**
     * Get the face of the block the player is interacting with.
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
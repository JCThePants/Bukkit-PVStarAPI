package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.options.NameMatchMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * Manages arenas.
 */
public interface ArenaManager {

    /**
     * Get the command senders selected arena.
     *
     * @param sender  The command sender.
     */
    @Nullable
    Arena getSelectedArena(CommandSender sender);

    /**
     * Set the command senders selected arena.
     *
     * @param sender  The command sender.
     * @param arena   The arena.
     */
    void setSelectedArena(CommandSender sender, Arena arena);

    /**
     * Change an arenas name.
     *
     * @param arenaId  The id of the arena.
     * @param name     The new arena name.
     */
    boolean setArenaName(UUID arenaId, String name);

    /**
     * Get an arena by id.
     *
     * @param arenaId  The id of the arena.
     */
    @Nullable
    Arena getArena(UUID arenaId);

    /**
     * Get the arena the player is in.
     *
     * @param p  The player to check.
     */
    @Nullable
    Arena getArena(Player p);

    /**
     * Get the arena the location is in.
     *
     * @param location  The location.
     */
    @Nullable
    Arena getArena(Location location);

    /**
     * Get a list of arenas by name and match mode.
     *
     * @param arenaName  The name to search.
     * @param matchMode  The search match mode.
     */
    List<Arena> getArena(String arenaName, NameMatchMode matchMode);

    /**
     * Get a list of all arenas.
     */
    List<Arena> getArenas();

    /**
     * Get the total number of arenas.
     */
    int getArenaCount();

    /**
     * Add an arena.
     *
     * @param arenaName  The name of the arena.
     * @param typeName   The name of the type.
     *
     * @return  Null if failed to create arena.
     */
    @Nullable
    Arena addArena(String arenaName, String typeName);

    /**
     * Remove an arena.
     *
     * @param arenaId  The id of the arena.
     *
     * @return  True if the arena was found and removed.
     */
    boolean removeArena(UUID arenaId);

}

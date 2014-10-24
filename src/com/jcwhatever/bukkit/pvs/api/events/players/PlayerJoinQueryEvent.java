package com.jcwhatever.bukkit.pvs.api.events.players;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Use to check if other modules are willing to allow a player to join an arena
 * without the player actually joining the arena.
 *
 * <p>To prevent a player from joining, handle the {@code PlayerPreAddEvent} instead.</p>
 *
 * <p>Multiple players can be checked at the same time. The players should be rechecked by
 * the calling module in case other modules remove or add players. Adding players to the player
 * collection implies that the players are part of a party.</p>
 */
public class PlayerJoinQueryEvent extends AbstractArenaEvent {

    private Set<ArenaPlayer> _players;

    /**
     * Constructor.
     *
     * @param arena   The event arena.
     * @param player  The player to check.
     */
    public PlayerJoinQueryEvent(Arena arena, ArenaPlayer player) {
        super(arena, false);

        _players = new HashSet<>(5);
        _players.add(player);
    }

    /**
     * Constructor.
     *
     * @param arena    The event arena.
     * @param players  The players to check.
     */
    public PlayerJoinQueryEvent(Arena arena, Collection<ArenaPlayer> players) {
        super(arena, false);

        _players = new HashSet<>(players.size() * 2);
        _players.addAll(players);
    }

    /**
     * Get the players being checked.
     */
    public Set<ArenaPlayer> getPlayers() {
        return _players;
    }
}

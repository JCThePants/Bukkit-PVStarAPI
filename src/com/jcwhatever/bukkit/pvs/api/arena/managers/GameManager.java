package com.jcwhatever.bukkit.pvs.api.arena.managers;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.bukkit.pvs.api.arena.ArenaTeam;
import com.jcwhatever.bukkit.pvs.api.arena.options.ArenaStartReason;
import com.jcwhatever.bukkit.pvs.api.arena.settings.GameManagerSettings;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * Manages an arenas game sessions.
 */
public interface GameManager extends PlayerManager {

    /**
     * Get the start time of the last game.
     */
    @Nullable
    Date getStartTime();

    /**
     * Determine if the arena game is running.
     */
    boolean isRunning();

    /**
     * Determine if the game is over, but the arena is still running.
     * Always returns false if the arena is not running.
     */
    boolean isGameOver();

    /**
     * Get the game manager settings.
     */
    GameManagerSettings getSettings();

    /**
     * Determine if the arena can be started.
     */
    boolean canStart();

    /**
     * Start the game. Transfers the next group of players from the lobby.
     *
     * @param reason  The reason the game is starting.
     *
     * @return  True if the game was started.
     */
    boolean start(ArenaStartReason reason);

    /**
     * End the current game.
     *
     * @return  True if the game was ended.
     */
    boolean end();

    /**
     * Forward a player in the current game to another arena.
     *
     * @param player     The player to forward.
     * @param nextArena  The arena to forward the player to.
     *
     * @return  True if the player was forwarded.
     */
    boolean forwardPlayer(ArenaPlayer player, Arena nextArena);

    /**
     * Set the winner of an arena and end the game.
     *
     * @param player  The winning player.
     *
     * @return  True if the player was set as the winner.
     */
    boolean setWinner(ArenaPlayer player);

    /**
     * Set the specified team as the winner and
     * end the game.
     *
     * @param team  The winning team.
     */
    boolean setWinner(ArenaTeam team);

    /**
     * Set the specified team as the losers of a match and
     * remove all players in the team from the game.
     *
     * @param team  The losing team.
     *
     * @return  True if the team was set as losing.
     */
    boolean setLoser(ArenaTeam team);
}


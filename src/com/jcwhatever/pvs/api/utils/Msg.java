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


package com.jcwhatever.pvs.api.utils;

import com.jcwhatever.nucleus.managed.messaging.ChatPaginator;
import com.jcwhatever.nucleus.managed.messaging.IMessenger;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.nucleus.utils.text.TextUtils;
import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.arena.Arena;
import com.jcwhatever.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.pvs.api.arena.collections.ArenaPlayerCollection;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

/**
 * Player chat and console logging utilities.
 */
public class Msg {

    private Msg() {}

    /**
     * Tell a command sender a message.
     *
     * @param sender   The sender.
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tell(CommandSender sender, String message, Object...params) {
        PreCon.notNull(sender);
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        msg().tell(sender, message, params);
    }

    /**
     * Tell an arena player a message.
     *
     * @param player   The arena player.
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tell(ArenaPlayer player, String message, Object...params) {
        PreCon.notNull(player);
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        msg().tell(player.getPlayer(), message, params);
    }

    /**
     * Tell a collection of arena players a message.
     *
     * @param players  The arena players.
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tell(Collection<ArenaPlayer> players, String message, Object...params) {
        PreCon.notNull(players);
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        String formatted = TextUtils.format(message, params);

        for (ArenaPlayer player : players) {
            msg().tell(player.getPlayer(), formatted);
        }
    }

    /**
     * Tell a command sender a message in error format.
     *
     * @param sender   The sender.
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tellError(CommandSender sender, String message, Object...params) {
        PreCon.notNull(sender);
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        msg().tell(sender, "{RED}" + message, params);
    }

    /**
     * Tell an arena player a message in error format.
     *
     * @param player   The arena player.
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tellError(ArenaPlayer player, String message, Object...params) {
        PreCon.notNull(player);
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        msg().tell(player.getPlayer(), "{RED}" + message, params);
    }

    /**
     * Tell all arena players with a relation to the specified arena a message.
     *
     * @param arena    The arena.
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tellArena(Arena arena, String message, Object... params) {
        PreCon.notNull(arena);
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        ArenaPlayerCollection lobby = arena.getLobbyManager().getPlayers();
        ArenaPlayerCollection spectators = arena.getSpectatorManager().getPlayers();
        ArenaPlayerCollection gamers = arena.getGameManager().getPlayers();

        String formatted = TextUtils.format(message, params);

        for (ArenaPlayer player : lobby)
            tell(player.getPlayer(), formatted);

        for (ArenaPlayer player : spectators)
            tell(player.getPlayer(), formatted);

        for (ArenaPlayer player : gamers)
            tell(player.getPlayer(), formatted);
    }

    /**
     * Broadcast a message to all players who are not in an arena.
     *
     * @param message  The message to tell.
     * @param params   Optional format parameters.
     */
    public static void tellNonArena(String message, Object... params) {
        PreCon.notNullOrEmpty(message);
        PreCon.notNull(params);

        String formatted = TextUtils.format(message, params);

        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for (Player p : players) {

            ArenaPlayer player = PVStarAPI.getArenaPlayer(p);
            if (player.getArena() != null)
                continue;

            tell(p, formatted);
        }
    }

    /**
     * Tell a player an important message that will be stored if the player is not online.
     *
     * @param playerId  The id of the player.
     * @param context   The context of the message.
     * @param message   The message to tell.
     * @param params    Optional format parameters.
     */
    public static void tellImportant(UUID playerId, String context, String message, Object...params) {
    	msg().tellImportant(playerId, context, message, params);
    }

    /**
     * Broadcast a message to all players on the server.
     *
     * @param message  The message to broadcast.
     * @param params   Optional format parameters.
     */
    public static void broadcast(String message, Object...params) {
        msg().broadcast(message, params);

    }

    /**
     * Broadcast a message to all players on the server, excluding
     * the specified players.
     *
     * @param message  The message to broadcast.
     * @param exclude  The player to exclude from the broadcast.
     * @param params   Optional format parameters.
     */
    public static void broadcast(String message, Collection<Player> exclude, Object...params) {
        msg().broadcast(exclude, message, params);
    }

    /**
     * Get a paginator for listing things in chat.
     *
     * @param title   The title of the paginator.
     * @param params  Optional format parameters.
     */
    public static ChatPaginator getPaginator(String title, Object...params) {
        return new ChatPaginator(PVStarAPI.getPlugin(), 6, TextUtils.format(title, params));
    }

    /**
     * Write a debug message to the console and log. Message is
     * disregarded unless debugging is turned on.
     *
     * @param message  The message to write.
     * @param params   Optional format parameters.
     */
    public static void debug(String message, Object...params) {
        if (!PVStarAPI.getPlugin().isDebugging())
            return;

        msg().debug(message, params);
    }

    /**
     * Write an info message to the console and log.
     *
     * @param message  The message to write.
     * @param params   Optional format parameters.
     */
    public static void info(String message, Object...params) {
		msg().info(message, params);
	}

    /**
     * Write a warning message to the console and log.
     *
     * @param message  The message to write.
     * @param params   Optional format parameters.
     */
    public static void warning(String message, Object...params) {
    	msg().warning(message, params);
    }

    /**
     * Write a severe error message to the console and log.
     *
     * @param message  The message to write.
     * @param params   Optional format parameters.
     */
    public static void severe(String message, Object...params) {
    	msg().severe(message, params);
    }

    private static IMessenger msg() {
        return PVStarAPI.getPlugin().getMessenger();
    }
}


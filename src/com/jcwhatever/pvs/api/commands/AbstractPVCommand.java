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


package com.jcwhatever.pvs.api.commands;

import com.jcwhatever.nucleus.commands.AbstractCommand;
import com.jcwhatever.nucleus.commands.arguments.CommandArguments;
import com.jcwhatever.nucleus.commands.exceptions.InvalidArgumentException;
import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.arena.Arena;
import com.jcwhatever.pvs.api.arena.extensions.ArenaExtension;

import org.bukkit.command.CommandSender;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * A base command with PV-Star common utilities included.
 */
public abstract class AbstractPVCommand extends AbstractCommand {

    private CommandHelper _helper = PVStarAPI.getCommandHelper();

    /**
     * Specifies under what conditions an arena can be
     * returned from an arena getter.
     */
    public enum ArenaReturned {
        /**
         * Always return the arena if found.
         */
        ALWAYS,
        /**
         * Return the arena only if it is not running.
         */
        NOT_RUNNNING;

        /**
         * Get the proper {@Code ArenaReturned} constant for commands that can both provide info
         * or change settings.
         *
         * @param args               The command arguments.
         * @param infoParameterName  The name of the parameter that toggles info. Should equal "info" for info.
         *
         * @throws InvalidArgumentException
         */
        public static ArenaReturned getInfoToggled(CommandArguments args, String infoParameterName) throws InvalidArgumentException {
            return args.getString(infoParameterName).equals("info") ? ArenaReturned.ALWAYS : ArenaReturned.NOT_RUNNNING;
        }
    }

    /**
     * Get the command senders currently selected arena.
     *
     * @param sender    The command sender to check and display error messages to.
     * @param returned  Specify return conditions.
     */
    @Nullable
    protected Arena getSelectedArena(CommandSender sender, ArenaReturned returned) {
        return _helper.getSelectedArena(sender, returned);
    }

    /**
     * Get an extension instance from an arena.
     *
     * @param sender  The command sender to display error messages to.
     * @param arena   The arena to get the extension instance from.
     * @param clazz   The extension type.
     *
     * @param <T>  The extension type.
     */
    @Nullable
    protected <T extends ArenaExtension> T getExtension(CommandSender sender, Arena arena, Class<T> clazz) {
        return _helper.getExtension(sender, arena, clazz);
    }

    /**
     * Get an arena by name.
     *
     * @param sender     The command sender to display error messages to.
     * @param arenaName  The name or partial name of the arena to find.
     */
    @Nullable
    protected Arena getArena(CommandSender sender, String arenaName) {
        return _helper.getArena(sender, arenaName);
    }

    /**
     * Get an arena by exact name. (non-case sensitive)
     *
     * @param arenaName  The name of the arena.
     */
    @Nullable
    protected Arena getArena(String arenaName) {
        return _helper.getArena(arenaName);
    }

    /**
     * Get a list of arena ids from a comma delimited string of arena names.
     *
     * @param sender      The command sender to display error messages to.
     * @param arenaNames  The names of the arenas.
     *
     * @return  Null if any arena in the list could not be found.
     */
    @Nullable
    protected List<UUID> getArenaIds(CommandSender sender, String arenaNames) {
        return _helper.getArenaIds(sender, arenaNames);
    }


}

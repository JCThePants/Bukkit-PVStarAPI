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


package com.jcwhatever.bukkit.pvs.api.utils;

import com.jcwhatever.bukkit.generic.converters.ValueConverter;
import com.jcwhatever.bukkit.generic.utils.Utils;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import com.jcwhatever.bukkit.pvs.api.arena.options.NameMatchMode;

import java.util.List;
import java.util.UUID;

public class Converters {

    /**
     * Convert arena name to arena ID
     */
    public static final ValueConverter<UUID, String> ARENA_NAME_ID = new ValueConverter<UUID, String>() {

        @Override
        protected UUID onConvert(Object value) {
            // see if value is already a uuid
            if (value instanceof UUID) {
                Arena arena = PVStarAPI.getArenaManager().getArena((UUID) value);
                if (arena == null)
                    return null;

                return (UUID)value;
            }

            if (value instanceof String) {

                // see if string corresponds to arena name
                List<Arena> matches = PVStarAPI.getArenaManager().getArena((String) value, NameMatchMode.CASE_INSENSITIVE);
                if (matches.size() == 1)
                    return matches.get(0).getId();

                // try converting string to uuid
                return Utils.getId((String) value);
            }

            if (value instanceof Arena) {
                Arena arena = (Arena)value;
                return arena.getId();
            }

            return null;
        }

        @Override
        protected String onUnconvert(Object value) {
            UUID arenaId = onConvert(value);
            if (arenaId == null)
                return null;

            Arena arena = PVStarAPI.getArenaManager().getArena(arenaId);
            if (arena == null)
                return null;

            return arena.getName();
        }

    };

}

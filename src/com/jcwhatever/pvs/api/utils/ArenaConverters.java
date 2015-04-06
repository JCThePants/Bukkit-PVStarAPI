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

import com.jcwhatever.nucleus.utils.converters.Converter;
import com.jcwhatever.nucleus.utils.text.TextUtils;
import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.pvs.api.arena.options.NameMatchMode;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

public class ArenaConverters {

    /**
     * Convert to arena name.
     */
    public static final Converter<String> ARENA_NAME = new Converter<String>() {

        @Override
        protected String onConvert(@Nullable Object value) {

            UUID arenaId = null;

            if (value instanceof String) {

                arenaId = TextUtils.parseUUID((String)value);
                if (arenaId == null) {
                    List<IArena> arenas = PVStarAPI.getArenaManager().getArena(
                            (String) value, NameMatchMode.CASE_INSENSITIVE);

                    return arenas.size() == 1 ? arenas.get(0).getName() : null;
                }
            }

            // see if value is already a uuid
            if (value instanceof UUID) {
                arenaId = (UUID)value;
            }

            if (arenaId == null)
                return null;

            IArena arena = PVStarAPI.getArenaManager().getArena(arenaId);
            if (arena == null)
                return null;

            return arena.getName();
        }
    };

    /**
     * Convert to arena ID.
     */
    public static final Converter<UUID> ARENA_ID = new Converter<UUID>() {

        @Override
        protected UUID onConvert(Object value) {

            // see if value is already a uuid
            if (value instanceof UUID) {

                // verify UUID
                IArena arena = PVStarAPI.getArenaManager().getArena((UUID) value);
                if (arena == null)
                    return null;

                return (UUID)value;
            }

            if (value instanceof String) {

                // see if string corresponds to arena name
                List<IArena> matches = PVStarAPI.getArenaManager().getArena(
                        (String) value, NameMatchMode.CASE_INSENSITIVE);
                if (matches.size() == 1)
                    return matches.get(0).getId();

                // try converting string to uuid
                return TextUtils.parseUUID((String) value);
            }

            if (value instanceof IArena) {
                return ((IArena)value).getId();
            }

            return null;
        }
    };
}

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

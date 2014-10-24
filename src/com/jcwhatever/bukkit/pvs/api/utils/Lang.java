package com.jcwhatever.bukkit.pvs.api.utils;

import com.jcwhatever.bukkit.generic.language.Localized;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;

public class Lang {

    private Lang() {}

    @Localized
    public static String get(String text, Object... params) {
        return PVStarAPI.getLanguageManager().get(PVStarAPI.getPlugin(), text, params);
    }
}

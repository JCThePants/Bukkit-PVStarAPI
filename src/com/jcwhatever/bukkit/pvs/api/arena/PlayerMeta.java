package com.jcwhatever.bukkit.pvs.api.arena;

public interface PlayerMeta {

    void set(Object key, Object data);

    <T> T get(Object key);
}

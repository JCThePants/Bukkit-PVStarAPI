package com.jcwhatever.bukkit.pvs.api.events;

import com.jcwhatever.bukkit.generic.events.AbstractGenericsEvent;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

public abstract class AbstractArenaEvent extends AbstractGenericsEvent {

    private Arena _arena;
    private boolean _isCancellable;
    private boolean _isCancelled;

    public AbstractArenaEvent(Arena arena, boolean isCancellable) {
        PreCon.notNull(arena);

        _arena = arena;
        _isCancellable = isCancellable;
    }

    public final Arena getArena() {
        return _arena;
    }

    @Override
    public boolean isCancellable() {
        return _isCancellable;
    }

    @Override
    public boolean isCancelled() {
        return _isCancellable && _isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        _isCancelled = isCancelled;
    }

}

package com.jcwhatever.bukkit.pvs.api.points;

import com.jcwhatever.bukkit.generic.storage.IDataNode;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a way a player can receive points.
 */
public abstract class PointsType {

    // keyed to arena id
    private Map<UUID, PointsHandler> _handlers = new HashMap<>(25);

    /**
     * The name of the type.
     */
    public abstract String getName();

    /**
     * Type description.
     */
    public abstract String getDescription();

    /**
     * Get the handler used by an arena.
     *
     * @param arena  The arena.
     *
     * @return Null if the arena does not have the points type added..
     */
    @Nullable
    public final PointsHandler getHandler(Arena arena) {
        return _handlers.get(arena.getId());
    }

    /**
     * Add the points type to an arena.
     *
     * @param arena  The arena.
     *
     * @return  True if the handler was added.
     */
    public final boolean add(Arena arena) {
        PreCon.notNull(arena);

        if (_handlers.containsKey(arena.getId()))
            return false;

        IDataNode node = arena.getDataNode("points." + getName());

        PointsHandler handler = getNewHandler(arena, node);

        node.set("enabled", true);
        node.saveAsync(null);

        _handlers.put(arena.getId(), handler);

        return true;
    }

    /**
     * Remove the points type from an arena.
     *
     * @param arena  The arena.
     *
     * @return  True if the handler was found and removed.
     */
    public final boolean remove(Arena arena) {
        PreCon.notNull(arena);

        PointsHandler handler = _handlers.remove(arena.getId());
        if (handler == null)
            return false;

        onRemove(arena, handler);

        IDataNode node = arena.getDataNode("points." + getName());
        node.remove();
        node.saveAsync(null);

        return true;
    }


    /**
     * Provides a new instance of a points handler for the specified
     * arena and using the specified data node.
     *
     * @param arena     The arena.
     * @param dataNode  The data node.
     */
    protected abstract PointsHandler getNewHandler(Arena arena, IDataNode dataNode);

    /**
     * Called when a points handler is removed from an arena.
     *
     * @param arena    The arena.
     * @param handler  The removed handler.
     */
    protected abstract void onRemove(Arena arena, PointsHandler handler);

}

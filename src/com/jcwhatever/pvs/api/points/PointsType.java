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


package com.jcwhatever.pvs.api.points;

import com.jcwhatever.pvs.api.arena.IArena;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.nucleus.utils.PreCon;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;

/**
 * Represents a way a player can receive points.
 */
public abstract class PointsType {

    // keyed to arena id
    private final Map<UUID, IPointsHandler> _handlers = new HashMap<>(25);

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
    public final IPointsHandler getHandler(IArena arena) {
        return _handlers.get(arena.getId());
    }

    /**
     * Add the points type to an arena.
     *
     * @param arena  The arena.
     *
     * @return  True if the handler was added.
     */
    public final boolean add(IArena arena) {
        PreCon.notNull(arena);

        if (_handlers.containsKey(arena.getId()))
            return false;

        IDataNode node = arena.getDataNode("points." + getName());

        IPointsHandler handler = getNewHandler(arena, node);

        node.set("enabled", true);
        node.save();

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
    public final boolean remove(IArena arena) {
        PreCon.notNull(arena);

        IPointsHandler handler = _handlers.remove(arena.getId());
        if (handler == null)
            return false;

        onRemove(arena, handler);

        IDataNode node = arena.getDataNode("points." + getName());
        node.remove();
        node.save();

        return true;
    }


    /**
     * Provides a new instance of a points handler for the specified
     * arena and using the specified data node.
     *
     * @param arena     The arena.
     * @param dataNode  The data node.
     */
    protected abstract IPointsHandler getNewHandler(IArena arena, IDataNode dataNode);

    /**
     * Invoked when a points handler is removed from an arena.
     *
     * @param arena    The arena.
     * @param handler  The removed handler.
     */
    protected abstract void onRemove(IArena arena, IPointsHandler handler);
}

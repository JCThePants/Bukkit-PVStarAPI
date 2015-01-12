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


package com.jcwhatever.bukkit.pvs.api.arena.extensions;

import com.jcwhatever.nucleus.storage.DataStorage;
import com.jcwhatever.nucleus.storage.DataPath;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Base implementation of an Arena extension. Each
 * instance is used for a single arena.
 */
public abstract class ArenaExtension {

    private ArenaExtensionInfo _extensionInfo;
    private Arena _arena;
    private boolean _isInitialized;
    private boolean _isEnabled;
    private IDataNode _dataNode;
    private String _dataNodePath;

    // Initialize module
    final void init(ArenaExtensionInfo info, Arena arena) {
        PreCon.notNull(info);
        PreCon.notNull(arena);

        if (_isInitialized)
            throw new IllegalStateException("An arena module cannot be initialized more than once.");

        _extensionInfo = info;
        _arena = arena;

        _dataNodePath = "arenas." + arena.getId() + ".extensions." + info.name();
        _dataNode = DataStorage.get(PVStarAPI.getPlugin(), new DataPath(_dataNodePath));
        _dataNode.load();

        _isInitialized = true;
    }

    /**
     * Get the arena the module instance
     * was created for.
     */
    public final Arena getArena() {
        return _arena;
    }

    /**
     * Determine if extension is enabled.
     */
    public final boolean isEnabled() {
        return _isEnabled;
    }

    /**
     * Enable the extension.
     */
    public final void enable() {
        if (_isEnabled)
            return;

        _isEnabled = true;
        onEnable();
    }

    /**
     * Disable the extension.
     */
    public final void disable() {
        if (!_isEnabled)
            return;

        _isEnabled = false;
        onDisable();
    }

    /**
     * Dispose of the extension.
     */
    public final void dispose() {
        _isEnabled = false;
        onDispose();
        DataStorage.remove(PVStarAPI.getPlugin(), new DataPath(_dataNodePath));
    }

    /**
     * Determine if the module has finished
     * initializing.
     */
    public final boolean isInitialized() {
        return _isInitialized;
    }

    /**
     * Get the modules data storage node.
     */
    public final IDataNode getDataNode() {
        return _dataNode;
    }

    /**
     * Get the name of the module.
     */
    public final String getName() {
        return _extensionInfo.name();
    }

    /**
     * Get the description of the module.
     */
    public final String getDescription() {
        return _extensionInfo.description();
    }

    /**
     * Called when the extension is enabled.
     */
    protected abstract void onEnable();

    /**
     * Called when the extension is disabled.
     */
    protected abstract void onDisable();

    /**
     * Called when the extension is disposed.
     */
    protected void onDispose() {}
}


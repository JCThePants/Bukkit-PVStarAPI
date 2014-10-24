package com.jcwhatever.bukkit.pvs.api.arena.extensions;

import com.jcwhatever.bukkit.generic.storage.DataStorage;
import com.jcwhatever.bukkit.generic.storage.DataStorage.DataPath;
import com.jcwhatever.bukkit.generic.storage.IDataNode;
import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * Arena extension.
 * Each instance is used for a single arena.
 *
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
        _dataNode = DataStorage.getStorage(PVStarAPI.getPlugin(), new DataPath(_dataNodePath));
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
        DataStorage.removeStorage(PVStarAPI.getPlugin(), new DataPath(_dataNodePath));
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


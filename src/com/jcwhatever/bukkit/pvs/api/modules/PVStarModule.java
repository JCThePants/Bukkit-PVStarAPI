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


package com.jcwhatever.bukkit.pvs.api.modules;

import com.jcwhatever.nucleus.language.LanguageManager;
import com.jcwhatever.nucleus.mixins.IDisposable;
import com.jcwhatever.nucleus.storage.DataStorage;
import com.jcwhatever.nucleus.storage.DataPath;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PVStar module abstract class.
 *
 * <p>PV star modules must extend this class in order to be recognized.</p>
 */
public abstract class PVStarModule implements IDisposable {

    private final LanguageManager _languageManager = new LanguageManager(PVStarAPI.getPlugin(), this);
    private final Map<String, IDataNode> _customNodes = new HashMap<>(10);
    private ModuleInfo _moduleInfo;
    private IDataNode _dataNode;
    private boolean _isPreEnabled;
    private boolean _isEnabled;
    private boolean _isDisposed;

    /**
     * Get the name of the module.
     */
    public final String getName() {
        return getInfo().getName();
    }

    /**
     * Get the module display version.
     */
    public final String getVersion() {
        return getInfo().getVersion();
    }

    /**
     * Get the module description.
     */
    public final String getDescription() {
        return getInfo().getDescription();
    }

    /**
     * Get the modules author names.
     */
    public final List<String> getAuthors() {
        return getInfo().getAuthors();
    }

    /**
     * Get the logical version of the module.
     */
    public final long getLogicalVersion() {
        return getInfo().getLogicalVersion();
    }

    /**
     * Get the names of required Bukkit dependencies.
     */
    public final Set<String> getBukkitDepends() {
        return getInfo().getBukkitDepends();
    }

    /**
     * Get the names of optional Bukkit dependencies.
     */
    public final Set<String> getBukkitSoftDepends() {
        return getInfo().getBukkitSoftDepends();
    }

    /**
     * Get the names of required PV-Star module dependencies.
     */
    public Set<String> getModuleDepends() {
        return getInfo().getModuleDepends();
    }

    /**
     * Get the names of optional PV-Star module dependencies.
     * @return
     */
    public Set<String> getModuleSoftDepends() {
        return getInfo().getModuleSoftDepends();
    }

    /**
     * Determine if the module has been pre-enabled.
     */
    public final boolean isPreEnabled() {
        return _isPreEnabled;
    }

    /**
     * Determine if the module is enabled.
     */
    public final boolean isEnabled() {
        return _isEnabled;
    }

    /**
     * Determine if the module has been disposed.
     */
    @Override
    public final boolean isDisposed() {
        return _isDisposed;
    }

    /**
     * Internal Use Only. Called before the module is enabled.
     */
    public final void preEnable() {

        if (_isPreEnabled)
            throw new RuntimeException(
                    "Module named " + getName() + " is already pre-enabled. " +
                    " Please note that the preEnable() method is reserved for internal use only.");

        if (_isDisposed)
            throw new RuntimeException(
                    "Module named " + getName() + " is disposed and cannot be pre-enabled. " +
                            " Please note that the preEnable() method is reserved for internal use only.");

        _isPreEnabled = true;

        onRegisterTypes();
    }

    /**
     * Internal Use only. Called to enable the module.
     */
    public final void enable () {

        if (_isEnabled)
            throw new RuntimeException(
                    "Module named " + getName() + " is already enabled. " +
                            " Please note that the enable() method is reserved for internal use only.");

        if (_isDisposed)
            throw new RuntimeException(
                    "Module named " + getName() + " is disposed and cannot be enabled. " +
                            " Please note that the enable() method is reserved for internal use only.");

        _isEnabled = true;

        onEnable();
    }

    /**
     * Internal Use Only. Called to dispose resources used by the module before it
     * is discarded.
     */
    @Override
    public final void dispose() {

        if (_isDisposed)
            return;

        _isDisposed = true;

        onDispose();
    }

    /**
     * Get the modules language manager.
     */
    public final LanguageManager getLanguageManager() {
        return _languageManager;
    }

    /**
     * Get the modules data node.
     * @return
     */
    public final IDataNode getDataNode() {
        if (_dataNode == null) {
            _dataNode = DataStorage.get(PVStarAPI.getPlugin(), new DataPath("modules." + getName() + ".config"));
            _dataNode.load();
        }

        return _dataNode;
    }

    /**
     * Get a data storage node.
     *
     * @param path  The relative data path of the node.
     */
    public final IDataNode getDataNode(String path) {
        PreCon.notNullOrEmpty(path);

        String key = path.toLowerCase();

        IDataNode node = _customNodes.get(key);
        if (node != null)
            return node;

        DataPath dataPath = new DataPath("modules." + getName()).getPath(path);
        node = DataStorage.get(PVStarAPI.getPlugin(), dataPath);
        node.load();

        _customNodes.put(key, node);

        return node;
    }

    /**
     * Called during pre-enable. Types should be registered here.
     */
    protected abstract void onRegisterTypes();

    /**
     * Called when the module is enabled.
     */
    protected abstract void onEnable();

    /**
     * Called when the module is disposed.
     */
    protected void onDispose() {}


    // get module info
    private ModuleInfo getInfo() {
        if (_moduleInfo == null)
            _moduleInfo = PVStarAPI.getPlugin().getModuleInfo(this);

        return _moduleInfo;
    }

}

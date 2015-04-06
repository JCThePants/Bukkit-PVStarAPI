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


package com.jcwhatever.pvs.api.modules;

import com.jcwhatever.nucleus.Nucleus;
import com.jcwhatever.nucleus.managed.language.ILanguageContext;
import com.jcwhatever.nucleus.providers.storage.DataStorage;
import com.jcwhatever.nucleus.storage.DataPath;
import com.jcwhatever.nucleus.storage.IDataNode;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.pvs.api.PVStarAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PVStar module abstract class.
 *
 * <p>PV star modules must extend this class in order to be recognized.</p>
 */
public abstract class PVStarModule {

    private final ILanguageContext _languageContext =
            Nucleus.getLanguageManager().createContext(PVStarAPI.getPlugin(), this);

    private final Map<String, IDataNode> _customNodes = new HashMap<>(10);

    private PVStarModuleRegistration _registration;
    private IModuleInfo _moduleInfo;
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
    public final boolean isDisposed() {
        return _isDisposed;
    }

    /**
     * Get the modules language context.
     */
    public final ILanguageContext getLanguageContext() {
        return _languageContext;
    }

    /**
     * Get the modules data node.
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
     * Register the module.
     *
     * <p>For internal implementation use.</p>
     *
     * @param registration  The registration.
     */
    public final void register(PVStarModuleRegistration registration) {
        PreCon.notNull(registration);

        if (_registration != null)
            throw new IllegalStateException("PVStar module can only be registered once.");

        _registration = registration;
    }

    /**
     * Invoked during pre-enable.
     *
     * <p>Types should be registered here.</p>
     */
    protected abstract void onRegisterTypes();

    /**
     * Invoked when the module is enabled.
     */
    protected abstract void onEnable();

    /**
     * Invoked when the module is disposed.
     *
     * <p>Intended for optional override.</p>
     */
    protected void onDispose() {}

    // get module info
    private IModuleInfo getInfo() {
        if (_moduleInfo == null)
            _moduleInfo = PVStarAPI.getPlugin().getModuleInfo(this);

        return _moduleInfo;
    }

    /**
     * Registration to allow internal implementation to access protected methods.
     */
    public static class PVStarModuleRegistration {

        /**
         * Invoke before the module is enabled.
         *
         * @param module  The module to pre-enable.
         */
        public void preEnable(PVStarModule module) {
            PreCon.notNull(module);
            PreCon.isValid(module._registration == this, "Invalid registration.");

            if (module._isPreEnabled) {
                throw new IllegalStateException(
                        "The module named " + module.getName() + " is already pre-enabled. ");
            }

            if (module._isDisposed) {
                throw new IllegalStateException(
                        "The module named " + module.getName() + " is disposed and cannot be pre-enabled. ");
            }

            module._isPreEnabled = true;

            module.onRegisterTypes();
        }

        /**
         * Invoke to enable the module.
         *
         * @param module  The module to enable.
         */
        public final void enable (PVStarModule module) {
            PreCon.notNull(module);
            PreCon.isValid(module._registration == this, "Invalid registration.");

            if (module._isEnabled) {
                throw new IllegalStateException("The module named " + module.getName() + " is already enabled.");
            }

            if (module._isDisposed) {
                throw new IllegalStateException("The module named " + module.getName() +
                        " is disposed and cannot be enabled.");
            }

            module._isEnabled = true;
            module.onEnable();
        }

        /**
         * Invoked to dispose resources used by the module before it is discarded.
         */
        public final void dispose(PVStarModule module) {

            if (module._isDisposed)
                throw new IllegalStateException("The module named " + module.getName() + " is already disposed.");

            module._isDisposed = true;

            module.onDispose();
        }
    }
}

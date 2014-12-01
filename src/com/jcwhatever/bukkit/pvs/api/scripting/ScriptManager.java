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


package com.jcwhatever.bukkit.pvs.api.scripting;

import com.jcwhatever.bukkit.generic.scripting.api.IScriptApi;

import java.util.List;
import javax.annotation.Nullable;
import javax.script.ScriptEngineManager;

/**
 * Manages unevaluated scripts which can
 * be added to arenas via their {@code ArenaScriptManager}.
 */
public interface ScriptManager {

    /**
     * Get the script engine manager that provides script engines.
     */
    ScriptEngineManager getEngineManager();

    /**
     * Add a script.
     *
     * @param script  The script to add.
     *
     * @return  True if the script was added.
     */
    boolean addScript(Script script);

    /**
     * Remove a script.
     *
     * @param scriptName  The name of the script to remove.
     *
     * @return  True if the script was found and removed.
     */
    boolean removeScript(String scriptName);

    /**
     * Register an api type to be included with all
     * evaluated scripts.
     *
     * @param api  The api
     */
    void registerApiType(IScriptApi api);

    /**
     * Get a script api by variable name.
     *
     * @param apiVariableName  The variable name used by the script api
     */
    @Nullable
    IScriptApi getScriptApi(String apiVariableName);

    /**
     * Get all script api.
     * @return
     */
    List<IScriptApi> getScriptApis();

    /**
     * Get a script by name.
     *
     * @param scriptName  The name of the script. (the relative path using dots instead of dashes)
     */
    @Nullable
    Script getScript(String scriptName);

    /**
     * Get the names of all scripts.
     */
    List<String> getScriptNames();

    /**
     * Get all scripts.
     */
    List<Script> getScripts();

    /**
     * Reload scripts.
     */
    void reload();
}

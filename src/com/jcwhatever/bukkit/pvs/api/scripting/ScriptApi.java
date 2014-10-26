/* This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
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

import com.jcwhatever.bukkit.generic.scripting.IEvaluatedScript;
import com.jcwhatever.bukkit.generic.scripting.api.IScriptApi;
import com.jcwhatever.bukkit.generic.scripting.api.IScriptApiObject;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;
import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * An api to be included with an evaluated script.
 */
public abstract class ScriptApi implements IScriptApi {

    private Map<Arena, IScriptApiObject> _apiObjects = new WeakHashMap<>(30);

    /**
     * Get the owning plugin.
     */
    @Override
    public final Plugin getPlugin() {
        return PVStarAPI.getPlugin();
    }

    /**
     * Reset the api and release all objects stored from
     * the script.
     */
    @Override
    public final void reset() {

        onReset();

        for (IScriptApiObject api : _apiObjects.values()) {
            api.reset();
        }

        _apiObjects.clear();
    }

    /**
     * Get an API object to be used by an evaluated script.
     *
     * @param script  The evaluated script.
     */
    @Override
    public final IScriptApiObject getApiObject(IEvaluatedScript script) {

        if (script instanceof EvaluatedScript) {
            EvaluatedScript evaluatedScript = (EvaluatedScript)script;
            Arena arena = evaluatedScript.getArena();

            IScriptApiObject api = _apiObjects.get(arena);

            if (api == null) {

                api = onCreateApiObject(arena, evaluatedScript);
                if (api == null)
                    throw new RuntimeException("Api object expected.");

                _apiObjects.put(arena, api);
            }

            return api;
        }

        throw new RuntimeException("Instance of com.jcwhatever.bukkit.pvs.api.scripting.EvaluatedScript expected.");
    }

    /**
     * Called when the api is reset.
     */
    protected void onReset() {}

    /**
     * Called when a new api object is needed.
     *
     * @param arena   The arena the api object is for.
     * @param script  The evaluated script the api object is for.
     */
    protected abstract IScriptApiObject onCreateApiObject(Arena arena, EvaluatedScript script);
}

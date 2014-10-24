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

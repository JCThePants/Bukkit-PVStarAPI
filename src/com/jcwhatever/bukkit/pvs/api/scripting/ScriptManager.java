package com.jcwhatever.bukkit.pvs.api.scripting;

import com.jcwhatever.bukkit.generic.scripting.api.IScriptApi;
import com.jcwhatever.bukkit.pvs.api.events.AbstractArenaEvent;
import com.jcwhatever.bukkit.pvs.api.modules.PVStarModule;

import javax.annotation.Nullable;
import javax.script.ScriptEngineManager;
import java.util.List;

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
     * Register an arena event class to make it available to scripts.
     *
     * @param eventClass  The owning module.
     * @param eventClass  The event class to register.
     */
    void registerEventType(PVStarModule module, Class<? extends AbstractArenaEvent> eventClass);

    /**
     * Add a script.
     *
     * @param script  The script to add.
     */
    void addScript(Script script);

    /**
     * Remove a script.
     *
     * @param scriptName  The name of the script to remove.
     */
    void removeScript(String scriptName);

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

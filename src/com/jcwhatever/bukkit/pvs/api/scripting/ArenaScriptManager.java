package com.jcwhatever.bukkit.pvs.api.scripting;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * Manages scripts added to the arena.
 */
public interface ArenaScriptManager {

    /**
     * Get the owning arena.
     */
    Arena getArena();

    /**
     * Add a script to the arena.
     *
     * @param script  The script to add.
     *
     * @return  True if the script was added.
     */
    boolean addScript(Script script);

    /**
     * Add a collection of scripts to the arena.
     *
     * @param scripts  The scripts to add.
     *
     * @return  True if the scripts were added.
     */
    boolean addScripts(Collection<Script> scripts);

    /**
     * Remove a script from the arena.
     *
     * @param script  The script to remove.
     *
     * @return  True if the script was removed.
     */
    boolean removeScript(Script script);

    /**
     * Remove a script from the arena.
     *
     * @param scriptName  The name of the script.
     *
     * @return  True if the script was removed.
     */
    boolean removeScript(String scriptName);

    /**
     * Remove a collection of scripts from the arena.
     *
     * @param scripts  The scripts to remove.
     *
     * @return  True if the scripts were removed.
     */
    boolean removeScripts(Collection<Script> scripts);

    /**
     * Get a script by name
     *
     * @param scriptName  The name of the script. (the relative path using dots instead of dashes)
     */
    @Nullable
    EvaluatedScript getEvaluatedScript(String scriptName);

    /**
     * Get the names of all loaded scripts.
     */
    List<String> getScriptNames();

    /**
     * Get all scripts.
     */
    List<EvaluatedScript> getEvaluatedScripts();

    /**
     * Reload all scripts in the arena.
     */
    void reload();

}

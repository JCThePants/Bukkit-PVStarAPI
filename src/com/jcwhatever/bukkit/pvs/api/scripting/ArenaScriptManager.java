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

package com.jcwhatever.bukkit.pvs.api.scripting;

import com.jcwhatever.bukkit.generic.scripting.IScript;
import com.jcwhatever.bukkit.generic.scripting.api.IScriptApi;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * An unevaluated script which can be used to
 * create evaluated script instances.
 */
public interface Script extends IScript {

    /**
     * Evaluate the script.
     *
     * @param arena          The arena to evaluate the script for.
     * @param apiCollection  The api collection to include.
     *
     * @return  The evaluated script.
     */
    EvaluatedScript evaluate(Arena arena, @Nullable Collection<? extends IScriptApi> apiCollection);

}

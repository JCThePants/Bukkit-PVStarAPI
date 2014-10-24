package com.jcwhatever.bukkit.pvs.api.scripting;

import com.jcwhatever.bukkit.generic.scripting.IEvaluatedScript;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

/**
 * A script that has been evaluated.
 */
public interface EvaluatedScript extends IEvaluatedScript {

    /**
     * Get the owning arena.
     */
    Arena getArena();
}

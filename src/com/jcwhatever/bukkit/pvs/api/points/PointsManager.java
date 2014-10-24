package com.jcwhatever.bukkit.pvs.api.points;

import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Manages points types.
 */
public interface PointsManager {

    /**
     * Register a points type.
     *
     * @param type  The type to register.
     *
     * @return  True if the type was registered.
     */
    boolean registerType(PointsType type);

    /**
     * Get all registered points types.
     */
    List<PointsType> getTypes();

    /**
     * Get points types added to the specified arena.
     *
     * @param arena  The arena.
     */
    List<PointsType> getTypes(Arena arena);

    /**
     * Get a points type by name.
     *
     * @param typeName  The name of the type.
     */
    @Nullable
    PointsType getType(String typeName);


    /**
     * Load types for an arena from config.
     * For arena manager use.
     *
     * @param arena  The arena.
     */
    void loadTypes(Arena arena);


}

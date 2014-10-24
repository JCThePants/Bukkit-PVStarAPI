package com.jcwhatever.bukkit.pvs.api.arena.extensions;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

/**
 * Manages extension types that are available to
 * use on arenas.
 */
public interface ExtensionTypeManager {

    /**
     * Get the names of all available extensions
     */
    Set<String> getExensionNames();

    /**
     * Get all available extension types.
     */
    List<Class<? extends ArenaExtension>> getExtensionClasses();

    /**
     * Get an extension type by name.
     *
     * @param name  The name of the extension
     */
    @Nullable
    Class<? extends ArenaExtension> getExtensionClass(String name);

    /**
     * Register an extension.
     *
     * @param extension  The extension to register.
     */
    void registerType(Class<? extends ArenaExtension> extension);

}

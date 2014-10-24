package com.jcwhatever.bukkit.pvs.api.arena.extensions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Arena extension info annotation.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ArenaExtensionInfo {

    /**
     * The name of the extension.
     */
    String name();

    /**
     * The extension description.
     */
    String description();
}

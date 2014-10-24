package com.jcwhatever.bukkit.pvs.api.exceptions;

import com.jcwhatever.bukkit.pvs.api.arena.extensions.ArenaExtension;

/**
 * Thrown when an arena extension type is missing its required
 * {@code ArenaExtensionInfo} annotation.
 */
public class MissingExtensionAnnotationException extends RuntimeException {

    String _msg;

    /**
     * Constructor.
     *
     * @param extClass  The extension type that is missing required annotation.
     */
    public MissingExtensionAnnotationException(Class<? extends ArenaExtension> extClass) {
        _msg = "An arena extension is missing its ArenaExtensionInfo annotation: " + extClass.getName();
    }

    /**
     * Get the exception message.
     */
    @Override
    public String getMessage() {
        return _msg;
    }
}

package com.jcwhatever.bukkit.pvs.api.arena.options;

/**
 * Describes how a name should be searched.
 */
public enum NameMatchMode {
    /**
     * A name must be an exact match, case-sensitive.
     */
    CASE_SENSITIVE,
    /**
     * A name must be an exact match, case-insensitive.
     */
    CASE_INSENSITIVE,
    /**
     * A name must begin with the search pattern.
     */
    BEGINS_WITH,
    /**
     * A name must contain the search pattern.
     */
    SEARCH
}

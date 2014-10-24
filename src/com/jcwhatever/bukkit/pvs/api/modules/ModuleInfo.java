package com.jcwhatever.bukkit.pvs.api.modules;

import java.util.Set;

/**
 * Module info container
 */
public interface ModuleInfo {

    /**
     * Get the name of the module.
     */
    String getName();

    /**
     * Get the name of the module in lowercase.
     */
    String getSearchName();

    /**
     * Get the module display version.
     */
    String getVersion();

    /**
     * Get the module description.
     */
    String getDescription();

    /**
     * Get the logical version of the module.
     */
    long getLogicalVersion();

    /**
     * Get the names of required Bukkit dependencies.
     */
    Set<String> getBukkitDepends();

    /**
     * Get the names of optional Bukkit dependencies.
     */
    Set<String> getBukkitSoftDepends();

    /**
     * Get the names of required PV-Star module dependencies.
     */
    Set<String> getModuleDepends();

    /**
     * Get the names of optional PV-Star module dependencies.
     */
    Set<String> getModuleSoftDepends();

}

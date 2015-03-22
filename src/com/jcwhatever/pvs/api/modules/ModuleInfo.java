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


package com.jcwhatever.pvs.api.modules;

import java.util.List;
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
     * Get the modules author names.
     */
    List<String> getAuthors();

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

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


package com.jcwhatever.pvs.api.arena.extensions;

import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Manages extension types that are available to use on arenas.
 */
public interface IExtensionTypeManager {

    /**
     * Get the names of all available extensions
     */
    Set<String> getExtensionNames();

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

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

import com.jcwhatever.pvs.api.arena.IArena;

import java.util.Set;
import javax.annotation.Nullable;

/**
 *  Manages extension instances for a specific arena instance.
 */
public interface IArenaExtensionManager {

    /**
     * Get the owning arena.
     */
    IArena getArena();

    /**
     * Determine if the arena has an extension.
     *
     * @param typeName  The name of the extension.
     */
    boolean has(String typeName);

    /**
     * Determine if the arena has an extension.
     *
     * @param clazz  The extension type.
     */
    boolean has(Class<? extends ArenaExtension> clazz);

    /**
     * Get all arena extension instances.
     */
    Set<ArenaExtension> getAll();

    /**
     * Get an arena extension instance.
     *
     * @param name  The name of the instance.
     */
    @Nullable
    ArenaExtension get(String name);

    /**
     * Get an arena extension instance.
     *
     * @param clazz  The extension type.
     * @param <T>    The extension type.
     */
    @Nullable
    <T extends ArenaExtension> T get(Class<T> clazz);

    /**
     * Add an extension to the arena.
     *
     * @param name  The name of the extension type.
     * @param <T>   The extension type.
     *
     * @return  The extension instance.
     */
    @Nullable
    <T extends ArenaExtension> T add(String name);

    /**
     * Remove an arena extension.
     *
     * @param clazz  The extension type.
     */
    boolean remove(Class<? extends ArenaExtension> clazz);

    /**
     * Remove an arena extension.
     *
     * @param name  The name of the extension type.
     */
    boolean remove(String name);
}


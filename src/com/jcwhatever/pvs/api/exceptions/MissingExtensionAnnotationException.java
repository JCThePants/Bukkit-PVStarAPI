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


package com.jcwhatever.pvs.api.exceptions;

import com.jcwhatever.pvs.api.arena.extensions.ArenaExtension;

/**
 * Thrown when an arena extension type is missing its required
 * {@link com.jcwhatever.pvs.api.arena.extensions.ArenaExtensionInfo} annotation.
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

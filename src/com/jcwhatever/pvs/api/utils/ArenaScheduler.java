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


package com.jcwhatever.pvs.api.utils;

import com.jcwhatever.pvs.api.PVStarAPI;
import com.jcwhatever.pvs.api.arena.Arena;
import com.jcwhatever.nucleus.Nucleus;
import com.jcwhatever.nucleus.utils.PreCon;
import com.jcwhatever.nucleus.managed.scheduler.IScheduledTask;
import com.jcwhatever.nucleus.managed.scheduler.TaskHandler;

import java.util.Date;

/**
 * Schedule tasks that are guaranteed not to run if the arena is not running.
 *
 * <p>Delayed Tasks added while the arena is not running will still run.</p>
 *
 * <p>Repeating Tasks do not run unless the arena is running.</p>
 */
public class ArenaScheduler {

    private ArenaScheduler() {}

    /**
     * Run a task later. Task will run if arena is not running but will be cancelled
     * when the arena ends.
     *
     * @param arena       The arena the task is for
     * @param delayTicks  Delay in ticks before executing the task
     * @param runnable    The task to run
     */
    public static IScheduledTask runTaskLater(Arena arena, int delayTicks, Runnable runnable) {
         return Nucleus.getScheduler()
                 .runTaskLater(PVStarAPI.getPlugin(), delayTicks, wrapRunnable(arena, runnable, false));
    }

    /**
     * Run a task at first available chance. Task will run if arena is not running but will be cancelled
     * when the arena ends.
     *
     * @param arena     The arena the task is for
     * @param runnable  The task to run
     */
    public static IScheduledTask runTaskLater(Arena arena, Runnable runnable) {
        return Nucleus.getScheduler()
                .runTaskLater(PVStarAPI.getPlugin(), wrapRunnable(arena, runnable, false));
    }

    /**
     * Repeat a task at interval. Task will NOT run unless the arena is running. Task
     * is cancelled when the arena ends.
     *
     * @param arena         The arena the task is for
     * @param initialDelay  The initial delay in ticks before running the first task
     * @param interval      The delay in ticks between tasks
     * @param runnable      The task to run
     */
    public static IScheduledTask runTaskRepeat(Arena arena, int initialDelay, int interval, Runnable runnable) {
        PreCon.notNull(arena);
        PreCon.notNull(runnable);
        PreCon.positiveNumber(initialDelay);
        PreCon.positiveNumber(interval);

        return Nucleus.getScheduler()
                .runTaskRepeat(PVStarAPI.getPlugin(), initialDelay, interval, wrapRunnable(arena, runnable, true));
    }

    private static Runnable wrapRunnable(final Arena arena, final Runnable runnable, boolean isRepeating) {

        if (!isRepeating)
            return runnable;

        return new TaskHandler(runnable instanceof TaskHandler ? (TaskHandler)runnable : null) {

            private Date _sessionToken;

            @Override
            public void run() {

                IScheduledTask task = getTask();

                if (_sessionToken == null)
                    _sessionToken = arena.getGameManager().getStartTime();

                if (task != null) {
                    if (!arena.getGameManager().isRunning() ||
                            _sessionToken != arena.getGameManager().getStartTime()) {
                        cancelTask();
                        return;
                    }
                }

                runnable.run();
            }
        };
    }
}


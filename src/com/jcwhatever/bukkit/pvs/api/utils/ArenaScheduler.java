package com.jcwhatever.bukkit.pvs.api.utils;

import com.jcwhatever.bukkit.generic.utils.PreCon;
import com.jcwhatever.bukkit.generic.utils.Scheduler;
import com.jcwhatever.bukkit.generic.utils.Scheduler.ScheduledTask;
import com.jcwhatever.bukkit.generic.utils.Scheduler.TaskHandler;
import com.jcwhatever.bukkit.pvs.api.PVStarAPI;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import java.util.Date;

/**
 * Schedule tasks that are guaranteed not to run if the arena is not running.
 *
 * <p>Delayed Tasks added while the arena is not running will still run.</p>
 *
 * <p>Repeating Tasks do not run unless the arena is running.</p>
 *
 * @author JC The Pants
 *
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
    public static ScheduledTask runTaskLater(Arena arena, int delayTicks, Runnable runnable) {
         return Scheduler.runTaskLater(PVStarAPI.getPlugin(), delayTicks, wrapRunnable(arena, runnable, false));
    }

    /**
     * Run a task at first available chance. Task will run if arena is not running but will be cancelled
     * when the arena ends.
     *
     * @param arena     The arena the task is for
     * @param runnable  The task to run
     */
    public static ScheduledTask runTaskLater(Arena arena, Runnable runnable) {
        return Scheduler.runTaskLater(PVStarAPI.getPlugin(), wrapRunnable(arena, runnable, false));
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
    public static ScheduledTask runTaskRepeat(Arena arena, int initialDelay, int interval, Runnable runnable) {
        PreCon.notNull(arena);
        PreCon.notNull(runnable);
        PreCon.positiveNumber(initialDelay);
        PreCon.positiveNumber(interval);

        ScheduledTask task = Scheduler.runTaskRepeat(PVStarAPI.getPlugin(), initialDelay, interval, wrapRunnable(arena, runnable, true));

        if (!arena.getGameManager().isRunning())
            task.cancel();

        return task;
    }

    private static Runnable wrapRunnable(final Arena arena, final Runnable runnable, boolean isRepeating) {

        if (!isRepeating)
            return runnable;

        final Date sessionToken = arena.getGameManager().getStartTime();

        return new TaskHandler(runnable instanceof TaskHandler ? (TaskHandler)runnable : null) {

            @Override
            public void run() {

                ScheduledTask task = getTask();

                if (task != null) {
                    if (!arena.getGameManager().isRunning() ||
                            sessionToken != arena.getGameManager().getStartTime()) {
                        cancelTask();
                        return;
                    }
                }

                runnable.run();
            }
        };
    }

}


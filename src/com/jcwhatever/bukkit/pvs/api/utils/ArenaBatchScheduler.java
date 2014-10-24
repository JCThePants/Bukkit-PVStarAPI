package com.jcwhatever.bukkit.pvs.api.utils;

import com.jcwhatever.bukkit.generic.utils.Scheduler.ScheduledTask;
import com.jcwhatever.bukkit.pvs.api.arena.Arena;

import java.util.LinkedList;

/**
 * Schedules arena tasks that can all be cancelled at the same time.
 */
public class ArenaBatchScheduler {

    private Arena _arena;
    private LinkedList<ScheduledTask> _tasks = new LinkedList<ScheduledTask>();

    public ArenaBatchScheduler(Arena arena) {
        _arena = arena;
    }

    public void cancelAll() {
        while (!_tasks.isEmpty()) {
            _tasks.remove().cancel();
        }
    }

    /**
     * Run a task later. Task will run if arena is not running but will be cancelled
     * when the arena ends.
     *
     * @param runnable    The task to run
     * @param delayTicks  Delay in ticks before executing the task
     * @return
     */
    public ScheduledTask runTaskLater(Runnable runnable, int delayTicks) {
        ScheduledTask task = ArenaScheduler.runTaskLater(_arena, delayTicks, runnable);

        _tasks.add(task);

        return task;
    }

    /**
     * Run a task at first available chance. Task will run if arena is not running but will be cancelled
     * when the arena ends.
     *
     * @param runnable  The task to run
     * @return
     */
    public ScheduledTask runTaskLater(Runnable runnable) {
        ScheduledTask task = ArenaScheduler.runTaskLater(_arena, runnable);

        _tasks.add(task);

        return task;
    }

    /**
     * Repeat a task at interval. Task will NOT run unless the arena is running. Task
     * is cancelled when the arena ends.
     *
     * @param initialDelay  The initial delay in ticks before running the first task
     * @param interval      The delay in ticks between tasks
     * @param runnable      The task to run
     */
    public ScheduledTask runTaskRepeat(int initialDelay, int interval, Runnable runnable) {

        ScheduledTask task = ArenaScheduler.runTaskRepeat(_arena, initialDelay, interval, runnable);

        _tasks.add(task);

        return task;
    }


}

package dev.drtheo.scheduler.api;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

import dev.drtheo.scheduler.api.task.*;
import net.minecraft.util.Util;

public abstract class BaseScheduler {

    protected final Deque<Task<?>> tasks = new ConcurrentLinkedDeque<>();
    static final ExecutorService service = Util.getMainWorkerExecutor();

    public Task<?> runTaskLater(Runnable runnable, TimeUnit unit, long delay) {
        return add(new SimpleTask(runnable, TimeUnit.TICKS.from(unit, delay)));
    }

    public Task<?> runAsyncTaskLater(Runnable runnable, TimeUnit unit, long delay) {
        return add(new AsyncSimpleTask(service, runnable, TimeUnit.TICKS.from(unit, delay)));
    }

    public Task<?> runTaskTimer(Consumer<Task<?>> runnable, TimeUnit unit, long period) {
        return add(new RepeatingSimpleTask(runnable, TimeUnit.TICKS.from(unit, period)));
    }

    public Task<?> runAsyncTaskTimer(Consumer<Task<?>> runnable, TimeUnit unit, long period) {
        return add(new AsyncRepeatingSimpleTask(service, runnable, TimeUnit.TICKS.from(unit, period)));
    }

    protected Task<?> add(Task<?> task) {
        this.tasks.add(task);
        return task;
    }
}
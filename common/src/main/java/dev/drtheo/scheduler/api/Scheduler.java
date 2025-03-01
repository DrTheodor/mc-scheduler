package dev.drtheo.scheduler.api;

import dev.drtheo.scheduler.api.task.Task;
import org.jetbrains.annotations.ApiStatus;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Scheduler extends BaseScheduler {

	private static Scheduler self;

	private Scheduler() {

	}

	@ApiStatus.Internal
	public static void init() {
		if (self != null)
			return;

		self = new Scheduler();
	}

	public static Scheduler get() {
		return self;
	}

	@ApiStatus.Internal
	public void tick() {
		this.tasks.removeIf(Task::tick);
	}

	@ApiStatus.Internal
	public void clear() {
		this.tasks.clear();
	}
}
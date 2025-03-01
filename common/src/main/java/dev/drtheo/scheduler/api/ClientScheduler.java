package dev.drtheo.scheduler.api;

import dev.drtheo.scheduler.api.task.Task;
import org.jetbrains.annotations.ApiStatus;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ClientScheduler extends BaseScheduler {

	private static ClientScheduler self;

	private ClientScheduler() {

	}

	@ApiStatus.Internal
	public static void init() {
		if (self != null)
			return;

		self = new ClientScheduler();
	}

	public static ClientScheduler get() {
		return self;
	}

	@ApiStatus.Internal
	public void tick() {
		this.tasks.removeIf(Task::tick);
	}
}
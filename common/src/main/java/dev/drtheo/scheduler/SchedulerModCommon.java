package dev.drtheo.scheduler;

import dev.drtheo.scheduler.api.Scheduler;
import dev.drtheo.scheduler.api.TimeUnit;
import dev.drtheo.scheduler.platform.Services;

public class SchedulerModCommon {

	public static void init() {
		Scheduler.init();

		if (!Services.PLATFORM.isDevelopmentEnvironment()) return;

		Constants.LOG.info("Performing COMMON scheduler tests for modloader: {}", Services.PLATFORM.getPlatformName());
		Scheduler.get().runTaskLater(() -> Constants.LOG.info("COMMON scheduler test 1 | 5 second delay | SUCCESS!"), TimeUnit.SECONDS, 5);
	}

	public static void tick() {
		Scheduler.get().tick();
	}
}
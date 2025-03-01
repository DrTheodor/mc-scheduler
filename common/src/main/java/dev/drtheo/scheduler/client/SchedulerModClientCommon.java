package dev.drtheo.scheduler.client;

import dev.drtheo.scheduler.Constants;
import dev.drtheo.scheduler.api.ClientScheduler;
import dev.drtheo.scheduler.api.TimeUnit;
import dev.drtheo.scheduler.platform.Services;

public class SchedulerModClientCommon {
	public static void init() {
		ClientScheduler.init();

		if (!Services.PLATFORM.isDevelopmentEnvironment()) return;

		Constants.LOG.info("Performing CLIENT scheduler tests for modloader: {}", Services.PLATFORM.getPlatformName());
		ClientScheduler.get().runTaskLater(() -> Constants.LOG.info("CLIENT scheduler test 1 | 5 second delay | SUCCESS!"), TimeUnit.SECONDS, 5);
	}

	public static void tick() {
		ClientScheduler.get().tick();
	}
}

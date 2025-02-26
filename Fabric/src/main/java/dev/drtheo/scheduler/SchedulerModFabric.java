package dev.drtheo.scheduler;

import net.fabricmc.api.ModInitializer;

public class SchedulerModFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		SchedulerModCommon.init();
	}
}

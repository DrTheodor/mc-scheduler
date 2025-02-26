package dev.drtheo.scheduler;

import dev.drtheo.scheduler.client.SchedulerModClientCommon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.loader.api.FabricLoader;

public class SchedulerModFabric implements ModInitializer {

	@Environment(EnvType.CLIENT)
	private static void setupTicking() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> SchedulerModClientCommon.tick());
	}

	@Override
	public void onInitialize() {
		SchedulerModCommon.init();

		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			SchedulerModClientCommon.init();
			setupTicking();
		}

		ServerTickEvents.END_SERVER_TICK.register(server -> SchedulerModCommon.tick());
	}
}

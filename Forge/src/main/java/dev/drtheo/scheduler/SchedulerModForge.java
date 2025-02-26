package dev.drtheo.scheduler;

import dev.drtheo.scheduler.client.SchedulerModClientCommon;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class SchedulerModForge {

	public SchedulerModForge() {
		SchedulerModCommon.init();

		if (FMLLoader.getDist() == Dist.CLIENT) {
			SchedulerModClientCommon.init();
		}
	}

	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent e) {
		if (e.phase == TickEvent.Phase.END) {
			SchedulerModCommon.tick();
		}
	}
}
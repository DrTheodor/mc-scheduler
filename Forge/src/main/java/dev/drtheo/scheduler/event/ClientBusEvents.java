package dev.drtheo.scheduler.event;

import dev.drtheo.scheduler.Constants;
import dev.drtheo.scheduler.client.SchedulerModClientCommon;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class ClientBusEvents {
	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent e) {
		SchedulerModClientCommon.tick();
	}
}
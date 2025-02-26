package dev.drtheo.scheduler;

import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SchedulerModForge {

	public SchedulerModForge() {
		SchedulerModCommon.init();
	}
}
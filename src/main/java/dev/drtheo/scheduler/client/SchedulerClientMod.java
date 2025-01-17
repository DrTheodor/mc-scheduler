package dev.drtheo.scheduler.client;

import dev.drtheo.scheduler.api.ClientScheduler;
import net.fabricmc.api.ClientModInitializer;

public class SchedulerClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientScheduler.init();
    }
}

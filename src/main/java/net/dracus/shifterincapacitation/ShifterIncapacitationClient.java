package net.dracus.shifterincapacitation;

import net.dracus.shifterincapacitation.effect.ModEffects;
import net.dracus.shifterincapacitation.util.ClientShifterCheck;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ShifterIncapacitationClient implements ClientModInitializer {
    @java.lang.Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            if (!client.player.hasStatusEffect(ModEffects.SHIFTER_INCAPACITATED)) return;
            if (ClientShifterCheck.isRidingShifterTitan(client.player)) return; // let titan controls through


            client.options.attackKey.setPressed(false);
            client.options.useKey.setPressed(false);
        });
    }
}

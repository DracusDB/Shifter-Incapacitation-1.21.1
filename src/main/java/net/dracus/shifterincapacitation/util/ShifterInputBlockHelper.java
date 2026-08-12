package net.dracus.shifterincapacitation.util;

import net.dracus.shifterincapacitation.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public class ShifterInputBlockHelper {

    public static boolean shouldBlock(KeyBinding binding) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return false;

        // Only ever touch attack/use — never intercept unrelated keybinds.
        if (binding != mc.options.attackKey && binding != mc.options.useKey) {
            return false;
        }

        if (!mc.player.hasStatusEffect(ModEffects.SHIFTER_INCAPACITATED)) {
            return false;
        }

        return !ClientShifterCheck.isRidingShifterTitan(mc.player);
    }
}

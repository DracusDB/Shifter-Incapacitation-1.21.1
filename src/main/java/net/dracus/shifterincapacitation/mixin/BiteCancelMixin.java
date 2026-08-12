package net.dracus.shifterincapacitation.mixin;

import net.dracus.shifterincapacitation.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "daot.ODMAnimationHandler", remap = false)
public class BiteCancelMixin {

    @Inject(method = "triggerBiteForPlayer", at = @At("HEAD"), cancellable = true)
    private static void shifterincap$cancelBiteWhileIncapacitated(int entityId, CallbackInfo ci) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;

        Entity entity = mc.world.getEntityById(entityId);
        if (!(entity instanceof LivingEntity living)) return;

        if (living.hasStatusEffect(ModEffects.SHIFTER_INCAPACITATED)) {
            ci.cancel();
        }
    }
}

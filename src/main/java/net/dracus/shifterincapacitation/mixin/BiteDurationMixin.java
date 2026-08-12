package net.dracus.shifterincapacitation.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.dracus.shifterincapacitation.effect.ModEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "daot.network.ModNetworking", remap = false)
public class BiteDurationMixin {

    @ModifyConstant(
            method = "handleTitanShift",
            constant = @Constant(intValue = 21),
            require = 1
    )
    private static int shifterincap$speedUpBiteDuration(int ticks, ServerPlayerEntity player, ServerWorld level) {
        boolean incap = player.hasStatusEffect(ModEffects.SHIFTER_INCAPACITATED);
        System.out.println("[shifterincap] bite duration check: incapacitated=" + incap + " original=" + ticks);
        if (incap) {
            return 1;
        }
        return ticks;
    }
}
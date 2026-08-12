package net.dracus.shifterincapacitation.mixin;

import net.dracus.shifterincapacitation.util.ShifterInputBlockHelper;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyBinding.class)
public abstract class KeyBindingMixin {

    @Inject(method = "isPressed", at = @At("HEAD"), cancellable = true)
    private void daotbr$blockIsPressed(CallbackInfoReturnable<Boolean> cir) {
        if (ShifterInputBlockHelper.shouldBlock((KeyBinding) (Object) this)) {
            cir.setReturnValue(false);
        }
    }


    @Inject(method = "wasPressed", at = @At("RETURN"), cancellable = true)
    private void daotbr$blockWasPressed(CallbackInfoReturnable<Boolean> cir) {
        if (ShifterInputBlockHelper.shouldBlock((KeyBinding) (Object) this)) {
            cir.setReturnValue(false);
        }
    }
}

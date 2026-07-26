package net.dracus.shifterincapacitation.effect;

import net.dracus.shifterincapacitation.ShifterIncapacitation;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SHIFTER_INCAPACITATED = registerStatusEffect("shifter_incapacitated",
            new ShifterIncapacitationEffect(StatusEffectCategory.HARMFUL, 0x574959)
    );

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ShifterIncapacitation.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        ShifterIncapacitation.LOGGER.info("Registering Mod Effects for " + ShifterIncapacitation.MOD_ID);
    }
}

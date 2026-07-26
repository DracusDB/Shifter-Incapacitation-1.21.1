package net.dracus.shifterincapacitation.config;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {
    public static final GameRules.Key<GameRules.BooleanRule> ANNOUNCE_SHIFTER_DEFEAT =
            GameRuleRegistry.register(
                    "announceShifterDefeat",
                    GameRules.Category.MISC,
                    GameRuleFactory.createBooleanRule(false) //default value
            );

    public static void register() {

    }
}

package net.dracus.shifterincapacitation;

import net.dracus.shifterincapacitation.effect.ModEffects;
import net.dracus.shifterincapacitation.util.ShifterIncapacitationHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShifterIncapacitation implements ModInitializer {
	public static final String MOD_ID = "shifterincapacitation";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ShifterIncapacitationHandler.initCooldownScheduler();
		ShifterIncapacitationHandler.register();
		ShifterIncapacitationHandler.initCarryDropChecker();

		ModEffects.registerEffects();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

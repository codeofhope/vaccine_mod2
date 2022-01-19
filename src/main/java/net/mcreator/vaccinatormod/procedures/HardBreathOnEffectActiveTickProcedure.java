package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.Entity;

public class HardBreathOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWater()) {
			entity.setAirSupply(50);
		}
	}
}

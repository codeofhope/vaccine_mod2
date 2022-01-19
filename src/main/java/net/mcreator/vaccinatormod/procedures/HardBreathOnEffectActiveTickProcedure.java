package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.Entity;

public class HardBreathOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean EffectApplied = false;
		if (entity.isInWater() && EffectApplied == false) {
			entity.setAirSupply(50);
			EffectApplied = true;
		} else if (!entity.isInWater() && EffectApplied == true) {
			EffectApplied = false;
		}
	}
}

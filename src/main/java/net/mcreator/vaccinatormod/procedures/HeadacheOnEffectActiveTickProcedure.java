package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class HeadacheOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double HeadacheLevel = 0;
		entity.hurt(DamageSource.MAGIC, (float) HeadacheLevel);
		HeadacheLevel = HeadacheLevel + 0.005;
	}
}

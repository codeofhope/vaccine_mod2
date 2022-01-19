package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class HeadacheOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(DamageSource.ANVIL, (float) 0.001);
	}
}

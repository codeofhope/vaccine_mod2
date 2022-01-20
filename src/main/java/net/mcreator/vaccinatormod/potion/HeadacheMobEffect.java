
package net.mcreator.vaccinatormod.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.vaccinatormod.procedures.HeadacheOnEffectActiveTickProcedure;

public class HeadacheMobEffect extends MobEffect {
	public HeadacheMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
		setRegistryName("headache");
	}

	@Override
	public String getDescriptionId() {
		return "effect.vaccinator_mod.headache";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		HeadacheOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

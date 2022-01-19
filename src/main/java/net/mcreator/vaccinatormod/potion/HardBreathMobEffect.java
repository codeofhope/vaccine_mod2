
package net.mcreator.vaccinatormod.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.vaccinatormod.procedures.HardBreathOnEffectActiveTickProcedure;

public class HardBreathMobEffect extends MobEffect {
	public HardBreathMobEffect() {
		super(MobEffectCategory.HARMFUL, -16737793);
		setRegistryName("hard_breath");
	}

	@Override
	public String getDescriptionId() {
		return "effect.vaccinator_mod.hard_breath";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		HardBreathOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

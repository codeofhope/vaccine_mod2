package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.vaccinatormod.init.VaccinatorModModMobEffects;

public class LackoxygenDisplayOverlayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(VaccinatorModModMobEffects.HARD_BREATH) : false;
	}
}

package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.level.LevelAccessor;

public class HideConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.dayTime() > 12541 && world.dayTime() < 23460;
	}
}

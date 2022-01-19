package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;

public class InfectedNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		String Coord = "";
		return !world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty();
	}
}

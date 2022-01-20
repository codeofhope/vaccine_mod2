package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HealMeCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(20);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel(100);
	}
}

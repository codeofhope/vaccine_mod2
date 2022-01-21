package net.mcreator.vaccinatormod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.vaccinatormod.network.VaccinatorModModVariables;
import net.mcreator.vaccinatormod.init.VaccinatorModModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ImmunityprocedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			execute(event, entity.level, entity);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(VaccinatorModModGameRules.IMMUNITY) == true) {
			{
				boolean _setval = false;
				entity.getCapability(VaccinatorModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HasRAD = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

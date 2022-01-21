package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.vaccinatormod.network.VaccinatorModModVariables;

public class RADCellItemInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(VaccinatorModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasRAD = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

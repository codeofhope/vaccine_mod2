
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vaccinatormod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VaccinatorModModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> IMMUNITY = GameRules.register("immunity", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(false));
}

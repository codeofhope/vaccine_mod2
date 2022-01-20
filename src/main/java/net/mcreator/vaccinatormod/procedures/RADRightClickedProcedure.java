package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.vaccinatormod.init.VaccinatorModModMobEffects;
import net.mcreator.vaccinatormod.init.VaccinatorModModItems;

public class RADRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(VaccinatorModModMobEffects.HARD_BREATH, 9999, 1, (false), (false)));
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(VaccinatorModModItems.NEEDLE);
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}

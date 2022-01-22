package net.mcreator.vaccinatormod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.vaccinatormod.init.VaccinatorModModItems;

public class NeedleRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, (int) 0.1, (false), (false)));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("You've collected " + entity.getDisplayName().getString() + "'s blood")), (true));
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(VaccinatorModModItems.NEEDLE_BLOOD);
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(VaccinatorModModItems.NEEDLE);
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}

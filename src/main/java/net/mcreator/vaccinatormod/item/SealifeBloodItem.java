
package net.mcreator.vaccinatormod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.vaccinatormod.procedures.SealifeBloodItemInHandTickProcedure;
import net.mcreator.vaccinatormod.init.VaccinatorModModTabs;

import java.util.List;

public class SealifeBloodItem extends Item {
	public SealifeBloodItem() {
		super(new Item.Properties().tab(VaccinatorModModTabs.TAB_VACCINATED).stacksTo(1).rarity(Rarity.UNCOMMON));
		setRegistryName("sealife_blood");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Put this in research table and brew it."));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			SealifeBloodItemInHandTickProcedure.execute(world, entity);
	}
}

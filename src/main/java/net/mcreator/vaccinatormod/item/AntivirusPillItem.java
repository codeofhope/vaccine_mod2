
package net.mcreator.vaccinatormod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.vaccinatormod.init.VaccinatorModModTabs;

import java.util.List;

public class AntivirusPillItem extends Item {
	public AntivirusPillItem() {
		super(new Item.Properties().tab(VaccinatorModModTabs.TAB_VACCINATED).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat()

						.build()));
		setRegistryName("antivirus_pill");
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 80;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Get yourself a pill."));
	}
}

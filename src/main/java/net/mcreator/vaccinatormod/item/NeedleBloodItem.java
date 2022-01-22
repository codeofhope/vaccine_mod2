
package net.mcreator.vaccinatormod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.vaccinatormod.init.VaccinatorModModTabs;

import java.util.List;

public class NeedleBloodItem extends Item {
	public NeedleBloodItem() {
		super(new Item.Properties().tab(VaccinatorModModTabs.TAB_VACCINATED).stacksTo(64).rarity(Rarity.RARE));
		setRegistryName("needle_blood");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Blood"));
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vaccinatormod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class VaccinatorModModTabs {
	public static CreativeModeTab TAB_VACCINATED;

	public static void load() {
		TAB_VACCINATED = new CreativeModeTab("tabvaccinated") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.ARROW);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}

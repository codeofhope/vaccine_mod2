
package net.mcreator.vaccinatormod.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.vaccinatormod.init.VaccinatorModModTabs;
import net.mcreator.vaccinatormod.init.VaccinatorModModSounds;

import java.util.List;

public class LacrataItem extends RecordItem {
	public LacrataItem() {
		super(0, VaccinatorModModSounds.REGISTRY.get(new ResourceLocation("vaccinator_mod:lacrata")),
				new Item.Properties().tab(VaccinatorModModTabs.TAB_VACCINATED).stacksTo(1).rarity(Rarity.RARE));
		setRegistryName("lacrata");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("A record"));
	}
}

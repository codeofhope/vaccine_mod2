
package net.mcreator.vaccinatormod.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.vaccinatormod.init.VaccinatorModModTabs;

import java.util.List;

public class RepairHammerItem extends Item {
	public RepairHammerItem() {
		super(new Item.Properties().tab(VaccinatorModModTabs.TAB_VACCINATED).durability(400).rarity(Rarity.RARE));
		setRegistryName("repair_hammer");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 5F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("repair almost anything in vaccinator mod!"));
		list.add(new TextComponent("gives 16 iron when melted"));
	}
}

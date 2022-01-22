
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vaccinatormod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.vaccinatormod.item.WrapMeInPlasticItem;
import net.mcreator.vaccinatormod.item.SealifeBloodItem;
import net.mcreator.vaccinatormod.item.RepairHammerItem;
import net.mcreator.vaccinatormod.item.RADItem;
import net.mcreator.vaccinatormod.item.RADCellItem;
import net.mcreator.vaccinatormod.item.NeedleItem;
import net.mcreator.vaccinatormod.item.NeedleBloodItem;
import net.mcreator.vaccinatormod.item.MintParfaitItem;
import net.mcreator.vaccinatormod.item.LacrataItem;
import net.mcreator.vaccinatormod.item.AntivirusPillItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VaccinatorModModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item NEEDLE = register(new NeedleItem());
	public static final Item SEALIFE_BLOOD = register(new SealifeBloodItem());
	public static final Item ANTIVIRUS_PILL = register(new AntivirusPillItem());
	public static final Item REPAIR_HAMMER = register(new RepairHammerItem());
	public static final Item INFECTED = register(
			new SpawnEggItem(VaccinatorModModEntities.INFECTED, -16711936, -3355444, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("infected_spawn_egg"));
	public static final Item MINT_PARFAIT = register(new MintParfaitItem());
	public static final Item LACRATA = register(new LacrataItem());
	public static final Item RAD = register(new RADItem());
	public static final Item WRAP_ME_IN_PLASTIC = register(new WrapMeInPlasticItem());
	public static final Item RAD_CELL = register(new RADCellItem());
	public static final Item HEATER = register(VaccinatorModModBlocks.HEATER, VaccinatorModModTabs.TAB_VACCINATED);
	public static final Item NEEDLE_BLOOD = register(new NeedleBloodItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}

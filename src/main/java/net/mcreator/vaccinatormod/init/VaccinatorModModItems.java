
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vaccinatormod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.Item;

import net.mcreator.vaccinatormod.item.RepairHammerItem;
import net.mcreator.vaccinatormod.item.NeedleItem;
import net.mcreator.vaccinatormod.item.MintParfaitItem;
import net.mcreator.vaccinatormod.item.AntivirusPillItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VaccinatorModModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item NEEDLE = register(new NeedleItem());
	public static final Item ANTIVIRUS_PILL = register(new AntivirusPillItem());
	public static final Item REPAIR_HAMMER = register(new RepairHammerItem());
	public static final Item MINT_PARFAIT = register(new MintParfaitItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}

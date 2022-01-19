
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vaccinatormod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VaccinatorModModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("vaccinator_mod", "mintparfait"), new SoundEvent(new ResourceLocation("vaccinator_mod", "mintparfait")));
		REGISTRY.put(new ResourceLocation("vaccinator_mod", "mintparfait2"), new SoundEvent(new ResourceLocation("vaccinator_mod", "mintparfait2")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}

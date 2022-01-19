package net.mcreator.vaccinatormod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.vaccinatormod.entity.InfectedEntity;

public class InfectedRenderer extends MobRenderer<InfectedEntity, VillagerModel<InfectedEntity>> {
	public InfectedRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(InfectedEntity entity) {
		return new ResourceLocation("vaccinator_mod:textures/vill.png");
	}
}

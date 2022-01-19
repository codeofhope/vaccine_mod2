package net.mcreator.vaccinatormod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.TextComponent;

public class NeedleCollectBloodProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1, (false), (false)));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("You've collected " + sourceentity.getDisplayName().getString() + " blood.")), (false));
	}
}

package net.mcreator.vaccinatormod.procedures;

import net.minecraftforge.eventbus.api.Event;

public class NeedleRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1, (false), (false)));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("You've collected" + " " + entity + "'s" + " blood")), (true));
	}
}

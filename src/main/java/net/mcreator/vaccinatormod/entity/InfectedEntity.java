
package net.mcreator.vaccinatormod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.vaccinatormod.procedures.InfectedPlayerCollidesWithThisEntityProcedure;
import net.mcreator.vaccinatormod.procedures.InfectedNaturalEntitySpawningConditionProcedure;
import net.mcreator.vaccinatormod.procedures.HideConditionProcedure;
import net.mcreator.vaccinatormod.init.VaccinatorModModEntities;

@Mod.EventBusSubscriber
public class InfectedEntity extends Monster {
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(VaccinatorModModEntities.INFECTED, 20, 1, 4));
	}

	public InfectedEntity(FMLPlayMessages.SpawnEntity packet, Level world) {
		this(VaccinatorModModEntities.INFECTED, world);
	}

	public InfectedEntity(EntityType<InfectedEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, InfectedEntity.class, (float) 6, 1, 1.2) {
			@Override
			public boolean canUse() {
				double x = InfectedEntity.this.getX();
				double y = InfectedEntity.this.getY();
				double z = InfectedEntity.this.getZ();
				Entity entity = InfectedEntity.this;
				Level world = InfectedEntity.this.level;
				return super.canUse() && HideConditionProcedure.execute(world);
			}

			@Override
			public boolean canContinueToUse() {
				double x = InfectedEntity.this.getX();
				double y = InfectedEntity.this.getY();
				double z = InfectedEntity.this.getZ();
				Entity entity = InfectedEntity.this;
				Level world = InfectedEntity.this.level;
				return super.canContinueToUse() && HideConditionProcedure.execute(world);
			}
		});
		this.goalSelector.addGoal(3, new MoveBackToVillageGoal(this, 0.6, false) {
			@Override
			public boolean canUse() {
				double x = InfectedEntity.this.getX();
				double y = InfectedEntity.this.getY();
				double z = InfectedEntity.this.getZ();
				Entity entity = InfectedEntity.this;
				Level world = InfectedEntity.this.level;
				return super.canUse() && HideConditionProcedure.execute(world);
			}

			@Override
			public boolean canContinueToUse() {
				double x = InfectedEntity.this.getX();
				double y = InfectedEntity.this.getY();
				double z = InfectedEntity.this.getZ();
				Entity entity = InfectedEntity.this;
				Level world = InfectedEntity.this.level;
				return super.canContinueToUse() && HideConditionProcedure.execute(world);
			}
		});
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.death"));
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		Entity entity = this;
		Level world = this.level;
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();

		InfectedPlayerCollidesWithThisEntityProcedure.execute(entity);
	}

	public static void init() {
		SpawnPlacements.register(VaccinatorModModEntities.INFECTED, SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> {
					int x = pos.getX();
					int y = pos.getY();
					int z = pos.getZ();
					return InfectedNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
				});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		return builder;
	}
}

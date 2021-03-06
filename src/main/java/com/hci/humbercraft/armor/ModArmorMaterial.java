package com.hci.humbercraft.armor;

import java.util.function.Supplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import com.hci.humbercraft.init.ItemInit;

public enum ModArmorMaterial implements IArmorMaterial{
	
	JARIUM("humbercraft:jarium", 40, new int[] {3, 6, 7, 4} , 20, 
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0f, () -> {return Ingredient.fromItems(ItemInit.JARIUM.get());
		}),
	
	JAVIUM("humbercraft:javium", 40, new int[] {3, 6, 7, 4} , 20, 
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0f, () -> {return Ingredient.fromItems(ItemInit.JAVIUM.get());
		});		
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};	
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final Supplier<Ingredient> repairMaterial;
	
	ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
			SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial){
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.repairMaterial = repairMaterial;		
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
	
	
}

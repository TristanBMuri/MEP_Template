package Game.Units.UnitHelpers;

import Game.Equipment.EquipmentHelpers.Weapon;
import Game.Units.UnitHelpers.Equipment.EquipmentSlots;

public interface Equipable {
    // Try to Equip a Weapon to the unit
    void equipWeapon(Weapon weapon);

    // Try to Unequip a Weapon from the unit
    void unequipWeapon();

    // Get the equipped Weapon
    Weapon getEquippedWeapon();

    // Has Weapon equipped
    boolean hasWeaponEquipped();

    // Get the Equipment slots of the unit
    EquipmentSlots getEquipmentSlots();
}

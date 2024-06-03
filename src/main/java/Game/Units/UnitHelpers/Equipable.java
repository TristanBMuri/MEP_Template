package Game.Units.UnitHelpers;

import Game.Equipment.EquipmentHelpers.Weapon;

public interface Equipable {
    // Try to Equip a Weapon to the unit
    void equipWeapon(Weapon weapon);

    // Try to Unequip a Weapon from the unit
    void unequipWeapon();

    // Get the equipped Weapon
    Weapon getEquippedWeapon();

    // Has Weapon equipped
    boolean hasWeaponEquipped();
}

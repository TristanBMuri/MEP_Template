package Game.Equipment.EquipmentHelpers;

import Game.Units.UnitHelpers.DamageTypes;

public interface Weapon {
    public int getDamage();
    public int getRange();
    public EquipmentType getType();
    public String getName();
    public void setName(String name);
    public DamageTypes getDamageType();
    public WeaponType getWeaponType();
    public void setWeaponType(WeaponType weaponType);
}

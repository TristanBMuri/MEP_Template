package Game.Equipment;

import Game.Equipment.EquipmentHelpers.EquipmentType;
import Game.Equipment.EquipmentHelpers.Weapon;
import Game.Equipment.EquipmentHelpers.WeaponType;
import Game.Units.UnitHelpers.DamageTypes;

public class Excalibur implements Weapon{
    private int damage;
    private int range;
    private EquipmentType type;
    private String name;
    private DamageTypes damageType;
    private WeaponType weaponType;

    public Excalibur() {
        this.damage = 50;
        this.range = 1;
        this.type = EquipmentType.WEAPON;
        this.name = "Excalibur";
        this.damageType = DamageTypes.SLASHING;
        this.weaponType = WeaponType.SWORD;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public EquipmentType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public DamageTypes getDamageType() {
        return damageType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}

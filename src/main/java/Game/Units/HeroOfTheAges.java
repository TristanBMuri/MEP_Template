package Game.Units;

import Game.Equipment.EquipmentHelpers.Weapon;
import Game.Equipment.Excalibur;
import Game.Helpers.AttackEvent;
import Game.Units.UnitHelpers.*;

import java.util.HashMap;
import java.util.Map;

public class HeroOfTheAges implements Combat_Unit {
    private Stats stats;
    private Weapon equippedWeapon;
    private Weapon baseWeapon;

    public HeroOfTheAges() {
        this.stats = new Stats(
                100,
                100,
                100,
                null,
                null,
                10,
                0);
        innitEquipment();
    }

    @Override
    public void attack(Combat_Unit target) {
        // Attack the target unit

    }

    @Override
    public void takeDamage(AttackEvent attack) {
        // Take damage from the attacker
    }

    @Override
    public double getHealth() {
        return stats.getHealth();
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        // Equip a Weapon to the unit
        if (equippedWeapon == null) {
            this.equippedWeapon = weapon;
        } else {
            System.out.println("You already have a weapon equipped!");
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getGoldUpkeep() {
        return goldUpkeep;
    }

    private void innitStats(){
        // Innit stats for the unit

        // Innit resistances for the unit
        Map<DamageTypes, Resistance> baseResistances = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseResistances.put(type, new Resistance(type, 30));
        }

        Map<DamageTypes, Resistance> baseMagicResistance = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseMagicResistance.put(type, new Resistance(type, 20));
        }

        this.stats = new Stats(
                100,
                100,
                100,
                10,
                10,
                10,
                // Base resistances
                baseResistances,
                // Base magic resistances
                baseMagicResistance,
                1,
                0);
    }

    @Override
    public void innitResistances() {

    }

    @Override
    public void innitEquipment() {
        // Innit equipment for the unit
        this.baseWeapon = new Excalibur();
    }

    @Override
    public void unequipWeapon() {
        // Unequip a Weapon from the unit
        if (equippedWeapon != null) {
            this.equippedWeapon = null;
        } else {
            System.out.println("You don't have a weapon equipped!");
        }
    }

    @Override
    public Weapon getEquippedWeapon() {
        // Get the equipped Weapon
        return equippedWeapon;
    }

    @Override
    public boolean hasWeaponEquipped() {
        // Has Weapon equipped
        return equippedWeapon != null;
    }

    @Override
    public int getBaseAttackDamage() {
        return baseAttackDamage;
    }

    @Override
    public int getAttackDamage() {
        if (hasWeaponEquipped()) {
            return getBaseAttackDamage() + getEquippedWeapon().getDamage();
        } else {
            return getBaseAttackDamage();
        }
    }

    @Override
    public void setBaseAttackDamage(int baseAttackDamage) {
        this.baseAttackDamage = baseAttackDamage;
    }
}

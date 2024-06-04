package Game.Units;

import Game.Equipment.EquipmentHelpers.Weapon;
import Game.Equipment.Excalibur;
import Game.Helpers.AttackEvent;
import Game.Units.UnitHelpers.*;
import Game.Units.UnitHelpers.Stats.Resistance;
import Game.Units.UnitHelpers.Stats.StatModifier;
import Game.Units.UnitHelpers.Stats.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HeroOfTheAges implements Combat_Unit, Equipable {
    private String name;
    private Stats stats;
    private Weapon equippedWeapon;
    private Weapon baseWeapon;

    public HeroOfTheAges() {
        // Innit the unit
        this.name = "Bob";
        innitStats();
        innitEquipment();
    }

    public HeroOfTheAges(String name) {
        // Innit the unit
        this.name = name;
        innitStats();
        innitEquipment();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void attack(Combat_Unit target) {
        // Attack the target unit
    }

    @Override
    public ArrayList<StatModifier> getStatModifiers() {
        return stats.getStatModifiers();
    }

    @Override
    public void addStatModifier(StatModifier statModifier) {
        stats.addStatModifier(statModifier);
    }

    @Override
    public void removeStatModifier(StatModifier statModifier) {
        stats.removeStatModifier(statModifier);
    }

    @Override
    public void takeDamage(AttackEvent attack) {
        // Take damage from the attacker
    }

    @Override
    public int getBaseAttackDamage() {
        return stats.getBaseAttackDamage();
    }

    @Override
    public double getHealth() {
        return stats.getHealth();
    }

    @Override
    public void setHealth(int health) {
        stats.setHealth(health);
    }

    @Override
    public int getMaxHealth() {
        return stats.getMaxHealth();
    }

    @Override
    public int getArmor() {
        return stats.getArmor();
    }

    @Override
    public Map<DamageTypes, Resistance> getMagicResistance() {
        return stats.getMagicResistance();
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
        return stats.getLevel();
    }

    @Override
    public int getExperience() {
        return stats.getExperience();
    }

    @Override
    public int getGoldUpkeep() {
        return stats.getGoldUpkeep();
    }

    private void innitStats(){
        // Innit stats for the unit
        this.stats = new Stats(
            100,
            100,
            100,
            10,
            1,
            0);
    }

    @Override
    public void innitResistances() {
        // Innit resistances for the unit
        Map<DamageTypes, Resistance> baseResistances = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseResistances.put(type, new Resistance(type, 30));
        }

        stats.setBaseResistances(baseResistances);

        Map<DamageTypes, Resistance> baseMagicResistance = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseMagicResistance.put(type, new Resistance(type, 20));
        }

        stats.setBaseMagicResistance(baseMagicResistance);
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
    public int getAttackDamage() {
        if (hasWeaponEquipped()) {
            return getBaseAttackDamage() + getEquippedWeapon().getDamage();
        } else {
            return getBaseAttackDamage();
        }
    }

    @Override
    public void setBaseAttackDamage(int baseAttackDamage) {
        stats.setBaseAttackDamage(baseAttackDamage);
    }
}

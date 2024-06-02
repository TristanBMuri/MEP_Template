package Game.Units;

import Game.Equipment.EquipmentHelpers.Weapon;
import Game.Equipment.Excalibur;
import Game.Helpers.AttackEvent;
import Game.Units.UnitHelpers.Combat_Unit;
import Game.Units.UnitHelpers.Damage;
import Game.Units.UnitHelpers.DamageTypes;
import Game.Units.UnitHelpers.Resistance;

import java.util.HashMap;
import java.util.Map;

public class HeroOfTheAges implements Combat_Unit {
    private int health;
    private int baseMaxHealth;
    private int maxHealth;
    private int baseArmor;
    private int armor;
    private int baseAttackDamage;
    private Map<DamageTypes, Resistance> baseResistances;
    private Map<DamageTypes, Resistance> resistances;
    private Map<DamageTypes, Resistance> baseMagicResistance;
    private Map<DamageTypes, Resistance> magicResistance;
    private int level;
    private int experience;
    private int goldUpkeep;
    private Weapon equippedWeapon;
    private Weapon baseWeapon;

    public HeroOfTheAges() {
        this.health = 100;
        this.baseMaxHealth = 100;
        this.maxHealth = 100;
        this.baseAttackDamage = 10;
        this.baseArmor = 10;
        this.armor = 10;
        this.level = 1;
        this.experience = 0;
        this.goldUpkeep = 0;
        innitResistances();
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
    public int getHealth() {
        if (health > maxHealth) {
            health = maxHealth;
        }
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getBaseMaxHealth() {
        return baseMaxHealth;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getBaseArmor() {
        return baseArmor;
    }

    @Override
    public int getArmor() {
        return getBaseArmor() + armor;
    }

    @Override
    public Map<DamageTypes, Resistance> getMagicResistance() {
        return magicResistance;
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

    @Override
    public void innitResistances() {
        // Innit resistances for the unit
        baseResistances = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseResistances.put(type, new Resistance(type, 30));
        }

        baseMagicResistance = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseMagicResistance.put(type, new Resistance(type, 20));
        }
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

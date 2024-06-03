package Game.Units.UnitHelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Game.Units.UnitHelpers.ModifierTargets.*;

public class Stats {
    private double health;
    private int baseMaxHealth;
    private int maxHealth;
    private final int baseArmor;
    private int armor;
    private final int baseAttackDamage;
    private int attackDamage;
    private final int baseMagicDamage;
    private int magicDamage;
    private Map<DamageTypes, Resistance> baseResistances;
    private Map<DamageTypes, Resistance> resistances;
    private Map<DamageTypes, Resistance> baseMagicResistance;
    private Map<DamageTypes, Resistance> magicResistance;
    private ArrayList<StatModifier> statModifiers;
    private int level;
    private int experience;
    private final int baseGoldUpkeep;
    private int goldUpkeep;


    public Stats(int baseMaxHealth, int baseArmor, int baseAttackDamage, int baseMagicDamage, int level, int baseGoldUpkeep) {
        this.baseMaxHealth = baseMaxHealth;
        this.baseArmor = baseArmor;
        this.baseAttackDamage = baseAttackDamage;
        this.baseMagicDamage = baseMagicDamage;
        this.level = level;
        this.experience = 0;
        this.baseGoldUpkeep = baseGoldUpkeep;
    }

    public Stats(int baseMaxHealth, int baseArmor, int baseAttackDamage, int baseMagicDamage,Map<DamageTypes, Resistance> baseResistances, Map<DamageTypes, Resistance> baseMagicResistance, int level, int baseGoldUpkeep) {
        this.baseMaxHealth = baseMaxHealth;
        this.baseArmor = baseArmor;
        this.baseAttackDamage = baseAttackDamage;
        this.baseMagicDamage = baseMagicDamage;
        this.baseResistances = baseResistances;
        this.baseMagicResistance = baseMagicResistance;
        this.level = level;
        this.experience = 0;
        this.baseGoldUpkeep = baseGoldUpkeep;
    }

    public Map<DamageTypes, Resistance> getMagicResistance() {
        return magicResistance;
    }

    public void setBaseResistances(Map<DamageTypes, Resistance> baseResistances) {
        this.baseResistances = baseResistances;
    }

    public void setBaseMagicResistance(Map<DamageTypes, Resistance> baseMagicResistance) {
        this.baseMagicResistance = baseMagicResistance;
    }

    public ArrayList<StatModifier> getStatModifiers() {
        return statModifiers;
    }

    public void addStatModifier(StatModifier statModifier) {
        statModifiers.add(statModifier);
    }

    public void removeStatModifier(StatModifier statModifier) {
        statModifiers.remove(statModifier);
    }

    public double getHealth() {
        if (health > maxHealth) {
            health = maxHealth;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, maxHealth);
    }

    public int getBaseMaxHealth() {
        return baseMaxHealth;
    }

    public int getMaxHealth() {
        if(maxHealth == 0){
            return baseMaxHealth;
        }
        return maxHealth;
    }

    public void modifyStat(ArrayList<StatModifier> modifiers){
        // Modify the stats of the unit with a Stream of StatModifiers
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getGoldUpkeep() {
        if (goldUpkeep == 0) {
            return baseGoldUpkeep;
        }
        return goldUpkeep;
    }

    public int getAttackDamage() {
        if (attackDamage == 0) {
            return baseAttackDamage;
        }
        return attackDamage;
    }

    public int getMagicDamage() {
        if (magicDamage == 0) {
            return baseMagicDamage;
        }
        return magicDamage;
    }

    public void setBaseAttackDamage(int baseAttackDamage) {
        this.attackDamage = baseAttackDamage;
    }

    public int getBaseAttackDamage() {
        return baseAttackDamage;
    }

    public int getArmor() {
        if (armor == 0) {
            return baseArmor;
        }
        return armor;
    }
}

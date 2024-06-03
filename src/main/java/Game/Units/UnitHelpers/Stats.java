package Game.Units.UnitHelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Game.Units.UnitHelpers.ModifierTargets.*;

public class Stats {
    private double health;
    private int baseMaxHealth;
    private double maxHealth;
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
    private int level;
    private int experience;
    private int goldUpkeep;

    public Stats(int baseMaxHealth, int baseArmor, int baseAttackDamage, int baseMagicDamage,Map<DamageTypes, Resistance> baseResistances, Map<DamageTypes, Resistance> baseMagicResistance, int level, int goldUpkeep) {
        this.baseMaxHealth = baseMaxHealth;
        this.baseArmor = baseArmor;
        this.baseAttackDamage = baseAttackDamage;
        this.baseMagicDamage = baseMagicDamage;
        this.baseResistances = baseResistances;
        this.baseMagicResistance = baseMagicResistance;
        this.level = level;
        this.experience = 0;
        this.goldUpkeep = goldUpkeep;
    }

    public double getHealth() {
        if (health > maxHealth) {
            health = maxHealth;
        }
        return health;
    }

    public void setHealth(double health) {
        if (health > maxHealth) {
            this.health = maxHealth;
        } else {
            this.health = health;
        }
    }

    public int getBaseMaxHealth() {
        return baseMaxHealth;
    }

    public double getMaxHealth() {
        if(maxHealth == 0){
            return baseMaxHealth;
        }
        return maxHealth;
    }

    public void modifyStat(ArrayList<StatModifier> modifiers){
        // Modify the stats of the unit with a Stream of StatModifiers
    }
}

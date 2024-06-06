package Game.Units.UnitHelpers.Stats;

import Game.Units.UnitHelpers.DamageTypes;
import Game.Units.UnitHelpers.Events.NewModifierEvent;
import Game.Units.UnitHelpers.Events.NewModifierListener;

import java.util.*;

public class Stats {
    private int health;
    private final int baseMaxHealth;
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
    private final int level;
    private int experience;
    private final int baseGoldUpkeep;
    private int goldUpkeep;
    private ArrayList<NewModifierListener> listeners = new ArrayList<>();


    public Stats(int baseMaxHealth, int baseArmor, int baseAttackDamage, int baseMagicDamage, int level, int baseGoldUpkeep) {
        this.baseMaxHealth = baseMaxHealth;
        this.health = baseMaxHealth;
        this.baseArmor = baseArmor;
        this.baseAttackDamage = baseAttackDamage;
        this.baseMagicDamage = baseMagicDamage;
        this.level = level;
        this.experience = 0;
        this.baseGoldUpkeep = baseGoldUpkeep;
        this.statModifiers = new ArrayList<>();
        new NewModifierEventHandler();
        innitResistances();
        updateStats();
    }

    public Stats(int baseMaxHealth, int baseArmor, int baseAttackDamage, int baseMagicDamage, int level, int baseGoldUpkeep, ArrayList<StatModifier> statModifiers) {
        this.baseMaxHealth = baseMaxHealth;
        this.health = baseMaxHealth;
        this.baseArmor = baseArmor;
        this.baseAttackDamage = baseAttackDamage;
        this.baseMagicDamage = baseMagicDamage;
        this.level = level;
        this.experience = 0;
        this.baseGoldUpkeep = baseGoldUpkeep;
        this.statModifiers = statModifiers;
        new NewModifierEventHandler();
        innitResistances();
        updateStats();
    }

    public Stats(int baseMaxHealth, int baseArmor, int baseAttackDamage, int baseMagicDamage,Map<DamageTypes, Resistance> baseResistances, Map<DamageTypes, Resistance> baseMagicResistance, int level, int baseGoldUpkeep) {
        this.baseMaxHealth = baseMaxHealth;
        this.health = baseMaxHealth;
        this.baseArmor = baseArmor;
        this.baseAttackDamage = baseAttackDamage;
        this.baseMagicDamage = baseMagicDamage;
        this.baseResistances = baseResistances;
        this.baseMagicResistance = baseMagicResistance;
        this.level = level;
        this.experience = 0;
        this.baseGoldUpkeep = baseGoldUpkeep;
        this.statModifiers = new ArrayList<>();
        new NewModifierEventHandler();
        updateStats();
    }

    private void innitResistances() {
        // Innit resistances
        Map<DamageTypes, Resistance> baseResistances = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseResistances.put(type, new Resistance(type, 0));
        }

        setBaseResistances(baseResistances);

        Map<DamageTypes, Resistance> baseMagicResistance = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            baseMagicResistance.put(type, new Resistance(type, 0));
        }

        setBaseMagicResistance(baseMagicResistance);
    }

    private class NewModifierEventHandler implements NewModifierListener {
        public NewModifierEventHandler() {
            listeners.add(this);
        }

        @Override
        public void onNewModifier(NewModifierEvent event) {
            // Update the stats of the unit
            // We'll figure out why there is a need for this 'if' later
            if (event.isAdded()) {
                updateStats();
            } else {
                updateStats();
            }
        }
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

    public void updateStats() {
        // Base values are not directly modified
        maxHealth = baseMaxHealth;
        armor = baseArmor;
        attackDamage = baseAttackDamage;
        magicDamage = baseMagicDamage;
        resistances = new HashMap<>(baseResistances);

        magicResistance = new HashMap<>(baseMagicResistance);
        goldUpkeep = baseGoldUpkeep;

         // Sort modifiers by priority and duration (assuming you add that logic)
         statModifiers.sort(Comparator.comparing(StatModifier::getPriority)
            .thenComparing(StatModifier::getDuration).reversed());

        // Separate modifiers by type
        List<StatModifier> additiveModifiers = statModifiers.stream()
                .filter(mod -> mod.getModifierType() == ModifierType.ADDITIVE)
                .sorted(Comparator.comparing(StatModifier::getPriority).reversed())
                .toList();

        List<StatModifier> multiplicativeModifiers = statModifiers.stream()
                .filter(mod -> mod.getModifierType() == ModifierType.MULTIPLICATIVE)
                .sorted(Comparator.comparing(StatModifier::getPriority).reversed())
                .toList();

        // Apply additive modifiers first
        for (StatModifier mod : additiveModifiers) {
            applyModifier(mod);
        }

        // Apply multiplicative modifiers second
        for (StatModifier mod : multiplicativeModifiers) {
            applyModifier(mod);
        }
    }

    public void updateStat(ModifierTargets targetStat){
        ArrayList<StatModifier> targetModifiers = new ArrayList<>();

        targetModifiers = (ArrayList<StatModifier>) statModifiers.stream()
                .filter(mod -> mod.getModifierTarget() == targetStat)
                .sorted(Comparator.comparing(StatModifier::getPriority).reversed())
                .toList();

        for (StatModifier mod : targetModifiers) {
            applyModifier(mod);
        }
    }


    // Helper method to apply a single modifier
    private void applyModifier(StatModifier mod) {
        ModifierTargets target = mod.getModifierTarget();
        double value = mod.getValue();
        switch (target) {
            case HEALTH:
                maxHealth = applyModifiers(maxHealth, mod);
                health = applyModifiers(health, mod);
                break;
            case ARMOR:
                armor = applyModifiers(armor, mod);
                break;
            case ATTACK_DAMAGE:
                attackDamage = applyModifiers(attackDamage, mod);
                break;
            case MAGIC_DAMAGE:
                magicDamage = applyModifiers(magicDamage, mod);
                break;
            case RESISTANCE:
                applyResistanceModifiers(mod, value, resistances);
                break;
            case MAGIC_RESISTANCE:
                applyResistanceModifiers(mod, value, magicResistance);
                break;
            case GOLD_UPKEEP:
                applyModifiers(goldUpkeep, mod);
                break;
        }
    }

    private void applyResistanceModifiers(StatModifier mod, double value, Map<DamageTypes, Resistance> magicResistance) {
        if (mod.getModifierType() == ModifierType.ADDITIVE) {
            for (Resistance resistance : magicResistance.values()) {
                resistance.addValue(value);
            }
        } else {
            for (Resistance resistance : magicResistance.values()) {
                resistance.setValue(resistance.getValue() * (1 + value/100));
            }
        }
    }

    private int applyModifiers(int stat, StatModifier mod) {
        if (mod.getModifierType() == ModifierType.ADDITIVE) {
            return stat += mod.getValue();
        } else {
            return stat *= (1 + mod.getValue()/100);
        }
    }


    public void addStatModifier(StatModifier statModifier) {
        if(!statModifier.isPermanent()){
            if (statModifier.getDuration() <= 0){
                throw new IllegalArgumentException("Non Permanent Duration must be greater than 0");
            }
        }
        statModifiers.add(statModifier);
        notifyNewModifierListeners(statModifier, true);
    }
    public void removeStatModifier(StatModifier statModifier) {
        statModifiers.remove(statModifier);
        notifyNewModifierListeners(statModifier, false);
    }

    public int getHealth() {
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
        return maxHealth;
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

    public ArrayList<NewModifierListener> getListeners() {
        return listeners;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public void addNewModifierListener(NewModifierListener listener) {
        listeners.add(listener);
    }

    public void removeNewModifierListener(NewModifierListener listener) {
        listeners.remove(listener);
    }

    private void notifyNewModifierListeners(StatModifier modifier, boolean added) {
        NewModifierEvent event = new NewModifierEvent(modifier, added);
        for (NewModifierListener listener : listeners) {
            listener.onNewModifier(event);
        }
    }
}

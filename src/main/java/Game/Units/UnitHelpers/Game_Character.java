package Game.Units.UnitHelpers;

import Game.Units.UnitHelpers.Stats.Resistance;

import java.util.HashMap;
import java.util.Map;

public class Game_Character {
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private double defense = 2;
    private double magicDefense = 1;
    private Map<DamageTypes, Resistance> resistances;
    private Map<DamageTypes, Resistance> magicalResistances;
    private final int factionId;
    public static final double SCALING_FACTOR = 10;

    public Game_Character(String name) {
        this.name = name;
        this.maxHealth = 30;
        this.health = maxHealth;
        this.attackPower = 10;
        this.factionId = 0;
        innitResistances();
    }

    public Game_Character(String name, int factionId) {
        this.name = name;
        this.maxHealth = 30;
        this.health = maxHealth;
        this.attackPower = 10;
        this.factionId = factionId;
        innitResistances();
    }

    public Game_Character(String name, int maxHealth, int attackPower, int factionId) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = this.maxHealth;
        this.attackPower = attackPower;
        this.factionId = factionId;
        innitResistances();
    }

    public Game_Character(String name, int maxHealth, int attackPower, int factionId, double defense, double magicDefense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.factionId = factionId;
        this.defense = defense;
        this.magicDefense = magicDefense;
        innitResistances();
    }

    private void innitResistances() {
        resistances = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            resistances.put(type, new Resistance(type, 0));
        }

        magicalResistances = new HashMap<>();
        for (DamageTypes type : DamageTypes.values()) {
            magicalResistances.put(type, new Resistance(type, 0));
        }
    }

    public void takeDamage(Damage damage) {
        if (!damage.isMagical()) {
            double damageValue = calculatePhysicalDamage(damage.getValue(), defense);
            health -= (int) (damageValue * resistances.get(damage.getType()).getValue());
            System.out.println(name + " took " + (int) damageValue + " physical damage!");
        } else {
            double damageValue = calculateMagicalDamage(damage.getValue(), magicDefense);
            health -= (int) (damageValue * magicalResistances.get(damage.getType()).getValue());
            System.out.println(name + " took " + (int) damageValue + " magical damage!");

        }

        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }

        System.out.println(name + " took " + damage.getType().name() + " damage!");
    }

    private double calculatePhysicalDamage(double incomingDamage, double defense) {
        double reductionFactor = Math.log(defense + 1) / (Math.log(defense + 1) + SCALING_FACTOR);
        return incomingDamage * (1 - reductionFactor);
    }

    private double calculateMagicalDamage(double incomingDamage, double magicDefense) {
        double reductionFactor = Math.log(magicDefense + 1) / (Math.log(magicDefense + 1) + SCALING_FACTOR);
        return incomingDamage * (1 - reductionFactor);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;
        } else {
            this.health = health;
        }
    }

    public int getFactionId() {
        return factionId;
    }
}

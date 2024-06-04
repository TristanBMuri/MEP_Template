package Game.Units.UnitHelpers;

import Game.Helpers.AttackEvent;
import Game.Units.UnitHelpers.Stats.Resistance;
import Game.Units.UnitHelpers.Stats.StatModifier;

import java.util.ArrayList;
import java.util.Map;

// Interfaces for Combat classes
// It's supposed to have all necessary methods for a Combat Unit
public interface Combat_Unit {
    // Attack the target unit
    void attack(Combat_Unit target);

    ArrayList<StatModifier> getStatModifiers();

    void addStatModifier(StatModifier statModifier);

    void removeStatModifier(StatModifier statModifier);

    // Take damage from the attacker
    void takeDamage(AttackEvent attack);

    // Base Attack Damage which is supposed to be added to the weapon damage
    int getBaseAttackDamage();

    // Get the current attack damage of the unit
    int getAttackDamage();

    // Set Base Attack Damage
    void setBaseAttackDamage(int baseAttackDamage);

    // Get the current health of the unit
    double getHealth();

    // Set the current health of the unit
    void setHealth(int health);

    // Get the current max health of the unit
    int getMaxHealth();

    // Get the current armor of the unit
    int getArmor();

    // Get the current magic resistance of the unit
    Map<DamageTypes, Resistance> getMagicResistance();

    // Get the current level of the unit
    int getLevel();

    // Get the current experience of the unit
    int getExperience();

    // Get the gold upkeep of the unit
    int getGoldUpkeep();

    // Innit resistancs for the unit
    void innitResistances();

    // Innit equipment for the unit
    void innitEquipment();

    // To do: void equipArmor(Armor armor);

    // To do: void equipAccessory(Accessory accessory);

    // Get the current attack range of the unit
    // to do: int getAttackRange();

    // Get the current movement speed of the unit
    // to do: double getMovementSpeed();
}

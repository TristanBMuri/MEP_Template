package Game.Units;

import Game.Units.UnitHelpers.DamageTypes;
import Game.Units.UnitHelpers.Events.NewModifierListener;
import Game.Units.UnitHelpers.Exceptions.MissingDamageTypeException;
import Game.Units.UnitHelpers.Stats.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static Game.Units.UnitHelpers.Stats.StatModifier.createStatModifier;
import static org.junit.jupiter.api.Assertions.*;
import static Game.Units.UnitHelpers.Stats.StatModifier.*;
import static Game.Units.UnitHelpers.Stats.TemplateStatModifiers.TemplateStatModifiers.*;

final class StatsTest {
    private Stats stats;

    @BeforeEach
    void setUp() {
        Map<DamageTypes, Resistance> baseResistances = new HashMap<>();
        Map<DamageTypes, Resistance> baseMagicResistance = new HashMap<>();
        stats = new Stats(100, 50, 20, 30, baseResistances, baseMagicResistance, 1, 10);
    }

    @Test
    void testInitialValues() {
        assertEquals(100, stats.getBaseMaxHealth());
        assertEquals(50, stats.getArmor());
        assertEquals(20, stats.getBaseAttackDamage());
        assertEquals(30, stats.getMagicDamage());
        assertEquals(1, stats.getLevel());
        assertEquals(10, stats.getGoldUpkeep());
    }

    @Test
    void testHealth() {
        stats.setHealth(80);
        assertEquals(80, stats.getHealth());
        stats.setHealth(120); // Exceeds max health
        assertEquals(100, stats.getHealth());
    }

    @Test
    void testAddExperience() {
        assertEquals(0, stats.getExperience());
        stats.addExperience(50);
        assertEquals(50, stats.getExperience());
    }

    @Test
    void testAttackDamage() {
        assertEquals(20, stats.getAttackDamage());
        stats.setBaseAttackDamage(40);
        assertEquals(40, stats.getAttackDamage());
    }

    @Test
    void testAddNewModifierListener() {
        NewModifierListener listener = event -> {};
        stats.addNewModifierListener(listener);
        assertTrue(stats.getListeners().contains(listener));
    }

    @Test
    void testRemoveNewModifierListener() {
        NewModifierListener listener = event -> {};
        stats.addNewModifierListener(listener);
        assertTrue(stats.getListeners().contains(listener));
        stats.removeNewModifierListener(listener);
        assertFalse(stats.getListeners().contains(listener));
    }

    @Test
    void healthCannotExceedMaxHealth() {
        Stats stats = new Stats(100, 10, 10, 5,  1, 10);
        stats.setHealth(120);
        assertEquals(100, stats.getHealth());
    }

    @Test
    void healthIsSetCorrectly() {
        Stats stats = new Stats(100, 10, 10, 4, 4, 10);
        stats.setHealth(80);
        assertEquals(80, stats.getHealth());
    }

    @Test
    void updateStatsWithAdditiveModifierIncreasesStats() {
        StatModifier additiveModifier = additiveHealthModifier(10);
        stats.addStatModifier(additiveModifier);
        stats.updateStats();
        assertEquals(110, stats.getMaxHealth());
    }

    @Test
    void updateStatsWithMultiplicativeModifierIncreasesStats() {
        StatModifier multiplicativeModifier = multiplicativeArmorModifier(50);
        stats.addStatModifier(multiplicativeModifier);
        stats.updateStats();
        assertEquals(75, stats.getArmor());
    }

    @Test
    void updateStatsWithMultipleModifiersAppliesAll() {
        StatModifier additiveModifier = additiveHealthModifier(10);
        StatModifier multiplicativeModifier = multiplicativeArmorModifier(50);
        stats.addStatModifier(additiveModifier);
        stats.addStatModifier(multiplicativeModifier);
        stats.updateStats();
        assertEquals(110, stats.getMaxHealth());
        assertEquals(75, stats.getArmor());
    }

    @Test
    void updateStatsWithExpiredModifierDoesNotApply() {
        StatModifier expiredModifier
                = createStatModifier(10, 1,
                ModifierTargets.HEALTH,
                ModifierType.ADDITIVE,
                DamageTypes.SLASHING);

        expiredModifier.setDuration(0);
        try {
            stats.addStatModifier(expiredModifier);
        } catch(IllegalArgumentException e) {
            System.out.println("Modifier is expired");
        }

        stats.updateStats();
        assertEquals(100, stats.getMaxHealth());
    }

    @Test
    void updateStatsWithNoModifiersKeepsBaseValues() {
        stats.updateStats();
        assertEquals(100, stats.getMaxHealth());
        assertEquals(50, stats.getArmor());
        assertEquals(20, stats.getAttackDamage());
        assertEquals(30, stats.getMagicDamage());
    }

    @Test
    void testAddStatModifier() {
        StatModifier stm = additiveArmorModifier(10);
        stats.addStatModifier(stm);
        assertTrue(stats.getStatModifiers().contains(stm));
    }

    @Test
    void testRemoveStatModifier() {
        StatModifier stm = additiveArmorModifier(10);
        stats.addStatModifier(stm);
        assertTrue(stats.getStatModifiers().contains(stm));
        stats.removeStatModifier(stm);
        assertFalse(stats.getStatModifiers().contains(stm));
    }

    @Test
    void testAdditiveAndMultiplicativeModifiers() {
        StatModifier stm1 = additiveArmorModifier(10);
        StatModifier stm2 = multiplicativeArmorModifier(10);
        stats.addStatModifier(stm1);
        stats.addStatModifier(stm2);
        stats.updateStats();
        assertEquals(66, stats.getArmor());
    }

    @Test
    void testAdditiveAndMultiplicativeModifiersWithDifferentTargets() {
        StatModifier stm1 = additiveArmorModifier(10);
        StatModifier stm2 = multiplicativeArmorModifier(10);
        stats.addStatModifier(stm1);
        stats.addStatModifier(stm2);
        stats.updateStats();
        assertEquals(66, stats.getArmor());
    }
}
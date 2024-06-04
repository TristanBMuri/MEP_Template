package Game.Units;

import Game.Units.UnitHelpers.DamageTypes;
import Game.Units.UnitHelpers.Events.NewModifierListener;
import Game.Units.UnitHelpers.Stats.Resistance;
import Game.Units.UnitHelpers.Stats.Stats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(1, stats.getListenerCount());
    }

    @Test
    void testRemoveNewModifierListener() {
        NewModifierListener listener = event -> {};
        stats.addNewModifierListener(listener);
        stats.removeNewModifierListener(listener);
        assertEquals(0, stats.getListenerCount());
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
    void maxHealthIsBaseMaxHealthWhenMaxHealthIsZero() {
        Stats stats = new Stats(100, 10, 10, 2, 1, 10);
        assertEquals(100, stats.getMaxHealth());
    }


}
package Game.Units.UnitHelpers.Stats;

import Game.Units.UnitHelpers.DamageTypes;
import Game.Units.UnitHelpers.Events.ModifierExpired.ModifierExpiredListener;
import Game.Units.UnitHelpers.Exceptions.MissingDamageTypeException;
import org.junit.jupiter.api.Test;


import java.util.concurrent.atomic.AtomicInteger;

import static Game.Units.UnitHelpers.Stats.StatModifier.*;
import static org.junit.jupiter.api.Assertions.*;

class StatModifierTest {

    StatModifier setUp() {
        double value = 10.0;
        int duration = 5;
        ModifierTargets target = ModifierTargets.HEALTH;
        ModifierType modifierType = ModifierType.ADDITIVE;
        try {
            return createStatModifier(value, duration, target, modifierType);
        } catch (MissingDamageTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    StatModifier damageTypeSetUp() {
        double value = 10.0;
        int duration = 5;
        ModifierTargets target = ModifierTargets.ATTACK_DAMAGE;
        ModifierType modifierType = ModifierType.ADDITIVE;
        DamageTypes damageType = DamageTypes.SLASHING;

        return createStatModifier(value, duration, target, modifierType, damageType);
    }

    @Test
    void testCreateStatModifier() throws MissingDamageTypeException {
        double value = 10.0;
        int duration = 5;
        ModifierTargets target = ModifierTargets.HEALTH;
        ModifierType modifierType = ModifierType.ADDITIVE;
        StatModifier statModifier = createStatModifier(value, duration, target, modifierType);
        assertFalse(statModifier.isPermanent());
    }

    @Test
    void testCreatePermanentStatModifier() throws MissingDamageTypeException {
        double value = 10.0;
        ModifierTargets target = ModifierTargets.HEALTH;
        ModifierType modifierType = ModifierType.ADDITIVE;
        StatModifier statModifier = createPermanentStatModifier(value, target, modifierType);
        assertTrue(statModifier.isPermanent());
    }

    @Test
    void testMissingDamageTypeException() {
        double value = 10.0;
        int duration = 5;
        ModifierTargets target = ModifierTargets.ATTACK_DAMAGE;
        ModifierType modifierType = ModifierType.ADDITIVE;
        assertThrows(MissingDamageTypeException.class, () -> {
            createStatModifier(value, duration, target, modifierType);
        });
    }

    @Test
    void testNoFalsePositiveException() {
        double value = 10.0;
        int duration = 5;
        ModifierTargets target = ModifierTargets.ARMOR;
        ModifierType modifierType = ModifierType.ADDITIVE;
        DamageTypes damageType = DamageTypes.SLASHING;
        assertDoesNotThrow(() -> {
            createStatModifier(value, duration, target, modifierType, damageType);
        });
    }

    @Test
    void addListenerAddsListenerSuccessfully() {
        StatModifier stM = setUp();
        ModifierExpiredListener listener = event -> {};
        stM.addListener(listener);
        // Assuming getListeners is a method that returns the listeners list
        assertTrue(stM.getListeners().contains(listener));
    }

    @Test
    void testRemoveListenerSuccessfully() {
        StatModifier stM = setUp();
        ModifierExpiredListener listener = event -> {};
        stM.addListener(listener);
        stM.removeListener(listener);
        assertFalse(stM.getListeners().contains(listener));
    }

    @Test
    void testNotifyListeners() {
        StatModifier stM = setUp();
        AtomicInteger superI = new AtomicInteger();
        ModifierExpiredListener listener = event -> {
            superI.set(1);
        };
        stM.addListener(listener);
        stM.notifyListeners();
        // Assuming getListeners is a method that returns the listeners list
        assertTrue(stM.getListeners().contains(listener));
        assertEquals(1, superI.get());
    }

    @Test
    void testGetValueSuccess() {
        StatModifier stM = setUp();
        assertEquals(10.0, stM.getValue());
    }

    @Test
    void testGetDuration() {
        StatModifier stM = setUp();
        assertEquals(5, stM.getDuration());
    }

    @Test
    void testIsPermanentTrue() {
        double value = 10.0;
        ModifierTargets target = ModifierTargets.HEALTH;
        ModifierType modifierType = ModifierType.ADDITIVE;
        try {
            StatModifier statModifier = createPermanentStatModifier(value, target, modifierType);
            assertTrue(statModifier.isPermanent());
        } catch (MissingDamageTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testIsPermanentFalse() {
        double value = 10.0;
        int duration = 5;
        ModifierTargets target = ModifierTargets.HEALTH;
        ModifierType modifierType = ModifierType.ADDITIVE;
        try {
            StatModifier statModifier = createStatModifier(value, duration, target, modifierType);
            assertFalse(statModifier.isPermanent());
        } catch (MissingDamageTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetModifierType() {
        StatModifier stM = setUp();
        assertEquals(ModifierType.ADDITIVE, stM.getModifierType());
    }

    @Test
    void testGetModifierTarget() {
        StatModifier stM = setUp();
        assertEquals(ModifierTargets.HEALTH, stM.getModifierTarget());
    }

    @Test
    void testGetDamageType() {
        StatModifier stM = damageTypeSetUp();
        assertEquals(DamageTypes.SLASHING, stM.getDamageType());
    }

    @Test
    void testSetDuration() {
        StatModifier stM = setUp();
        stM.setDuration(4);
        assertEquals(4, stM.getDuration());
    }

    @Test
    void testSetDurationNegative() {
        StatModifier stM = setUp();
        AtomicInteger superI = new AtomicInteger();
        ModifierExpiredListener listener = event -> {
            superI.set(1);
        };
        stM.addListener(listener);
        stM.setDuration(-1);
        assertEquals(-1, stM.getDuration());
        assertEquals(1, superI.get());
    }

    @Test
    void testGetPriority() {
        StatModifier stM = setUp();
        assertEquals(0, stM.getPriority());
    }

    @Test
    void testOnNewTurnEvent() {
        StatModifier stM = setUp();
        AtomicInteger superI = new AtomicInteger();

        stM.setDuration(0);
        ModifierExpiredListener listener = event -> {
            superI.set(1);
        };
        stM.addListener(listener);
        stM.onNewTurnEvent(null);
        assertEquals(1, superI.get());
    }

    @Test
    void testOnNewTurnEventPermanent() {
        double value = 10.0;
        ModifierTargets target = ModifierTargets.HEALTH;
        ModifierType modifierType = ModifierType.ADDITIVE;
        try {
            StatModifier stM = createPermanentStatModifier(value, target, modifierType);
            AtomicInteger superI = new AtomicInteger();
            ModifierExpiredListener listener = event -> {
                superI.set(1);
            };
            stM.addListener(listener);
            stM.onNewTurnEvent(null);
            assertEquals(0, superI.get());
        } catch (MissingDamageTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testOnNewTurnEventModifierPersists() {
        StatModifier stM = setUp();
        AtomicInteger superI = new AtomicInteger();

        ModifierExpiredListener listener = event -> {
            superI.set(1);
        };
        stM.addListener(listener);
        stM.onNewTurnEvent(null);
        assertEquals(0, superI.get());
    }
}
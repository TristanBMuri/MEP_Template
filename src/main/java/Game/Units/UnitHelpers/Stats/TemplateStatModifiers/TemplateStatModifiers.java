package Game.Units.UnitHelpers.Stats.TemplateStatModifiers;

import Game.Units.UnitHelpers.Exceptions.MissingDamageTypeException;
import Game.Units.UnitHelpers.Stats.ModifierTargets;
import Game.Units.UnitHelpers.Stats.ModifierType;
import Game.Units.UnitHelpers.Stats.StatModifier;
import Game.Units.UnitHelpers.Stats.StatModifier.*;

public class TemplateStatModifiers {
    public static StatModifier additiveHealthModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.HEALTH,
                            ModifierType.ADDITIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier multiplicativeHealthModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.HEALTH,
                            ModifierType.MULTIPLICATIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier additiveArmorModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.ARMOR,
                            ModifierType.ADDITIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier multiplicativeArmorModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.ARMOR,
                            ModifierType.MULTIPLICATIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier additiveAttackDamageModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.ATTACK_DAMAGE,
                            ModifierType.ADDITIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier multiplicativeAttackDamageModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.ATTACK_DAMAGE,
                            ModifierType.MULTIPLICATIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier additiveMagicDamageModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.MAGIC_DAMAGE,
                            ModifierType.ADDITIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier multiplicativeMagicDamageModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.MAGIC_DAMAGE,
                            ModifierType.MULTIPLICATIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier additiveGoldUpkeepModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.GOLD_UPKEEP,
                            ModifierType.ADDITIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }

    public static StatModifier multiplicativeGoldUpkeepModifier(double value) {
        StatModifier stm = null;
        try {
            stm = StatModifier
                    .createStatModifier(
                            value,
                            5,
                            ModifierTargets.GOLD_UPKEEP,
                            ModifierType.MULTIPLICATIVE);
        } catch (MissingDamageTypeException e) {
            throw new RuntimeException(e);
        }

        return stm;
    }
}

package Game.Units.UnitHelpers;

import Game.Units.UnitHelpers.Exceptions.MissingDamageTypeException;

public class StatModifier implements Comparable<StatModifier>{
    private double value;
    private int duration;
    private ModifierType modifierType;
    private boolean isPermanent;
    private ModifierTargets target;
    private DamageTypes damageType;

    private StatModifier(double value, int duration, ModifierTargets target, ModifierType modifierType) {
        this.value = value;
        this.duration = duration;
        this.isPermanent = false;
        this.modifierType = modifierType;
    }

    private StatModifier(double value, boolean isPermanent, ModifierTargets target, ModifierType modifierType) {
        this.value = value;
        this.isPermanent = isPermanent;
        if (isPermanent) {
            this.duration = -1;
        } else {
            this.duration = 1;
        }
        this.modifierType = modifierType;
        this.target = target;
    }

    public void createStatModifier(double value, int duration, ModifierTargets target, ModifierType modifierType) throws MissingDamageTypeException {
        if (target.equals(ModifierTargets.ATTACK_DAMAGE) ||
                target.equals((ModifierTargets.RESISTANCE)) || target.equals(ModifierTargets.MAGIC_RESISTANCE)){
            throw new MissingDamageTypeException("Damage type must be specified for this modifier");
        }
        new StatModifier(value, duration, target, modifierType);
    }

    public void createStatModifier(double value, int duration, ModifierTargets target, ModifierType modifierType, DamageTypes damageType) {
        new StatModifier(value, duration, target, modifierType);
        this.damageType = damageType;
    }

    public double getValue() {
        return value;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public ModifierType getModifierType(){
        return modifierType;
    }

    public ModifierTargets getTarget(){
        return target;
    }

    public DamageTypes getDamageType(){
        return damageType;
    }

    @Override
    public int compareTo(StatModifier stM) {
        // Compare the modifier type
        return this.target.compareTo(stM.getTarget());
    }
}

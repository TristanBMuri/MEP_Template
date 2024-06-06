package Game.Units.UnitHelpers.Stats;

import Game.Helpers.NewTurnEvent;
import Game.Helpers.NewTurnListener;
import Game.Units.UnitHelpers.DamageTypes;
import Game.Units.UnitHelpers.Events.ModifierExpired.ModifierExpiredEvent;
import Game.Units.UnitHelpers.Events.ModifierExpired.ModifierExpiredListener;
import Game.Units.UnitHelpers.Exceptions.MissingDamageTypeException;

import java.util.ArrayList;
import java.util.UUID;

public class StatModifier implements NewTurnListener {
    private final UUID id = UUID.randomUUID();
    private double value;
    private int duration;
    private final ModifierType modifierType;
    private boolean isPermanent;
    private ModifierTargets modifierTarget;
    private DamageTypes damageType;
    private int priority = 0;
    private ArrayList<ModifierExpiredListener> listeners = new ArrayList<>();

    private StatModifier(double value, int duration, ModifierTargets modifierTarget, ModifierType modifierType) {
        this.value = value;
        this.duration = duration;
        this.isPermanent = false;
        this.modifierType = modifierType;
        setPriority(modifierType);
        this.modifierTarget = modifierTarget;
    }

    private StatModifier(double value, int duration, ModifierTargets modifierTarget, ModifierType modifierType, int priority) {
        this.value = value;
        this.duration = duration;
        this.isPermanent = false;
        this.modifierType = modifierType;
        this.priority = priority;
        this.modifierTarget = modifierTarget;
    }

    private StatModifier(double value, boolean isPermanent, ModifierTargets modifierTarget, ModifierType modifierType) {
        this.value = value;
        this.isPermanent = isPermanent;
        if (isPermanent) {
            this.duration = -1;
        } else {
            this.duration = 1;
        }
        this.modifierType = modifierType;
        setPriority(modifierType);
        this.modifierTarget = modifierTarget;
    }

    public static StatModifier createStatModifier(double value, int duration, ModifierTargets target, ModifierType modifierType) throws MissingDamageTypeException {
        if (target.equals(ModifierTargets.ATTACK_DAMAGE) ||
                target.equals((ModifierTargets.RESISTANCE)) || target.equals(ModifierTargets.MAGIC_RESISTANCE)){
            throw new MissingDamageTypeException("Damage type must be specified for this modifier");
        }
        return new StatModifier(value, duration, target, modifierType);
    }

    public static StatModifier createStatModifier(double value, int duration, ModifierTargets target, ModifierType modifierType, DamageTypes damageType) {
        StatModifier stm = new StatModifier(value, duration, target, modifierType);
        stm.damageType = damageType;
        return stm;
    }

    public static StatModifier createStatModifier(double value, int duration, ModifierTargets target, ModifierType modifierType, int priority) {
        return new StatModifier(value, duration, target, modifierType, priority);
    }

    public static StatModifier createPermanentStatModifier(double value, ModifierTargets target, ModifierType modifierType) throws MissingDamageTypeException {
        if (target.equals(ModifierTargets.ATTACK_DAMAGE) ||
                target.equals((ModifierTargets.RESISTANCE)) || target.equals(ModifierTargets.MAGIC_RESISTANCE)){
            throw new MissingDamageTypeException("Damage type must be specified for this modifier");
        }
        return new StatModifier(value, true, target, modifierType);
    }

    public static StatModifier createPermanentStatModifier(double value, ModifierTargets target, ModifierType modifierType, DamageTypes damageType) {
        StatModifier stm = new StatModifier(value, true, target, modifierType);
        stm.damageType = damageType;
        return stm;
    }

    private void setPriority(ModifierType priority) {
        if (priority.equals(ModifierType.MULTIPLICATIVE)){
            this.priority = - 1;
        } else {
            this.priority = 10;
        }
    }

    // Methods for adding and removing listeners
    public void addListener(ModifierExpiredListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ModifierExpiredListener listener) {
        listeners.remove(listener);
    }

    // Method for notifying listeners
    public void notifyListeners() {
        for (ModifierExpiredListener listener : listeners) {
            ModifierExpiredEvent evt = new ModifierExpiredEvent(this.id);
            listener.onModifierExpired(evt);
        }
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

    public ModifierTargets getModifierTarget(){
        return modifierTarget;
    }

    public DamageTypes getDamageType(){
        return damageType;
    }

    public void setDuration(int i) {
        if (i < 0) {
            notifyListeners();
        }
        this.duration = i;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public void onNewTurnEvent(NewTurnEvent event) {
        if (!isPermanent) {
            duration--;
            if (duration <= 0) {
                // Notify listeners that the modifier has expired
                notifyListeners();
            }
        }
    }

    public ArrayList<ModifierExpiredListener> getListeners() {
        return listeners;
    }
}

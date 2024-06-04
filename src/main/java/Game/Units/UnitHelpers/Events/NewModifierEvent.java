package Game.Units.UnitHelpers.Events;

import Game.Units.UnitHelpers.Stats.StatModifier;

public class NewModifierEvent {
    private final StatModifier modifier;
    private final boolean isAdded;

    public NewModifierEvent(StatModifier modifier, boolean isAdded) {
        this.modifier = modifier;
        this.isAdded = isAdded;
    }

    public StatModifier getModifier() {
        return modifier;
    }

    public boolean isAdded() {
        return isAdded;
    }
}

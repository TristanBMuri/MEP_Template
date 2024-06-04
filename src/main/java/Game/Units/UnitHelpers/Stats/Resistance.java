package Game.Units.UnitHelpers.Stats;

import Game.Units.UnitHelpers.DamageTypes;

public class Resistance {
    // Value is a percentage of damage reduction
    // Range is -infinity to 100 % expected value should be 0
    private double value;
    private final DamageTypes type;

    public Resistance(DamageTypes type, double value) {
        this.type = type;
        this.value = value;
    }

    public DamageTypes getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addValue(double value) {
        this.value += value;
    }
}

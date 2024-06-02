package Game.Units.UnitHelpers;

public class Resistance {
    private final DamageTypes type;
    // Value is a percentage of damage reduction
    // Range is -infinity to 100 % expected value should be 0
    private double value;

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

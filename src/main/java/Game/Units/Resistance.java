package Game.Units;

public class Resistance {
    private final DamageTypes type;
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

package Game.Units;

public class Damage {
    private final DamageTypes type;
    private final double value;
    private boolean isMagical = false;

    public Damage(DamageTypes type, double value) {
        this.type = type;
        this.value = value;
        this.isMagical = false;
    }

    public Damage(DamageTypes type, double value, boolean isMagical) {
        this.type = type;
        this.value = value;
        this.isMagical = isMagical;
    }

    public DamageTypes getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public boolean isMagical() {
        return isMagical;
    }
}

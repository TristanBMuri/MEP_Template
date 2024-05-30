package Game.Units;

public class Warrior extends CombatUnit{
    private int rage;

    public Warrior(String name, int health, int damage, int rage) {
        super(name, health, damage);
        this.rage = rage;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    pu

    public void gainRage(int amount) {
        this.rage += amount;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public int getRage() {
        return rage;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Health: " + getHealth() + ", Damage: " + getHealth() + ", Rage: " + rage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Warrior)) {
            return false;
        }

        Warrior warrior = (Warrior) obj;
        return this.getName().equals(warrior.getName()) && this.getHealth() == warrior.getHealth() && this.getDamage() == warrior.getDamage() && this.rage == warrior.rage;
    }

}

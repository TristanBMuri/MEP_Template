package Game.Units;

public abstract class CombatUnit {
    private String name;
    private int health;
    private int damage;


    public CombatUnit(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void attack(CombatUnit enemy) {
        enemy.health -= this.damage;
    }

    public void defend(CombatUnit enemy) {
        this.health -= enemy.damage;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Health: " + health + ", Damage: " + damage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CombatUnit unit)) {
            return false;
        }

        return this.name.equals(unit.name) && this.health == unit.health && this.damage == unit.damage;
    }
}

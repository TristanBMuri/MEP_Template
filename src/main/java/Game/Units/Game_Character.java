package Game.Units;

public class Game_Character {
    String name;
    int health;
    private int attackPower;

    public Game_Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " took " + damage + " damage!");
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

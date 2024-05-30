package Game.Units.Helpers;

import java.util.EventObject;

public class CombatEvent extends EventObject {
    private String attacker;
    private String defender;
    private int damage;

    public CombatEvent(String attacker, String defender, int damage) {
        super(attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public String getAttacker() {
        return attacker;
    }

    public String getDefender() {
        return defender;
    }

    public int getDamage() {
        return damage;
    }
}

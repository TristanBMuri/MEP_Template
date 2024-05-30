package Game.Units.Helpers;

import java.util.EventObject;

public class AttackEvent extends EventObject {
    private String attacker;
    private String defender;
    private int damage;

    public AttackEvent(String attacker, String defender, int damage) {
        super(attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }


}

package Game.Helpers;

import Game.Units.UnitHelpers.Damage;
import Game.Units.UnitHelpers.Combat_Unit;

import java.util.EventObject;

public class AttackEvent extends EventObject {
    private final Combat_Unit attacker;
    private final Combat_Unit defender;
    private final Damage damage;

    public AttackEvent(Combat_Unit attacker, Combat_Unit defender, Damage damage) {
        super(attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public AttackEvent(Combat_Unit attacker, Combat_Unit defender, Damage damage, boolean isMagical) {
        super(attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public Combat_Unit getAttacker() {
        return attacker;
    }

    public Combat_Unit getDefender() {
        return defender;
    }

    public Damage getDamage() {
        return damage;
    }
}

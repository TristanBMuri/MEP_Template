package Game.Helpers;

import Game.Units.UnitHelpers.Damage;
import Game.Units.UnitHelpers.Game_Character;

import java.util.EventObject;

public class AttackEvent extends EventObject {
    private final Game_Character attacker;
    private final Game_Character defender;
    private final Damage damage;

    public AttackEvent(Game_Character attacker, Game_Character defender, Damage damage) {
        super(attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public AttackEvent(Game_Character attacker, Game_Character defender, Damage damage, boolean isMagical) {
        super(attacker);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public Game_Character getAttacker() {
        return attacker;
    }

    public Game_Character getDefender() {
        return defender;
    }

    public Damage getDamage() {
        return damage;
    }
}

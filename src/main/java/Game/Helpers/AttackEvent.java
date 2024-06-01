package Game.Helpers;

import Game.Units.Damage;
import Game.Units.Game_Character;

public class AttackEvent {
    private final Game_Character attacker;
    private final Game_Character defender;
    private Damage damage;

    public AttackEvent(Game_Character attacker, Game_Character defender, Damage damage) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public AttackEvent(Game_Character attacker, Game_Character defender, Damage damage, boolean isMagical) {
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

package Game.Helpers;

import Game.Units.Game_Character;

public class AttackEvent {
    Game_Character attacker;
    Game_Character defender;

    public AttackEvent(Game_Character attacker, Game_Character defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Game_Character getAttacker() {
        return attacker;
    }

    public Game_Character getDefender() {
        return defender;
    }
}

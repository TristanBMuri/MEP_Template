package Game;

import Game.Helpers.AttackEvent;
import Game.Helpers.AttackHandler;
import Game.Units.Game_Character;

public class Game {
    AttackHandler attackHandler = new AttackHandler();

    public void attack(Game_Character attacker, Game_Character defender) {
        AttackEvent event = new AttackEvent(attacker, defender);
        attackHandler.onAttackEvent(event);
    }

    public static void main(String[] args) {
        Game_Character player = new Game_Character("Player", 100, 10);
        Game_Character enemy = new Game_Character("Enemy", 100, 10);

        Game game = new Game();
        game.attack(player, enemy);
    }
}

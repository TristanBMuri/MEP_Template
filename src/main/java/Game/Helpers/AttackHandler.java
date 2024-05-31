package Game.Helpers;

import Game.Units.Game_Character;

public class AttackHandler implements AttackListener{
    @Override
    public void onAttackEvent(AttackEvent event) {
        Game_Character attacker = event.getAttacker();
        Game_Character defender = event.getDefender();

        int damage = attacker.getAttackPower();
        defender.takeDamage(damage);
        System.out.println(attacker.getName() + " attacked " + defender.getName() + " for " + damage + " damage!");
    }
}

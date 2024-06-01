package Game.Helpers;

import Game.Units.Damage;
import Game.Units.Game_Character;

public class AttackHandler implements AttackListener{
    @Override
    public void onAttackEvent(AttackEvent event) {
        Game_Character attacker = event.getAttacker();
        Game_Character defender = event.getDefender();
        Damage damage = event.getDamage();

        if (attacker.getFactionId() == defender.getFactionId()) {
            System.out.println(attacker.getName() + " cannot attack " +
                    defender.getName() + " because they are in the same faction!");
            return;
        }

        defender.takeDamage(damage);
        System.out.println(attacker.getName() + " attacked " + defender.getName() +
                " for " + (int) damage.getValue() + " damage!");
    }
}

package Game.Helpers;

import Game.Units.UnitHelpers.Combat_Unit;
import Game.Units.UnitHelpers.Damage;

public class AttackHandler implements AttackListener{
    @Override
    public void onAttackEvent(AttackEvent event) {
        Combat_Unit attacker = event.getAttacker();
        Combat_Unit defender = event.getDefender();
        Damage damage = event.getDamage();

        if (attacker.getFactionId() == defender.getFactionId()) {
            System.out.println(attacker.getName() + " cannot attack " +
                    defender.getName() + " because they are in the same faction!");
            return;
        }

        defender.takeDamage(event);
        System.out.println(attacker.getName() + " attacked " + defender.getName() +
                " for " + (int) damage.getValue() + " damage!");
    }
}

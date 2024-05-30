package Game.Units.Helpers;

public interface CombatListener {
    void onCombatEvent(CombatEvent event);
    void onAttackEvent(AttackEvent event);
}

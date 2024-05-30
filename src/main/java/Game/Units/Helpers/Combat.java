package Game.Units.Helpers;


import java.util.ArrayList;
import java.util.List;

public class Combat implements CombatListener{
    private List<CombatListener> listeners = new ArrayList<CombatListener>();

    public void addListener(CombatListener listener){
        listeners.add(listener);
    }

    public void removeListener(CombatListener listener){
        listeners.remove(listener);
    }

    public void notifyListeners(CombatEvent event){
        for(CombatListener listener : listeners){
            listener.onCombatEvent(event);
        }
    }

    public void notifyListeners(AttackEvent event){
        for(CombatListener listener : listeners){
            listener.onAttackEvent(event);
        }
    }

    @Override
    public void onCombatEvent(CombatEvent event) {
        notifyListeners(event);
    }

    @Override
    public void onAttackEvent(AttackEvent event) {
        notifyListeners(event);
    }
}

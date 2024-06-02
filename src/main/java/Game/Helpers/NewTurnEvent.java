package Game.Helpers;

import java.util.EventObject;

public class NewTurnEvent extends EventObject {
    private final int turnNumber;

    public NewTurnEvent(Object source, int turnNumber) {
        super(source);
        this.turnNumber = turnNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}

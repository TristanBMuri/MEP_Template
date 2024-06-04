package Game.Units.UnitHelpers.Events.ModifierExpired;

import java.util.UUID;

public class ModifierExpiredEvent {
    private final UUID modifierID;

    public ModifierExpiredEvent(UUID modifierID) {
        this.modifierID = modifierID;
    }

    public UUID getModifierID() {
        return modifierID;
    }
}

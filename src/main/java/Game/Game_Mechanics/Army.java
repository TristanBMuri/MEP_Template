package Game.Game_Mechanics;

import Game.Units.UnitHelpers.Combat_Unit;

import java.util.ArrayList;

public class Army {
    private int factionId;
    private int armyId;
    private int armyGoldUpkeep;
    private int currentUnitCount;
    private ArrayList<Combat_Unit> units;

    public Army(int factionId, int armyId, int armyGoldUpkeep) {
        this.factionId = factionId;
        this.armyId = armyId;
        this.armyGoldUpkeep = armyGoldUpkeep;
    }

    public int getFactionId() {
        return factionId;
    }

    public void setFactionId(int factionId) {
        this.factionId = factionId;
    }

    public int getArmyId() {
        return armyId;
    }

    public void setArmyId(int armyId) {
        this.armyId = armyId;
    }

    public int getArmyGoldUpkeep() {
        return armyGoldUpkeep;
    }

    public void setArmyGoldUpkeep(int armyGoldUpkeep) {
        this.armyGoldUpkeep = armyGoldUpkeep;
    }

    public int getCurrentUnitCount() {
        return currentUnitCount;
    }
}

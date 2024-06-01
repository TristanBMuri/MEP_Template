package Game.Game_Mechanics;

public class Faction {
    private final int id;
    private String name;
    private final boolean isPlayerFaction;

    public Faction(int id, String name, boolean isPlayerFaction) {
        this.id = id;
        this.name = name;
        this.isPlayerFaction = isPlayerFaction;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPlayerFaction() {
        return isPlayerFaction;
    }

    public void setName(String name) {
        this.name = name;
    }
}

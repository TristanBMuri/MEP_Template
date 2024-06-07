package Game.Game_Mechanics;

import java.util.UUID;

public class Faction {
    private final UUID id = UUID.randomUUID();
    private int gameId;
    private String name;
    private final boolean isPlayerFaction;
    private Army army;

    public Faction(int gameId, String name, boolean isPlayerFaction) {
        this.gameId = gameId;
        this.name = name;
        this.isPlayerFaction = isPlayerFaction;
    }

    public int getGameId() {
        return gameId;
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

    public UUID getId() {
        return id;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}

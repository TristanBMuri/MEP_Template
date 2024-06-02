package Game.Units.UnitHelpers;

// This interface is used to mark all classes that represent a unit in the game.
public interface Game_Unit {
    // Returns the name of the unit.
    String getName();

    // Returns the current health of the unit.
    double getHealth();

    // Returns the maximum health of the unit.
    double getMaxHealth();

    // Returns the movement speed of the unit.
    double getMovementSpeed();

    // Sets the unit's movement speed.
    void setMovementSpeed(double movementSpeed);

    // Sets the unit's current health.
    void setHealth(double health);

    // Returns the unit's current state.
    // to do: UnitState getState();

    // Returns the unit's current position.
    // to do: Position getPosition();

    // Sets the unit's current position.
    // to do: void setPosition(Position position);
}

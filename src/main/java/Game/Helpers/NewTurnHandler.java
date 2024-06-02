package Game.Helpers;

public class NewTurnHandler implements NewTurnListener{
    @Override
    public void onNewTurnEvent(NewTurnEvent event) {
        System.out.println("Turn number: " + event.getTurnNumber());
    }

}

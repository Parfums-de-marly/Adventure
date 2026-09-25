import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class Adventure {
    private final Map map;
    private final Player player;
    private final UserInterface ui;

    private boolean adventureIsDone = false;

    public Adventure(Map map){
        this.map = map;
        player = new Player(map.getFirstRoom());
        ui = new UserInterface();
    }

    public void run(){
        ui.showStartScreen();
        try {
            // Pause the program for 3 seconds
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while(!adventureIsDone){
            ui.showMenu();

            String commandInput = ui.getCommand();

            switch (commandInput){
                case "1" -> {
                    ui.showDoors(player.getCurrentRoom());
                }
                case "2" -> {
                    for (int i = 0; i < 4; i++) {
                        movePlayer();
                        }

                    ui.showDoors(player.getCurrentRoom());
                }
                case "3" -> {
                    String itemName = ui.askWhichItem();
                    if(player.pickUpItem(itemName)){
                        ui.itemPickup(itemName);
                    }

                }
                case "4" -> {
                    if(player.dropItem(ui.askWhichItem())) {
                        ui.itemDrop(ui.askWhichItem());
                    }
                }
                case "5" -> {

                }
            }
        }
    }

    private void movePlayer() {
        String directionInput = ui.getDirection();

        switch (directionInput) {
            case "north" -> {
                if (player.goNorth()){
                    ui.showMovement("North");
                    ui.showRoom(player.getCurrentRoom());
                } else {
                    ui.showCannotGo("North");
                }
            }
            case "east" -> {
                if (player.goEast()){
                    ui.showMovement("East");
                    ui.showRoom(player.getCurrentRoom());
                } else {
                    ui.showCannotGo("East");
                }
            }
            case "south" -> {
                if (player.goSouth()){
                    ui.showMovement("South");
                    ui.showRoom(player.getCurrentRoom());
                } else {
                    ui.showCannotGo("South");
                }
            }
            case "west" -> {
                if (player.goWest()){
                    ui.showMovement("West");
                    ui.showRoom(player.getCurrentRoom());
                } else {
                    ui.showCannotGo("West");
                }
            }
        }
    }
}

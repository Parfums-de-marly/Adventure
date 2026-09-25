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
                case "1" -> ui.showDoors(player.getCurrentRoom());

                case "2" -> {
                    movePlayer();
                    ui.showDoors(player.getCurrentRoom());
                }
                case "3" -> {
                    String itemName = ui.askWhichItem();

                    Item item = player.takeItem(itemName);

                    if (item != null) {
                        ui.itemPickup(item.getLongName());
                    } else {
                        IO.println("There is nothing like " + itemName + " to take around here");
                    }
                }

                case "4" -> {
                    String itemName = ui.askWhichItem();

                    Item item = player.dropItem(itemName);

                    if (item != null) {
                        ui.itemDrop(item.getLongName());
                    } else {
                        IO.println("You don't have anything like " + itemName + " in your inventory");
                    }
                }

                case "5" -> ui.showInventory(player);

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

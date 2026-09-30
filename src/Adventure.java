import java.util.concurrent.TimeUnit;
public class Adventure {
    private final Map map;
    private final Player player;
    private final UserInterface ui;

    private boolean adventureIsDone = false;

    public Adventure() {
        this.map = new Map();
        player = new Player(map.getFirstRoom(), 100);
        ui = new UserInterface();
    }

    public void run() {
        ui.showStartScreen();
        /*
        try {
            // Pause the program for 3 seconds
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

         */
        while(!adventureIsDone){
            ui.showMenu();

            String commandInput = ui.getCommand();

            switch (commandInput) {
                case "1" -> {
                    ui.showDoors(player.getCurrentRoom());
                }

                case "2" -> {
                    movePlayer();
                    ui.showDoors(player.getCurrentRoom());
                }
                case "3" -> {
                    String itemName = ui.askWhichItem();

                    Item item = player.takeItem(itemName);

                    if (item != null) {
                        ui.itemPickup(item.getLongName());

                        IO.println("Inventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight());
                    } else {
                        IO.println(itemName + " is either not here, or is too heavy ");
                    }
                }

                case "4" -> {
                    ui.showInventory(player);

                    String itemName = ui.askWhichItem();

                    Item item = player.dropItem(itemName);

                    if (item != null) {
                        ui.itemDrop(item.getLongName());
                        IO.println("Inventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight());

                    } else {
                        IO.println("You don't have anything like " + itemName + " in your inventory");
                    }
                }

                case "5" -> ui.showInventory(player);

                case "6" -> ui.showHealth(player);

                case "7" -> {
                    ui.showInventory(player);
                    ui.showDoors(player.getCurrentRoom());
                    String itemName = ui.itemToEat();
                    EatResult eatResult = player.eatItem(itemName);
                    int healthChange =  player.getHealth() - 100;

                    ui.itemEaten(eatResult, itemName, healthChange);
                }
            }
        }
    }

    private void movePlayer() {
        String directionInput = ui.getDirection().trim().toLowerCase();

        switch (directionInput) {
            case "north" -> {
                if (player.goNorth()){
                    ui.showMovement("North");
                    boolean isTrue = map.visitedRoom(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                    ui.showRoom(player.getCurrentRoom(), isTrue);
                    map.setVisited(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                } else {
                    ui.showCannotGo("North");
                }
            }
            case "east" -> {
                if (player.goEast()){
                    ui.showMovement("East");
                    boolean isTrue = map.visitedRoom(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                    ui.showRoom(player.getCurrentRoom(), isTrue);
                    map.setVisited(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                } else {
                    ui.showCannotGo("East");
                }
            }
            case "south" -> {
                if (player.goSouth()){
                    ui.showMovement("South");
                    boolean isTrue = map.visitedRoom(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                    ui.showRoom(player.getCurrentRoom(), isTrue);
                    map.setVisited(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                } else {
                    ui.showCannotGo("South");
                }
            }
            case "west" -> {
                if (player.goWest()){
                    ui.showMovement("West");
                    boolean isTrue = map.visitedRoom(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                    ui.showRoom(player.getCurrentRoom(), isTrue);
                    map.setVisited(Integer.parseInt(player.getCurrentRoom().getName().substring(5))-1);
                } else {
                    ui.showCannotGo("West");
                }
            }
        }
    }
}

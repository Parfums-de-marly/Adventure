import java.util.concurrent.TimeUnit;

public class Adventure {

    private final Map map;
    private final Player player;
    private final UserInterface ui;

    private String pendingUnlockDirection = null;

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
        while (!adventureIsDone) {
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

                        //  IO.println("Inventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight());
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
                        //   IO.println("Inventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight());

                    } else {
                        IO.println("You don't have anything like " + itemName + " in your inventory");
                    }
                }

                case "5" -> ui.showInventory(player);

                case "7" -> {
                    ui.showInventory(player);
                    int healthStart = player.getPlayerHealth();
                    ui.showDoors(player.getCurrentRoom());
                    String itemName = ui.itemToEat();
                    EatResult eatResult = player.eatItem(itemName);
                    int healthChange = healthStart - player.getPlayerHealth();

                    ui.itemEaten(eatResult, itemName, healthChange);
                }

                case "6" -> ui.showHealth(player);

                case "8", "unlock" -> unlockDoor();
            }
        }
    }

    private void movePlayer() {
        String directionInput = ui.getDirection().trim().toLowerCase();
        pendingUnlockDirection = null;

        MoveResult result = switch (directionInput) {
            case "north" -> player.goNorth();
            case "east" -> player.goEast();
            case "south" -> player.goSouth();
            case "west" -> player.goWest();
            default -> MoveResult.NO_DOOR;
        };

        switch (result) {
            case MOVED -> {
                ui.showMovement(capitalize(directionInput));
                boolean isTrue = map.visitedRoom(
                        Integer.parseInt(player.getCurrentRoom().getName().substring(5)) - 1);
                ui.showRoom(player.getCurrentRoom(), isTrue);
                map.setVisited(
                        Integer.parseInt(player.getCurrentRoom().getName().substring(5)) - 1);
            }
            case LOCKED -> {
                pendingUnlockDirection = directionInput;
                ui.showDoorLocked();
            }
            case NO_DOOR -> ui.showCannotGo(capitalize(directionInput));
        }
    }

    private void unlockDoor() {
        if (pendingUnlockDirection == null) {
            ui.showNothingToUnlock();
            return;
        }
        player.unlock(pendingUnlockDirection);
        pendingUnlockDirection = null;
        ui.showUnlocked();
    }


    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);

    }

}














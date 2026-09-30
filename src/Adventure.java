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
                    ui.showDoors(doorDescrip());
                }

                case "2" -> {
                    movePlayer();
                    ui.showDoors(doorDescrip());
                }
                case "3" -> {
                    String itemName = ui.askWhichItem();

                    Item item = player.takeItem(itemName);

                    if (item != null) {
                        ui.itemPickup(item.getLongName());

                        IO.println("Inventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight());

                    } else if (player.getCurrentRoom().findItem(itemName) != null) {
                        IO.println("The item is too heavy.");

                    } else {
                        IO.println("The item is not here.");
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

                case "6" -> ui.showHealth(healthStatus());

                case "7" -> {
                    ui.showInventory(player);
                    String chosenFood = ui.itemToEat();
                    EatResult eatResult = player.eatItem(chosenFood);
                    if (eatResult.equals(EatResult.EATEN)) {
                        ui.itemEaten("You ate " + chosenFood + ". Health difference: " + (player.getHealth() - 100));
                    } else if (eatResult.equals(EatResult.NOT_FOUND)) {
                        ui.itemEaten("Item not found");
                    } else if (eatResult.equals(EatResult.NOT_FOOD)) {
                        ui.itemEaten("Item chosen is not food");
                    } else {
                        ui.itemEaten("Error");
                    }
                }
            }
        }
    }

    public String doorDescrip(){
        Room room = player.getCurrentRoom();
        IO.println(room.getDoorDescription());
        StringBuilder itemsShown = new StringBuilder();

        for (Item item : room.getItems()){
            itemsShown.append("\n" + item.getLongName());
        }
        return "You see:" + itemsShown;
    }
    
    public String healthStatus(){
        int hp = player.getHealth();
        String status;
        if (hp >=100) {
            status = "You are in perfect health condition ";
        } else if (hp >= 50) {
            status = "You are in good health condition, but avoid fighting right now ";
        } else if (hp >=25) {
            status = "You are in poor health condition, you should heal";
        } else if (hp >=0) {
            status = "You are in critical health condition, you should heal immediately";
        } else {
            status = "You are dead. ";
        }
       return "Health: " + hp + " - " + status;
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

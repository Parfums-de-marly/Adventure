public class Adventure {
    private final Map map;
    private final Player player;
    private final UserInterface ui;

    private boolean adventureIsDone = false;

    public Adventure(){
        map = new Map();
        player = new Player(map.getFirstRoom());
        ui = new UserInterface();
    }

    public void run(){
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
            }
        }
    }

    private void movePlayer() {
        String directionInput = ui.getDirection();

        switch (directionInput) {
            case "north" -> goNorth();
            case "east" -> goEast();
            case "south" -> goSouth();
            case "west" -> goWest();
        }
    }

    private void goNorth(){
        if (player.goNorth()){
            ui.showMovement("North");
            ui.showRoom(player.getCurrentRoom());
        } else {
            ui.showCannotGo("North");
        }
    }

    private void goSouth(){
        if (player.goSouth()){
            ui.showMovement("South");
            ui.showRoom(player.getCurrentRoom());
        } else {
            ui.showCannotGo("South");
        }
    }

    private void goWest(){
        if (player.goWest()){
            ui.showMovement("West");
            ui.showRoom(player.getCurrentRoom());
        } else {
            ui.showCannotGo("West");
        }
    }

    private void goEast(){
        if (player.goWest()){
            ui.showMovement("East");
            ui.showRoom(player.getCurrentRoom());
        } else {
            ui.showCannotGo("East");
        }
    }




    /*
    boolean adventureIsDone = false;
    Map map = new Map();
    Room firstRoom = map.getFirstRoom();

    public Adventure() {
    }

    public void run() {


        while (!adventureIsDone) {
            IO.println("""
                    1. Look around the room?
                    2. Go to a new room?
                    """);
            String commandInput = IO.readln("What do you wanna do? ");
            switch (commandInput) {
                case "1" -> {
                    IO.println(currentRoom.doorDescription);
                }
                case "2" -> {
                    for (int i = 0; i < 4; i++) {
                        String directionInput = IO.readln("Input Direction(north, south, east, west): ");
                        switch (directionInput) {
                            case "north" -> {
                                if (currentRoom.getNorth() != null) {
                                    currentRoom = currentRoom.getNorth();
                                    IO.println("You go: North");
                                    IO.println("You are now in " + currentRoom.name + " " + currentRoom.description);
                                } else {
                                    IO.println("You cant go North");
                                }
                            }
                            case "south" -> {
                                if (currentRoom.getSouth() != null) {
                                    currentRoom = currentRoom.getSouth();
                                    IO.println("You go: South");
                                    IO.println("You are now in " + currentRoom.name + " " + currentRoom.description);
                                } else {
                                    IO.println("You cant go: South");
                                }
                            }
                            case "east" -> {
                                if (currentRoom.getEast() != null) {
                                    currentRoom = currentRoom.getEast();
                                    IO.println("You go East");
                                    IO.println("You are now in " + currentRoom.name + " " + currentRoom.description);
                                } else {
                                    IO.println("You cant go East");
                                }
                            }
                            case "west" -> {
                                if (currentRoom.getWest() != null) {
                                    currentRoom = currentRoom.getWest();
                                    IO.println("You go West");
                                    IO.println("You are now in " + currentRoom.name + " " + currentRoom.description);
                                } else {
                                    IO.println("You cant go West");
                                }
                            }
                        }
                    }
                    IO.println(currentRoom.doorDescription);
                }
            }
        }
    }

     */
}

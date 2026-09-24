public class Adventure {
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
}

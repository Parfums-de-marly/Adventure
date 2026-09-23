public class Adventure {

    boolean adventureIsDone = false;


    public void run() {


        while (!adventureIsDone) {
            String commandInput = IO.readln("Input Direction(north, south, east, west): ");
            switch (commandInput) {
                case "north" -> {
                    IO.println("You go: North");
                }
                case "south" -> {
                    IO.println("You go: South");
                }
                case "east" -> {
                    IO.println("You go: East");
                }
                case "west" -> {
                    IO.println("You go: West");
                }
            }
        }
    }
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room room9;

    Room currentRoom;

    public Adventure(){
        room1 = new Room("Room 1", "...");
        room2 = new Room("Room 2", "...");
        room3 = new Room("Room 3", "...");
        room4 = new Room("Room 4", "...");
        room5 = new Room("Room 5", "...");
        room6 = new Room("Room 6", "...");
        room7 = new Room("Room 7", "...");
        room8 = new Room("Room 8", "...");
        room9 = new Room("Room 9", "...");

        // Forbind rooms her
        // room1.setEast(room2); sådan her måske?
    }





}

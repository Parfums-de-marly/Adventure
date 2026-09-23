public class Adventure {
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


    public Adventure(){
        room1 = new Room("Room 1", "Et lille stenkammer med kolde vægge og en flimrende fakkel.");
        room2 = new Room("Room 2", "Et snævert rum fyldt med spindelvæv og støvede kister.");
        room3 = new Room("Room 3", "En lille lysning med en gammel offersten i midten.");
        room4 = new Room("Room 4", "Et trangt bibliotek med væltede boghylder og papirer på gulvet.");
        room5 = new Room("Room 5", "Et koldt kammer dækket af rim, med et frosset vandfald i hjørnet.");
        room6 = new Room("Room 6", "En lille smedje med en rustet ambolt og kolde ovne.");
        room7 = new Room("Room 7", "Et mørkt kapel med knækkede statuer og lugten af gammelt voks.");
        room8 = new Room("Room 8", "Et lille lager fyldt med tomme tønder og en skæv lampe.");
        room9 = new Room("Room 9", "Et snævert vagtrum med en rusten rustning lænet op ad væggen.");

        // Forbind rooms her
        // room1.setEast(room2); sådan her måske?
    }





}

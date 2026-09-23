public class Adventure {
    Room room1 = new Room("Room 1", "Et lille stenkammer med kolde vægge og en flimrende fakkel.");
    Room room2 = new Room("Room 2", "Et snævert rum fyldt med spindelvæv og støvede kister.");
    Room room3 = new Room("Room 3", "En lille lysning med en gammel offersten i midten.");
    Room room4 = new Room("Room 4", "Et trangt bibliotek med væltede boghylder og papirer på gulvet.");
    Room room5 = new Room("Room 5", "Et koldt kammer dækket af rim, med et frosset vandfald i hjørnet.");
    Room room6 = new Room("Room 6", "En lille smedje med en rustet ambolt og kolde ovne.");
    Room room7 = new Room("Room 7", "Et mørkt kapel med knækkede statuer og lugten af gammelt voks.");
    Room room8 = new Room("Room 8", "Et lille lager fyldt med tomme tønder og en skæv lampe.");
    Room room9 = new Room("Room 9", "Et snævert vagtrum med en rusten rustning lænet op ad væggen.");


    Room currentRoom = room1;
    boolean adventureIsDone = false;


    public Adventure(){

        room1.setEast(room2);
        room2.setWest(room1);

        room2.setEast(room3);
        room3.setWest(room2);

        room4.setNorth(room1);
        room1.setSouth(room4);

        room3.setSouth(room6);
        room6.setNorth(room3);

        room6.setSouth(room9);
        room9.setNorth(room6);

        room9.setWest(room8);
        room8.setEast(room9);

        room8.setNorth(room5);
        room5.setSouth(room8);

        room8.setWest(room7);
        room7.setEast(room8);

        room7.setNorth(room4);
        room4.setSouth(room7);
    }

    public void run() {


        while (!adventureIsDone) {
            String commandInput = IO.readln("Input Direction(north, south, east, west): ");
            switch (commandInput) {
                case "north" -> {
                    if (currentRoom.getNorth() != null){
                        currentRoom = currentRoom.getNorth();
                        IO.println("You go: North");

                    } else {
                    IO.println("You cant go North");}
                }
                case "south" -> {
                    if (currentRoom.getSouth() != null){
                        currentRoom = currentRoom.getSouth();
                        IO.println("You go: South");
                    } else{
                    IO.println("You cant go: South");}
                }
                case "east" -> {
                    if (currentRoom.getEast() != null){
                        currentRoom = currentRoom.getEast();
                        IO.println("You go East");
                    } else {
                    IO.println("You cant go East");}
                }
                case "west" -> {
                    if (currentRoom.getWest() != null){
                        currentRoom = currentRoom.getWest();
                        IO.println("You go West");
                    } else {
                    IO.println("You cant go West");
                }}
            }
        }
    }






}

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
}

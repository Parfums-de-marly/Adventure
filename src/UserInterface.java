public class UserInterface {

    public void showMenu(){
        IO.println("""
                1. Look around the room?
                2. Go to a new room?
                """);
    }

    public String getCommand(){
        return IO.readln("What do you wanna do? ");
    }

    public String getDirection(){
        return IO.readln("Input Direction(north, south, east, west): ");
    }

    public void showRoom(Room room){
        IO.println(room.getName() + " " + room.getDescription());

    }

    public void showDoors(Room room){
        IO.println(room.getDoorDescription());
    }

    public void showMovement(String direction){
        IO.println("You go: " + direction);
    }

    public void showCannotGo(String direction){
        IO.println("You cant go: " + direction);
    }



}

public class UserInterface {

    public void showStartScreen(){
        IO.println("You wake up in a mysterious room. Small and with stone walls...\nYou see a flickering warm torch and you can't but wonder what's beyond these walls...");
    }

    public void showMenu(){
        IO.println("""
                
                1. Look around the room?
                2. Go to a new room?
                3. Pick up Item?
                4. Drop Item?
                5. View Inventory?
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

    public String askWhichItem(){
        return IO.readln("Which Item? ");
    }

    public void itemPickup(String itemName){
        IO.println("You have picked up a " + itemName);
    }

    public void itemDrop(String itemName){
        IO.println("You have picked up a " + itemName);
    }
}

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
                6. Show Health?
                7. Eat?
                """);
    }

    public String getCommand(){
        return IO.readln("What do you wanna do? ");
    }

    public String getDirection(){
        return IO.readln("Input Direction(north, south, east, west): ");
    }

    public void showRoom(Room room, boolean isTrue){
        if(isTrue){
            IO.println(room.getName());
        } else {
            IO.println(room.getName() + " " + room.getDescription());
        }
    }

    public void showInventory(Player player){
        IO.println("Inventory");

        for (Item item : player.getInventory()){
            IO.println("- " + item.getLongName());
        }
    }

    public void showHealth(String healthStatus) {
        IO.println(healthStatus);
    }

    public void showDoors(String doordescrip){
        IO.println(doordescrip);
    }

    public void showMovement(String direction){
        IO.println("You Went: " + direction);
    }

    public void showCannotGo(String direction){
        IO.println("It's Not Possible To Go: " + direction);
    }

    public String askWhichItem(){
        return IO.readln("Which Item? ");
    }

    public void itemPickup(String itemName){
        IO.println("You picked up a " + itemName);
    }

    public void itemDrop(String itemName){
        IO.println("You Dropped " + itemName);
    }

    public String itemToEat(){
        return IO.readln("What would you like to eat?: ");
    }

    public void itemEaten(String eatOutputResult) {
        IO.println(eatOutputResult);
    }
}
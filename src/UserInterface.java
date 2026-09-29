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

        for (Item item : room.getItems()){
            IO.println("You see: " + item.getLongName() + " (" + item.getShortName() + ")");
        }
    }

    public void showInventory(Player player){
        IO.println("Inventory");

        for (Item item : player.getInventory()){
            IO.println("- " + item.getLongName());
        }
    }

    public void showHealth(Player player){
        int hp = player.getHealth();
        IO.println("Health: " + hp + " - " + healthStatus(hp));
    }

    private String healthStatus(int hp) {
        if (hp >=100) {
            return "You are in perfect health condition ";
        } else if (hp >= 50) {
            return "You are in good health condition, but avoid fighting right now ";
        } else if (hp >=25) {
            return "You are in poor health condition, you should heal";
        } else if (hp >=0) {
            return "You are in critical health condition, you should heal immediately";
        } else {
            return "You are dead. ";
        }

    }


    public void showItem(Room room){
        for (Item item : room.getItems()){
            IO.println("You see: " + item.getLongName() + " (" + item.getShortName() + ")");
        }
    }
    public void showDoors(Room room){
        IO.println(room.getDoorDescription());
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
        IO.println("You picked up " + itemName);
    }

    public void itemDrop(String itemName){IO.println("You Dropped " + itemName);
    }
}

import java.util.ArrayList;
public class UserInterface {
    Adventure adventure;

    public UserInterface(){
        adventure = new Adventure();
    }

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

    public void showRoom(String text) {
        IO.println(text);
    }

    public void showInventory(ArrayList<Item> inventory) {
        IO.println("Inventory");

        for (Item item : inventory) {
            IO.println("- " + item.getLongName());
        }
    }

    public void showHealth(){
        IO.println(adventure.healthStatus());
    }

    public void showDoors(){
        IO.println(adventure.doorDescrip());
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
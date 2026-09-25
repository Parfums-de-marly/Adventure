
import java.util.ArrayList;

public class Player {
    ArrayList <Item> inventory = new ArrayList<>();
    private Room currentRoom;
    private ArrayList<Item> items;

    public Player(Room startingRoom) {
        currentRoom = startingRoom;
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        }
        return false;

    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        }
        return false;

    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return true;
        }
        return false;

    }
    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        }
        return false;

    }


    public boolean dropItem(String askWhichItem){
        for(Item item : inventory){
            if(item.getName.equalsIgnoreCase(askWhichItem)){
                inventory.remove(item);
                getCurrentRoomItems.add(item);
                return true;
            }
        }
        return false;
    }

    public boolean pickUpItem(String askWhichItem){
        for (Item item : itemList){
            if(item.getName.equalsIgnoreCase(askWhichItem)){
                getCurrentRoomItems().remove(item);
                inventory.add(item);
                return true;
            }
        }
        return false;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public ArrayList<Item> getCurrentRoomItems(ArrayList<Item> getItemList){
        return
    }

}

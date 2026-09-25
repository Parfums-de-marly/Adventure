
import java.util.ArrayList;

public class Player {
    ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom;

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


    public boolean dropItem(String askWhichItem) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(askWhichItem)) {
                inventory.remove(item);
                currentRoom.getItems().add(item);
                return true;
            }
        }
        return false;
    }

    public boolean pickUpItem(String askWhichItem) {
        for (Item item : currentRoom.getItems()) {
            if (item.getShortName().equalsIgnoreCase(askWhichItem)) {
                currentRoom.getItems().remove(item);
                inventory.add(item);
                return true;
            }
        }
        return false;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}

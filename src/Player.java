import java.util.ArrayList;

public class Player {

    private ArrayList<Item> inventory = new ArrayList<>();
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

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        }
        return false;
    }

    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }

        return null;
    }

    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);

        if (item != null) {
            currentRoom.removeItem(item);
            inventory.add(item);
            return item;
        }

        return null;
    }

    public Item dropItem(String shortName) {
        Item item = findItem(shortName);

        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);
            return item;
        }

        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
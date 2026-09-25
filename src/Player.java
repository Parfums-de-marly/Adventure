import java.util.ArrayList;

public class Player {
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

    public Room getCurrentRoom(){
        return currentRoom;
    }

}

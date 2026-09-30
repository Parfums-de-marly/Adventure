import java.lang.classfile.attribute.ModuleOpenInfo;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom;
    private int maxWeight = 6;
    private int currentWeight = 0;
    private int playerHealth = 100;

    public Player(Room startingRoom, int playerHealth) {
        currentRoom = startingRoom;
        this.playerHealth = playerHealth;
    }

    public MoveResult goNorth() {
        Room next = currentRoom.getNorth();
        if (next == null) return MoveResult.NO_DOOR;
        if (currentRoom.isNorthLocked()) return MoveResult.LOCKED;
        currentRoom = next;
        return MoveResult.MOVED;


    }

    public MoveResult goEast() {
        Room next = currentRoom.getEast();
        if(next == null) return MoveResult.NO_DOOR;
        if(currentRoom.isEastLocked()) return MoveResult.LOCKED;
        currentRoom = next;
        return MoveResult.MOVED;
    }

    public MoveResult goSouth() {
        Room next = currentRoom.getSouth();
        if(next == null) return MoveResult.NO_DOOR;
        if(currentRoom.isSouthLocked()) return MoveResult.LOCKED;
        currentRoom = next;
        return MoveResult.MOVED;
    }

    public MoveResult goWest() {
        Room next = currentRoom.getWest();
        if(next == null) return MoveResult.NO_DOOR;
        if(currentRoom.isWestLocked()) return MoveResult.LOCKED;
        currentRoom = next;
        return MoveResult.MOVED;
    }

    public boolean unlock(String direction) {
        switch (direction) {
            case "north" -> currentRoom.unlockNorth();
            case "east" -> currentRoom.unlockEast();
            case "south" -> currentRoom.unlockSouth();
            case "west" -> currentRoom.unlockWest();

        }
        return true;
    }

    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public EatResult eatItem(String shortname) {
        if (inventory.isEmpty() && currentRoom.getItems().isEmpty()) {
            return EatResult.NOT_FOUND;
        }
        for (Item item : inventory) {
            if (item.getShortName().equals(shortname)) {
                if (item instanceof Food) {

                    playerHealth += ((Food) item).getHealOrDamageAmount();
                    inventory.remove(item);
                    return EatResult.EATEN;
                }
                return EatResult.NOT_FOOD;
            }


        }
        List<Item> currentRoomItems = currentRoom.getItems();
        for (Item item : currentRoomItems){
            if(item.getShortName().equals(shortname)){
                if (item instanceof Food) {
                    playerHealth += ((Food) item).getHealOrDamageAmount();
                    currentRoomItems.remove(item);
                    return EatResult.EATEN;
            }
                return EatResult.NOT_FOOD;
            }
        }
        return EatResult.NOT_FOUND;

    }

    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);
        if (item != null) {
            boolean isOverweight = (item.getWeight() + currentWeight) > maxWeight;
            if (isOverweight) return null;
            currentRoom.removeItem(item);
            inventory.add(item);
            currentWeight += item.getWeight();
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

    public int getCurrentWeight(){
        return currentWeight;
    }

    public int getMaxWeight(){
        return maxWeight;
    }

    public int getPlayerHealth(){
        return playerHealth;
    }

   private int health = 100;

    public int getHealth() {
        return health;

    }

    public void addHealth(int points) {
        health += points;

    }
}
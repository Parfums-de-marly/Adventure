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
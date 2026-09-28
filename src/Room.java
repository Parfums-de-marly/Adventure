import java.util.ArrayList;

public class Room {
    private final String name;
    private final String description;
    private final String doorDescription;
    private final ArrayList<Item> items;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description, String doorDescription, ArrayList<Item> items) {
        this.name = name;
        this.description = description;
        this.doorDescription = doorDescription;
        this.items = items;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void setNorth(Room room) {
        if (this.north == room) return;   // allerede sat – stop rekursionen
        this.north = room;
        if (room != null) {
            room.setSouth(this);
        }
    }

    public Room getNorth() {
        return north;
    }

    public void setSouth(Room room) {
        if (this.south == room) return;
        this.south = room;
        if (room != null) {
            room.setNorth(this);
        }
    }

    public Room getSouth() {
        return south;
    }

    public void setEast(Room room) {
        if (this.east == room) return;
        this.east = room;
        if (room != null) {
            room.setWest(this);
        }
    }

    public Room getEast() {
        return east;
    }

    public void setWest(Room room) {
        if (this.west == room) return;
        this.west = room;
        if (room != null) {
            room.setEast(this);
        }
    }

    public Room getWest() {
        return west;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDoorDescription() {
        return doorDescription;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.matches(name)) {
                return item;
            }
        }
        return null;
    }

}
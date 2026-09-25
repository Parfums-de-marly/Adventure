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

    public Room(String name, String description, String doorDescription) {
        this(name, description, doorDescription, new ArrayList<>());
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void setNorth(Room room) {
        north = room;
    }

    public Room getNorth() {
        return north;
    }

    public void setEast(Room room) {
        east = room;
    }

    public Room getEast() {
        return east;
    }

    public void setSouth(Room room) {
        south = room;
    }

    public Room getSouth() {
        return south;
    }

    public void setWest(Room room) {
        west = room;
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
}
public class Room {
String name;
String description;
Room north;
Room east;
Room south;
Room west;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Room setNorth(Room room){
        return north = room;
    }

    public Room getNorth(){
        return north;
    }

    public Room setEast(Room room){
        return east = room;
    }

    public Room getEast(){
        return east;
    }

    public Room setSouth(Room room){
        return south = room;
    }

    public Room getSouth(){
        return south;
    }

    public Room setWest(Room room){
        return west = room;
    }

    public Room getWest(){
        return west;
    }

}

import java.util.ArrayList;

public class Map {
    private final ArrayList<Room> rooms;

    public Map(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public Room getFirstRoom() {
       return rooms.getFirst();
    }

}

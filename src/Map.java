import java.util.ArrayList;

public class Map {
    private final Room room1 = new Room("Room 1", "You walk into the room, it looks like a small stone chamber with cold walls and a flickering torch.", "A narrow passage leads east, while a crumbling staircase descends south.");
    private final Room room2 = new Room("Room 2", "You walk into the room, it looks like a cramped space filled with cobwebs and dusty chests.", "A cobweb-draped doorway leads west, and a faint draft hints at an opening to the east.");
    private final Room room3 = new Room("Room 3", "You walk into the room, it looks like a small clearing with an old sacrificial stone in the middle.", "A worn path leads west back into the shadows, while a dark trail winds south.");
    private final Room room4 = new Room("Room 4", "You walk into the room, it looks like a tight library with toppled bookshelves and papers scattered on the floor.", "A gap in the fallen shelves reveals a passage north, and a low archway leads south.");
    private final Room room5 = new Room("Room 5", "You walk into the room, it looks like a cold chamber covered in frost, with a frozen waterfall in the corner.", "The only way out is a frost-covered opening to the south.");
    private final Room room6 = new Room("Room 6", "You walk into the room, it looks like a small forge with a rusted anvil and cold furnaces.", "Scorched walls give way to a passage north, and a soot-stained corridor continues south.");
    private final Room room7 = new Room("Room 7", "You walk into the room, it looks like a dark chapel with broken statues and the smell of old wax.", "A cracked archway leads north, while a narrow gap beside a fallen statue opens east.");
    private final Room room8 = new Room("Room 8", "You walk into the room, it looks like a small storeroom filled with empty barrels and a crooked lamp.", "Doorways branch off in three directions — north toward the cold, west into the dark, and east where faint light spills in.");
    private final Room room9 = new Room("Room 9", "You walk into the room, it looks like a narrow guard post with a rusted suit of armor leaning against the wall.", "A rotted door creaks to the west, and a torch-lit corridor stretches north.");


    final Room firstRoom = room1;


    public Map(){
        room1.setEast(room2);
        room2.setWest(room1);

        room2.setEast(room3);
        room3.setWest(room2);

        room4.setNorth(room1);
        room1.setSouth(room4);

public class Map {
    private final ArrayList<Room> rooms;

    public Map(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public Room getFirstRoom() {
       return rooms.getFirst();
    }
    public ArrayList<Item> getItemList(){
        return room.items;
    }

}

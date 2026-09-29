import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final ArrayList<Room> rooms;
    Room startRoom;

    public Map(){
        this.rooms = buildMap();
        this.startRoom = rooms.get(0);
    }

    public ArrayList<Room> buildMap() {
        Room[] rooms_ = new Room[23];
        rooms_[1] = new Room("Room 1",  "You walk into the room, it looks like a wide entrance hall with cracked flagstones and a cold draft.", "A passage leads west back into the dark, and the hall continues east.", items(new Item("Compass", "The Golden Compass"), new Food("Apple", "A Rotten Apple", -20, "You ate a bad apple")));
        rooms_[2] = new Room("Room 2",  "You walk into the room, it looks like a narrow passage curving east, lit by a single flickering lantern.", "The passage leads west, and a way opens south.", items(new Item("Sword", "A Old Rusty Sword"), new Food("", "", 0, "")));
        rooms_[3] = new Room("Room 3",  "You walk into the room, it looks like a narrow passage curving west, damp and lined with crumbling brick.", "A path leads north up a rise, and the passage continues east.", items(new Item("Key", "A little Golde Key"), new Food("", "", 0, "")));
        rooms_[4] = new Room("Room 4",  "You walk into the room, it looks like a junction with scorch marks on the walls and the smell of smoke drifting up from below.", "Paths branch north, east, and down south into the heat.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[5] = new Room("Room 5",  "You walk into the room. It's a small, empty alcove, bare and silent. There's nothing more here.", "The only way out is west.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[6] = new Room("Room 6",  "You walk into the room, it looks like a hot, dim chamber with glowing embers scattered across the floor.", "Passages lead north, west, and further south into the glow.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[7] = new Room("Room 7",  "You walk into the room, it looks like a narrow mining tunnel shored up with old wooden beams.", "The tunnel continues east and west.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[8] = new Room("Room 8",  "You walk into the room, it looks like a low chamber choked with ash and the remains of an old fire pit.", "A passage leads north, and another opens east.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[9] = new Room("Room 9",  "You walk into the room. It's a scorched, empty dead end, nothing left but ash. There's nothing more here.", "The only way out is west.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[10] = new Room("Room 10", "You walk into the room, it looks like a cramped mining junction with rusted pickaxes leaning against the wall.", "A tunnel leads east, and a passage opens south.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[11] = new Room("Room 11", "You walk into the room, it looks like a quiet resting chamber with an old, moth-eaten bedroll in the corner.", "A passage leads north, and another continues west.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[12] = new Room("Room 12", "You walk into the room, it looks like a stone crossroads, with paths branching off in three directions.", "Paths lead west, east, and south.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[13] = new Room("Room 13", "You walk into the room, it looks like a narrow landing wedged between two staircases.", "A passage leads west, and a stairwell rises north.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[14] = new Room("Room 14", "You walk into the room, it looks like a steep stairwell chamber, its steps worn smooth by centuries of footsteps.", "The stairs continue east, and a landing lies south.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[15] = new Room("Room 15", "You walk into the room, it looks like a narrow side passage littered with broken pottery shards.", "The passage continues east and west.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[16] = new Room("Room 16", "You walk into the room. It's a bare, empty dead end, thick with dust. There's nothing more here.", "The only way out is east.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[17] = new Room("Room 17", "You walk into the room, it looks like a small landing overlooking a dark stairwell below.", "A passage leads west, and the way continues north.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[18] = new Room("Room 18", "You walk into the room, it looks like a collapsed dead-end tunnel, blocked by rubble with no way further.", "The only way out is east.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[19] = new Room("Room 19", "You walk into the room, it looks like an open crossway with passages leading off in three directions.", "Paths lead south, west, and east.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[20] = new Room("Room 20", "You walk into the room, it looks like a quiet side chamber with faded murals painted across the walls.", "The only way out is east.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[21] = new Room("Room 21", "You walk into the room, it looks like a narrow final stretch, with light spilling in from somewhere above.", "A passage leads west, and light spills down from the north.", items(new Item("", ""), new Food("", "", 0, "")));
        rooms_[22] = new Room("Room 22", "You walk into the room, it looks like a bright chamber bathed in sunlight. You've found the way out — you win!", "A passage leads back south, to the dark caves of where you came...", items(new Item("", ""), new Food("", "", 0, "")));

        Object[][] connections = {
                {16, "east", 15},
                {15, "east", 12},
                {12, "east", 13},
                {12, "south", 3},
                {14, "east", 17},
                {14, "south", 13},
                {19, "south", 17},
                {20, "east", 19},
                {19, "east", 21},
                {22, "south", 21},
                {3, "east", 1},
                {1, "east", 2},
                {2, "south", 4},
                {4, "east", 5},
                {4, "south", 6},
                {7, "east", 6},
                {10, "east", 7},
                {10, "south", 11},
                {18, "east", 11},
                {6, "south", 8},
                {8, "east", 9},

        };
        for (Object[] c : connections) {
            connect(rooms_, (int) c[0], (String) c[1], (int) c[2]);
        }
        ArrayList<Room> roomList = new ArrayList<>();
        for (int i = 1; i < rooms_.length; i++){
            roomList.add(rooms_[i]);
        }
        return roomList;
    }

    public void connect(Room[] rooms_, int a, String direction, int b){
        switch(direction){
            case "north" -> rooms_[a].setNorth(rooms_[b]);
            case "south" -> rooms_[a].setSouth(rooms_[b]);
            case "east" -> rooms_[a].setEast(rooms_[b]);
            case "west" -> rooms_[a].setWest(rooms_[b]);
        }
    }

    public ArrayList<Item> items(Item itemArray, Food food){
        return new ArrayList<>(Arrays.asList(itemArray, food));
    }


    public Room getFirstRoom() {
       return startRoom;
    }

}

void main() {
    Adventure adventure = new Adventure(buildMap());

    adventure.run();
}

public Map buildMap() {
    ArrayList<Room> rooms = new ArrayList<>();
    Map map = new Map(rooms);

    ArrayList<Item> room1Items = new ArrayList<>();
    room1Items.add(new Item("Kompas", "Det gyldne kompas"));
    Room room1 = new Room("Room 1", "You walk into the room, it looks like a small stone chamber with cold walls and a flickering torch.", "A narrow passage leads east, while a crumbling staircase descends south.", room1Items);
    Room room2 = new Room("Room 2", "You walk into the room, it looks like a cramped space filled with cobwebs and dusty chests.", "A cobweb-draped doorway leads west, and a faint draft hints at an opening to the east.");
    Room room3 = new Room("Room 3", "You walk into the room, it looks like a small clearing with an old sacrificial stone in the middle.", "A worn path leads west back into the shadows, while a dark trail winds south.");
    Room room4 = new Room("Room 4", "You walk into the room, it looks like a tight library with toppled bookshelves and papers scattered on the floor.", "A gap in the fallen shelves reveals a passage north, and a low archway leads south.");
    Room room5 = new Room("Room 5", "You walk into the room, it looks like a cold chamber covered in frost, with a frozen waterfall in the corner.", "The only way out is a frost-covered opening to the south.");
    Room room6 = new Room("Room 6", "You walk into the room, it looks like a small forge with a rusted anvil and cold furnaces.", "Scorched walls give way to a passage north, and a soot-stained corridor continues south.");
    Room room7 = new Room("Room 7", "You walk into the room, it looks like a dark chapel with broken statues and the smell of old wax.", "A cracked archway leads north, while a narrow gap beside a fallen statue opens east.");
    Room room8 = new Room("Room 8", "You walk into the room, it looks like a small storeroom filled with empty barrels and a crooked lamp.", "Doorways branch off in three directions — north toward the cold, west into the dark, and east where faint light spills in.");
    Room room9 = new Room("Room 9", "You walk into the room, it looks like a narrow guard post with a rusted suit of armor leaning against the wall.", "A rotted door creaks to the west, and a torch-lit corridor stretches north.");

    room1.setEast(room2);
    room2.setWest(room1);

    room2.setEast(room3);
    room3.setWest(room2);

    room4.setNorth(room1);
    room1.setSouth(room4);


    room3.setSouth(room6);
    room6.setNorth(room3);


    room6.setSouth(room9);
    room9.setNorth(room6);


    room9.setWest(room8);
    room8.setEast(room9);


    room8.setNorth(room5);
    room5.setSouth(room8);


    room8.setWest(room7);
    room7.setEast(room8);

    room7.setNorth(room4);
    room4.setSouth(room7);

    rooms.add(room1);
    rooms.add(room2);
    rooms.add(room3);
    rooms.add(room4);
    rooms.add(room5);
    rooms.add(room6);
    rooms.add(room7);
    rooms.add(room8);
    rooms.add(room9);

    return map;
}

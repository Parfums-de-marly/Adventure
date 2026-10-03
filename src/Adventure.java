public class Adventure {
    private final Map map;
    private final Player player;

    public Adventure() {
        this.map = new Map();
        player = new Player(map.getFirstRoom(), 100);
    }


    public String showRoom() {
        Room room = player.getCurrentRoom();
        int roomNumber = Integer.parseInt(room.getName().substring(5)) - 1;
        boolean isTrue = map.visitedRoom(roomNumber);
        if(isTrue){
            return room.getName();
        } else {
            map.setVisited(roomNumber);
            return (room.getName() + " " + room.getDescription());
        }
    }

    public String showInventory() {
        for (Item item : player.getInventory()){
            return "- " + item.getLongName();
        }
        return null;
    }


    public String pickUpItem(String askWhichItem) {
        Item item = player.takeItem(askWhichItem);
        if (item != null) {
            return item.getLongName() + "\nInventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight();

        } else if (player.getCurrentRoom().findItem(askWhichItem) != null) {
            return "The item is too heavy.";

        } else {
            return "The item is not here.";
        }
    }

    public String lookAround(){
        Room room = player.getCurrentRoom();
        for(Item items: room.getItems()){
            if(!(room.getItems().isEmpty())) {
                return room.getDoorDescription() + "\nYou look around the room and see the following: " + items.getLongName();
            } else {
                return "You look around and only see emptiness...\n" + room.getDoorDescription();
            }
        }
        return null;
    }

    public String dropItem(String itemName) {
        Item item = player.dropItem(itemName);
        if (item != null) {
            return item.getLongName() + "\nInventory Weight Used: " + player.getCurrentWeight() + "/" + player.getMaxWeight();
        } else {
            return "You don't have anything like " + itemName + " in your inventory";
        }
    }

    public String eatItem(String chosenFood) {
        EatResult eatResult = player.eatItem(chosenFood);

        if (eatResult.equals(EatResult.EATEN)) {
            return "You ate " + chosenFood + ". Health difference: " + (player.getHealth() - 100);

        } else if (eatResult.equals(EatResult.NOT_FOUND)) {
            return "Item not found";

        } else if (eatResult.equals(EatResult.NOT_FOOD)) {
            return "Item chosen is not food";

        } else {
            return "Error";
        }
    }

    public String doorDescription(){
        Room room = player.getCurrentRoom();
        IO.println(room.getDoorDescription());
        StringBuilder itemsShown = new StringBuilder();

        for (Item item : room.getItems()){
            itemsShown.append("\n" + item.getLongName());
        }
        return "You see:" + itemsShown;
    }

    public String healthStatus(){
        int hp = player.getHealth();
        String status;

        if (hp >=100) {
            status = "You are in perfect health condition ";
        } else if (hp >= 50) {
            status = "You are in good health condition, but avoid fighting right now ";
        } else if (hp >=25) {
            status = "You are in poor health condition, you should heal";
        } else if (hp >=0) {
            status = "You are in critical health condition, you should heal immediately";
        } else {
            status = "You are dead. ";
        }

        return "Health: " + hp + " - " + status;
    }

    public String attack(){
        if (player.getWeaponType().equalsIgnoreCase("RangedWeapon")) {
            return "You shot your weapon...\n" + "Magazine: " + player.getEquippedWeapon().use();
        } else {
            return "You swung your weapon...\n" + "Durability " + player.getEquippedWeapon().use();
        }
    }


    public String reload(){
        switch(player.reload()){
            case NO_WEAPON -> {
                return "You have no weapon equipped...";
            }
            case NOT_RANGED -> {
                return "You dont have any ranged weapon equipped...";
            }
            case NO_AMMO -> {
                return "There is no ammo in range nor in your inventory...";
            }
            case RELOADED -> {
                return "You reloaded your gun";
            }
            case RELOADED_EXTRA -> {
                return "You reloaded your gun... extra ammo is inventory...";
            }
        }
        return null;
    }

    public String equip(String weaponEquip){
        EquipResult equipResult = player.equip(weaponEquip);
        if(equipResult == EquipResult.EQUIPPED){
            return "You equipped " + weaponEquip;
        }
        if (equipResult == EquipResult.NOT_WEAPON){
            return "You have no such weapon in your inventory";
        }
        if (equipResult == EquipResult.NOT_FOUND){
            return "The item is not a weapon";
        }
        return null;
    }

    public String north(){
        if (player.goNorth()){
            return "You Went: North";
        } else {
            return "It's Not Possible To Go: North";
        }
    }
    public String east(){
        if (player.goEast()){
            return "You Went: East";
        } else {
            return "It's Not Possible To Go: East";
        }
    }
    public String west(){
        if (player.goWest()){
            return "You Went: West";
        } else {
            return "It's Not Possible To Go: West";
        }
    }
    public String south(){
        if (player.goSouth()){
            return "You Went: South";
        } else {
            return "It's Not Possible To Go: South";
        }
    }

}
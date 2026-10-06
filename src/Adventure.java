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

        String result = room.getName();

        if (!isTrue) {
            map.setVisited(roomNumber);
            result += " " + room.getDescription();
        }

        for (Enemy enemy : room.getEnemies()) {
            result += "\nBeware! Here lurks: " + enemy.getLongName();
        }

        return result;
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
    public String drinkItem(String chosenPotion) {
        EatResult drinkResult = player.drinkItem(chosenPotion);

        if (drinkResult.equals(EatResult.EATEN)) {
            return "You drank a " + chosenPotion + ". Updated Health: " + player.getHealth();

        } else if (drinkResult.equals(EatResult.NOT_FOUND)) {
            return "Potion not found";

        } else if (drinkResult.equals(EatResult.NOT_FOOD)) {
            return "Item chosen is not a potion";

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
        if (itemsShown.isEmpty()){
            return "You look around and only see emptiness...";
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

    public String attack(String enemyName) {
        Enemy enemy = null;

        for (Enemy e : player.getCurrentRoom().getEnemies()) {
            if (e.getShortName().equalsIgnoreCase(enemyName)) {
                enemy = e;
                break;
            }
        }

        if (enemy == null) {
            return "There is no enemy called " + enemyName + " here.";
        }

        if (player.getWeaponEquipped() == null) {
            return "You have no weapon equipped.";
        }

        player.attack(enemy);

        return "You attacked " + enemy.getLongName()
                + ". Enemy health: " + enemy.getHealth();
    }


    public String reload(){
        switch(player.reload()){
            case NO_WEAPON -> {
                return "You have no weapon equipped...";
            }
            case NOT_RANGED -> {
                return "You dont have any ranged weapon equipped...";
            }
            case MAG_FULL -> {
                return "Your mag is already full...";
            }
            case NO_AMMO -> {
                return "There is no ammo in range nor in your inventory...";
            }
            case RELOADED -> {
                return "You reloaded your gun\n" + "You currently have: " + player.getCurrentMag() + " shots in your mag";
            }
            case RELOADED_EXTRA -> {
                return "You reloaded your gun... extra ammo is inventory...\n" + "You currently have: " + player.getCurrentMag() + " shots in your mag";
            }
        }
        return "Error";
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
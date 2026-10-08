import java.util.ArrayList;

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
        StringBuilder items = new StringBuilder();
        for (Item item : player.getInventory()){
            items.append("\n" + item);
        }
        return "Inventory: " + items;
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
        int healthBefore = player.getHealth();

        EatResult eatResult = player.eatItem(chosenFood);

        if (eatResult.equals(EatResult.EATEN)) {

            int healthAfter = player.getHealth();
            int healthDifference = healthAfter - healthBefore;

            if (player.getHealth() <= 0) {
                return "You ate " + chosenFood + ". You died! Game over.";
            } else if (healthDifference < 0) {
                return "You ate " + chosenFood
                        + ". Damage taken: " + (-healthDifference)
                        + "\nCurrent Health: " + player.getHealth();
            } else {
                return "You ate " + chosenFood
                        + ". Amount healed: " + healthDifference
                        + "\nCurrent Health: " + player.getHealth();
            }

        } else if (eatResult.equals(EatResult.NOT_FOUND)) {
            return "Item not found";

        } else if (eatResult.equals(EatResult.NOT_FOOD)) {
            return "Item chosen is not food";

        } else {
            return "Error";
        }
    }

    public String drinkItem(String chosenPotion) {
        int healthBefore = player.getHealth();

        EatResult drinkResult = player.drinkItem(chosenPotion);

        if (drinkResult.equals(EatResult.EATEN)) {

            int healthAfter = player.getHealth();
            int healthDifference = healthAfter - healthBefore;

            if (player.getHealth() <= 0) {
                return "You drank " + chosenPotion + ". You died! Game over.";
            } else if (healthDifference < 0) {
                return "You drank " + chosenPotion
                        + ". Damage taken: " + (-healthDifference)
                        + "\nCurrent Health: " + player.getHealth();
            } else {
                return "You drank " + chosenPotion
                        + ". Amount healed: " + healthDifference
                        + "\nCurrent Health: " + player.getHealth();
            }

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

    public String attack() {
        Enemy enemy = null;

        if (!player.getCurrentRoom().getEnemies().isEmpty()){
            enemy = player.getCurrentRoom().getEnemies().get(0);
        }

        if (enemy == null) {
            return "You swing your weapon into the air.";
        }

        if (player.getWeaponEquipped() == null) {
            return "You have no weapon equipped.";
        }

        int healthBefore = player.getHealth();
        int enemyHealthBefore = enemy.getHealth();

        player.attack(enemy);

        int damageTaken = healthBefore - player.getHealth();
        int damageDealt = enemyHealthBefore - enemy.getHealth();

        if (enemy.getHealth() <= 0){

            return "You killed: " + enemy.getLongName() + "\nThe enemy dropped: " + enemy.getWeapon().getLongName();
        }

        if (player.getHealth() <= 0){
            return "The enemy attacked you for " + damageTaken
                    + " damage.\nYou died! Game over.";
        }

        return "You attacked " + enemy.getLongName() + "\nYou did " + damageDealt + " Damage.\n" + "Current Enemy Health: " + enemy.getHealth() + "\nThe enemy attacked you for " + damageTaken + " damage." + "\nYour health: " + player.getHealth();




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

    public boolean isPlayerDead(){
        return player.getHealth() <= 0;
    }

    public boolean checkForFinalBoss(){
        ArrayList<Enemy> enemyArrayList = player.getCurrentRoom().getEnemies();
        for (Enemy e : enemyArrayList){
            if (e.getShortName().equals(map.getFinalBoss().getShortName())){
                return true;
            }
        }
        return false;
    }

    public String north(){

        if (!checkForFinalBoss()) {
            if (player.goNorth()) {
                return "You Went: North";
            } else {
                return "It's Not Possible To Go: North";
            }
        } else {
            return "The demon guards the way out north, you must slay him!";
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
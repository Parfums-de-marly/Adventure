import java.util.ArrayList;
import java.util.List;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom;
    private int maxWeight = 100;
    private int currentWeight = 0;
    private Weapon weaponEquipped;

    public Player(Room startingRoom, int health) {
        currentRoom = startingRoom;
        this.health = health;
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        }
        return false;
    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return true;
        }
        return false;
    }

    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        }
        return false;
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        }
        return false;
    }

    public RangedWeapon ranged(){
        if((weaponEquipped instanceof RangedWeapon ranged)){
            return ranged;
        }
        return null;
    }

    public ReloadResult reload(){
        if(weaponEquipped == null) {
            return ReloadResult.NO_WEAPON;
        }
        if(!(weaponEquipped instanceof RangedWeapon ranged)){
            return ReloadResult.NOT_RANGED;
        }
        boolean ammoInInventory = false;

        Ammo ammo = null;
        for(Item items: inventory){
            if (items instanceof Ammo){
                ammo = (Ammo) items;
                ammoInInventory = true;
                break;
            }
        }
        for(Item items: getCurrentRoom().getItems()){
            if (items instanceof Ammo){
                ammo = (Ammo) items;
                break;
            }
        }
        if(ammo == null){
            return ReloadResult.NO_AMMO;
        }

        int leftover = ranged.reload(ammo.getMag());

        if(leftover == 0){
            if(ammoInInventory) {
                inventory.remove(ammo);
                currentWeight -= ammo.getWeight();
            } else {
                getCurrentRoom().removeItem(ammo);
            }
        } else {
            ammo.setMag(leftover);
            if(!ammoInInventory) {
                inventory.add(ammo);
            }
            return ReloadResult.RELOADED_EXTRA;
        }
        return ReloadResult.RELOADED;
    }

    public Weapon getWeaponEquipped(){
        return weaponEquipped;
    }
    public String getWeaponType(){
        return weaponEquipped.weaponType();
    }

    public int getCurrentMag(){
        return ranged().getCurrentMag();
    }


    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }

        return null;
    }

    public EatResult eatItem(String shortname) {
        if (inventory.isEmpty() && currentRoom.getItems().isEmpty()) {
            return EatResult.NOT_FOUND;
        }
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortname)) {
                if (item instanceof Food) {

                    health += ((Food) item).getHealOrDamageAmount();
                    inventory.remove(item);
                    return EatResult.EATEN;
                }
                return EatResult.NOT_FOOD;
            }


        }
        List<Item> currentRoomItems = currentRoom.getItems();
        for (Item item : currentRoomItems) {
            if (item.getShortName().equalsIgnoreCase(shortname)) {
                if (item instanceof Food) {
                    health += ((Food) item).getHealOrDamageAmount();
                    currentRoomItems.remove(item);
                    return EatResult.EATEN;
                }
                return EatResult.NOT_FOOD;
            }
        }
        return EatResult.NOT_FOUND;
    }

    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);
        if (item != null) {
            boolean isOverweight = (item.getWeight() + currentWeight) > maxWeight;
            if (isOverweight) return null;
            currentRoom.removeItem(item);
            inventory.add(item);
            currentWeight += item.getWeight();
            return item;
        }
        return null;
    }

    public Item dropItem(String shortName) {
        Item item = findItem(shortName);

        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);
            currentWeight -= item.getWeight();
            return item;
        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }


    private int health = 100;

    public int getHealth() {
        return health;
    }

    public void addHealth(int points) {
        health += points;
    }

    public EquipResult equip(String itemName){
        Item item = findItem(itemName);

        if (item == null){
            return EquipResult.NOT_FOUND;
        }
        if (item instanceof Weapon){
            weaponEquipped = (Weapon) item;
            return EquipResult.EQUIPPED;
        }
        return EquipResult.NOT_WEAPON;
    }

    public boolean attack(Enemy enemy){
        if (weaponEquipped == null){
            return false;
        }
        enemy.hit(weaponEquipped);
        return true;
    }

    public void teleport(Room room) {
        currentRoom = room;
    }
}


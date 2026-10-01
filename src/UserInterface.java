public class UserInterface {

    public void showStartScreen(){
        IO.println("You wake up in a mysterious room. Small and with stone walls...\nThere is an old damaged sword laying beside you, which you pick up...\nYou look in front of you and see a flickering warm torch and you can't but wonder what's beyond these walls...");
    }

    public void showMenu(){
        IO.println("""
                
                1. Look around the room?
                2. Go to a new room?
                3. Weapon
                4. Pick up Item?
                5. Drop Item?
                6. View Inventory?
                7. Show Health?
                8. Eat?
                """);
    }
    public void printWeaponMenu(){
        IO.println("""
                
                1. Attack
                2. Equip Weapon
                3. Reload
 
                """);
    }

    public String getCommand(){
        return IO.readln("What do you wanna do? ");
    }

    public String getDirection(){
        return IO.readln("Input Direction(north, south, east, west): ");
    }

    public String weaponInput(){
        return IO.readln("What do you wanna do? ");
    }

    public void showRoom(String roomDescription){
        IO.println(roomDescription);
    }

    public void showInventory(Player player){
        IO.println("Inventory");

        for (Item item : player.getInventory()){
            IO.println("- " + item.getLongName());
        }
    }

    public void showHealth(String healthStatus) {
        IO.println(healthStatus);
    }

    public void showDoors(String doordescrip){
        IO.println(doordescrip);
    }

    public void showMovement(String direction){
        IO.println("You Went: " + direction);
    }

    public void showCannotGo(String direction){
        IO.println("It's Not Possible To Go: " + direction);
    }

    public String askWhichItem(){
        return IO.readln("Which Item? ");
    }

    public void itemPickup(String itemName){
        IO.println("You picked up a " + itemName);
    }

    public void itemDrop(String itemName){
        IO.println("You Dropped " + itemName);
    }

    public String itemToEat(){
        return IO.readln("What would you like to eat?: ");
    }

    public void itemEaten(String eatOutputResult) {
        IO.println(eatOutputResult);
    }

    public String weaponToEquip(){
        return IO.readln("What weapon would you like to equip?: ");
    }

    public void weaponEquipped(String itemName) {
        IO.println("You equipped " + itemName);
    }

    public void weaponNotFound() {
        IO.println("You have no such weapon in your inventory");
    }

    public void isNotWeapon() {
        IO.println("The item is not a weapon");
    }

    public void reloadResult(String result){
        IO.println(result);
    }
}
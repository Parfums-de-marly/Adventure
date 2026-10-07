import java.util.concurrent.TimeUnit;

public class UserInterface {
    Adventure adventure = new Adventure();

    public void showStartScreen() {
        IO.println("You wake up in a mysterious room. Small and with stone walls...\nThere is an old damaged sword laying beside you, which you pick up...\nYou look in front of you and see a flickering warm torch and you can't but wonder what's beyond these walls...");
    }

    public void showMenu() {
        IO.println("""
                
                1. Look around the room?
                2. Go to a new room?
                3. Weapon
                4. Item-Menu
                5. Show Health?
                6. Exit game...
                """);
    }

    public void printWeaponMenu() {
        IO.println("""
                
                1. Attack
                2. Equip Weapon
                3. Reload
                
                """);
    }

    public void printItemMenu() {
        IO.println("""
                
                1. Pick up Item
                2. Drop Item
                3. Show Inventory
                4. Eat item
                5. Drink Potion
                
                """);
    }

    public void run() {
        boolean adventureIsDone = false;
        showStartScreen();
        /*try {
                // Pause the program for 3 seconds
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }*/
        while (!adventureIsDone) {
            showMenu();
            String commandInput = getCommand().trim().toLowerCase();

            switch (commandInput) {
                case "1" -> lookAround();
                case "2" -> movePlayer();
                case "3" -> Weapon();
                case "4" -> ItemMenu();
                case "5" -> showHealth();
                case "6" -> System.exit(0);
            }
        }
    }

    public void Weapon() {
        printWeaponMenu();
        switch (weaponInput().trim().toLowerCase()) {
            case "1" -> attack();
            case "2" -> equip();
            case "3" -> reload();
        }
    }

    public void ItemMenu(){
        printItemMenu();
        switch (itemInput().trim().toLowerCase()) {
            case "1" -> pickUpItem();
            case "2" -> dropItem();
            case "3" -> showInventory();
            case "4" -> eatItem();
            case "5" -> drinkItem();
        }
    }

    public void movePlayer(){
        String directionInput = getDirection().trim().toLowerCase();
        switch (directionInput){
            case "north" -> {
                IO.println(adventure.north());
                showRoom();
            }

            case "east" -> {
                IO.println(adventure.east());
                showRoom();
            }

            case "south" -> {
                IO.println(adventure.south());
                showRoom();
            }

            case "west" -> {
                IO.println(adventure.west());
                showRoom();
            }
        }
    }

    public void attack() {
        IO.println(adventure.attack());

        if (adventure.isPlayerDead()){
            System.exit(0);
        }
    }

    public void equip() {
        IO.println(adventure.equip(IO.readln("What weapon would you like to equip?: ")));
    }

    public void reload() {
        IO.println(adventure.reload());
    }

    public void showRoom() {
        showDoors(adventure.doorDescription());
        IO.println(adventure.showRoom());
    }

    public void lookAround(){
        IO.println(adventure.doorDescription());
    }

    public String getCommand() {
        return IO.readln("What do you wanna do? ");
    }

    public String getDirection() {
        return IO.readln("Input Direction(north, south, east, west): ");
    }

    public String weaponInput() {
        return IO.readln("What do you wanna do? ");
    }
    public String itemInput() {
        return IO.readln("What do you wanna do? ");
    }

    public void showInventory() {
        IO.println(adventure.showInventory());
    }

    public void showHealth() {
        IO.println(adventure.healthStatus());
    }

    public void showDoors(String doordescrip) {
        IO.println(doordescrip);
    }

    public void pickUpItem() {
        IO.println(adventure.pickUpItem(IO.readln("Which Item? ")));
    }

    public void dropItem() {
        showInventory();
        IO.println(adventure.dropItem(IO.readln("Which Item? ")));
    }

    public void eatItem() {
        showInventory();
        IO.println(adventure.eatItem(IO.readln("What would you like to eat? ")));

        if (adventure.isPlayerDead()) {
            System.exit(0);
        }
    }

    public void drinkItem(){
        showInventory();
        IO.println(adventure.drinkItem(IO.readln("Which item would you like to Drink? ")));
    }
}
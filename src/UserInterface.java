import java.util.concurrent.TimeUnit;

public class UserInterface {
    Adventure adventure = new Adventure();
    private boolean adventureIsDone = false;

    public void showStartScreen() {
        IO.println("You wake up in a mysterious room. Small and with stone walls...\nThere is an old damaged sword laying beside you, which you pick up...\nYou look in front of you and see a flickering warm torch and you can't but wonder what's beyond these walls...");
    }

    public void showMenu() {
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

    public void printWeaponMenu() {
        IO.println("""
                
                1. Attack
                2. Equip Weapon
                3. Reload
                
                """);
    }

    public void run() {
        while (!adventureIsDone) {
            showStartScreen();
            /*try {
                // Pause the program for 3 seconds
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }*/
            showMenu();

            String commandInput = getCommand().trim().toLowerCase();

            switch (commandInput) {
                case "1" -> showRoom();
                case "2" -> movePlayer();
                case "3" -> Weapon();
                case "4" -> pickUpItem();
                case "5" -> dropItem();
                case "6" -> showInventory();
                case "7" -> showHealth();
                case "8" -> eatItem();
            }
        }
    }

    public void Weapon() {
        switch (weaponInput().trim().toLowerCase()) {
            case "attack" -> attack();
            case "equip" -> equip();
            case "reload" -> reload();
        }
    }

    public void movePlayer(){
        String directionInput = getDirection().trim().toLowerCase();
        switch (directionInput){
            case "north" -> {
                IO.println(adventure.north());
            }

            case "east" -> {
                IO.println(adventure.east());
            }

            case "south" -> {
                IO.println(adventure.south());
            }

            case "west" -> {
                IO.println(adventure.west());
            }
        }
    }

    public attack() {

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

    public String getCommand() {
        return IO.readln("What do you wanna do? ");
    }

    public String getDirection() {
        return IO.readln("Input Direction(north, south, east, west): ");
    }

    public String weaponInput() {
        return IO.readln("What do you wanna do? ");
    }

    public void showInventory() {
        IO.println("Inventory");

        IO.println(adventure.showInventory());
    }

    public void showHealth() {
        IO.println(adventure.healthStatus());
    }

    public void showDoors(String doordescrip) {
        IO.println(doordescrip);
    }

    public void showMovement(String direction) {
        IO.println("You Went: " + direction);
    }

    public void showCannotGo(String direction) {
        IO.println("It's Not Possible To Go: " + direction);
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
        IO.println(adventure.eatItem(IO.readln("What would you like to eat?: ")));
    }
}
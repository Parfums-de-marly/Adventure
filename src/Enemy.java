public class Enemy {

    private String shortName;
    private String longName;


    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String shortName, String longName, int health, Weapon weapon, Room currentRoom){
        this.shortName = shortName;
        this.longName = longName;

        this.health = health;
        this.weapon = weapon;
        this.room = currentRoom;

    }

    public void hit(Weapon weapon){
        health -= weapon.getDamage();

        if (health < 0){
            health = 0;
        }
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }


    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isDead() {
        return health <= 0;
    }

}

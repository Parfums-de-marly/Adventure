public abstract class Weapon extends Item {
    private final int damage;

    public Weapon(String shortName, String longName, int weight, int damage) {
        super(shortName, longName, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract boolean canUse();

    public abstract int use();
}

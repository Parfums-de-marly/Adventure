public class MeleeWeapon extends Weapon {
    int durability;


    public MeleeWeapon(String shortName, String longName, int weight, int damage){
        super(shortName, longName, weight, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public int use() {
        return -1;
    }

    @Override
    public String weaponType() {
        return "MeleeWeapon";
    }

}

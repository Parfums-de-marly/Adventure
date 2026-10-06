public class RangedWeapon extends Weapon{
    private int currentMag;
    int magCapacity;
    Ammo ammo;

    public RangedWeapon(String shortName, String longName, int weight, int damage, int magCapacity, int currentMag){
        super(shortName,longName,weight,damage);
        this.currentMag = currentMag;
        this.magCapacity = magCapacity;
    }

    @Override
    public boolean canUse() {
        return currentMag > 0;
    }

    @Override
    public int use() {
        if(canUse()){
           currentMag -= 1;
        }
        return currentMag;
    }
    @Override
    public String weaponType() {
        return "RangedWeapon";
    }

    public int reload(int mag){
        int actualSpace = magCapacity - currentMag;
        if (mag <= actualSpace) {
            currentMag += mag;
            mag = 0;
        } else {
            currentMag += actualSpace;
            mag = mag - actualSpace;
        }
        return mag;
    }

    public int getCurrentMag(){
        return currentMag;
    }

}

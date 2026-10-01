import java.util.ArrayList;

public class RangedWeapon extends Weapon{
    private int currentMag;
    int magCapacity;
    Ammo ammo;

    public RangedWeapon(String shortName, String longName, int weight, int damage, int magCapacity){
        super(shortName,longName,weight,damage);
        this.currentMag = 3;
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

    public void reload(int mag){
        int result = currentMag += mag;
        if (result > magCapacity){
           int magSpace = (magCapacity-currentMag)-mag;
            mag = Math.abs(magSpace);
        }
    }

}

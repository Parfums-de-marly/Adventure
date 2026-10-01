public class Ammo {
    int mag;
    int ammoAmount;

    public Ammo(int ammoAmount){
        this.ammoAmount = ammoAmount;
    }

    public void setMagSize(){
       mag += ammoAmount;
    }
}

public class Ammo extends Item {
    int mag;
    int ammoAmount;

    public Ammo(String shortName, String longName, int weight, int ammoAmount){
        super(shortName, longName, weight);
        this.ammoAmount = ammoAmount;
        mag = ammoAmount;
    }
    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getMag(){
        return this.mag;
    }
    @Override
    public String toString(){
        if(mag <= 1) {
            return String.format("- Magazine: " + mag + " bullet");
        } else {
            return String.format("- Magazine: " + mag + " bullets");
        }
    }
}

public class Food extends Item {
private int healtPoints;

    public Food(String shortName, String longName, int weight, int healthPoints){
        super(shortName, longName, weight);
        this.healtPoints = healthPoints;
    }

    public int getHealtPoints(){
        return healtPoints;
    }


}

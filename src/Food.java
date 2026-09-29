public class Food extends Item {
private int healtPoints;
    final int healOrDamageAmount;
    final String resultmessage;

    public Food(String shortName, String longName, int weight, int healthPoints, int healOrDamageAmount, String resultmessage){
        super(shortName, longName, weight);
        this.healtPoints = healthPoints;
        this.healOrDamageAmount = healOrDamageAmount;
        this.resultmessage = resultmessage;
    }

    public int getHealtPoints(){
        return healtPoints;
    }

}

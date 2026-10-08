public class Liquid extends Consumable {
    int healAmount;

    public Liquid(String shortName, String longName, int weight, int healAmount, String resultMessage) {
        super(shortName, longName, weight, resultMessage);
        this.healAmount = healAmount;
    }

    public int getHealthAmount(){
        return healAmount;
    }
}

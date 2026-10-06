public class Liquid extends Consumable {
    int healAmount;

    public Liquid(String shortName, String longName, int weight, String resultMessage) {
        super(shortName, longName, weight, resultMessage);
    }

    public int getHealthAmount(){
        return healAmount;
    }
}

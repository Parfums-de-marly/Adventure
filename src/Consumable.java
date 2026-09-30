public class Consumable extends Item {
    String resultMessage;

    public Consumable(String shortName, String longName, int weight, String resultMessage) {
        super(shortName, longName, weight);
        this.resultMessage = resultMessage;
    }
}

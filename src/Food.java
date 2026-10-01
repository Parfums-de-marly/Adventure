public class Food extends Consumable {
    final int healOrDamageAmount;

    public Food(String shortName, String longName, int weight, int healOrDamageAmount, String resultmessage){
        super(shortName, longName, weight, resultmessage);
        this.healOrDamageAmount = healOrDamageAmount;
    }

    public int getHealOrDamageAmount(){
        return healOrDamageAmount;
    }
}
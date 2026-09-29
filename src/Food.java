public class Food extends Item {
;
    final int healOrDamageAmount;
    final String resultmessage;

    public Food(String shortName, String longName, int weight, int healOrDamageAmount, String resultmessage){
        super(shortName, longName, weight);
        this.healOrDamageAmount = healOrDamageAmount;
        this.resultmessage = resultmessage;
    }


    public int getHealOrDamageAmount(){
        return healOrDamageAmount;
    }

}

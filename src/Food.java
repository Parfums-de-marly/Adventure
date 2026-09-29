public class Food extends Item{
    final int healOrDamageAmount;
    final String resultmessage;

    public Food(String shortname, String longname, int weight, int healOrDamageAmount, String resultmessage){
        super(shortname, longname, weight);
        this.healOrDamageAmount = healOrDamageAmount;
        this.resultmessage = resultmessage;
    }

}

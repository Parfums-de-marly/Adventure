public class Food extends Item{
    final int healOrDamageAmount;
    final String resultmessage;

    public Food(String shortname, String longname, int healOrDamageAmount, String resultmessage){
        super(shortname, longname);
        this.healOrDamageAmount = healOrDamageAmount;
        this.resultmessage = resultmessage;
    }

}

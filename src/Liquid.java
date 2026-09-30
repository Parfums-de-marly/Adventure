import java.util.concurrent.TimeUnit;
public class Liquid extends Consumable {

    public Liquid(String shortName, String longName, int weight, String resultMessage) {
        super(shortName, longName, weight, resultMessage);
    }

    public void healthpotion(int health, String input){
        if(input.equalsIgnoreCase("Small Potion") || input.equalsIgnoreCase("sp")){
            health += 40;
        } else if(input.equalsIgnoreCase("Big Potion") || input.equalsIgnoreCase("bp")){
            health += 60;
        }
    }
}

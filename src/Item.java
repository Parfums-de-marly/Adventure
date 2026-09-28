public class Item {
    private String shortName;
    private String longName;
    private int weight;

    public Item(String longName) {
        this.longName = longName;
        this.shortName = extractShortName(longName);
    }


    public Item(String shortName, String longName, int weight) {
        this.shortName = shortName;
        this.longName = longName;
        this.weight = weight;
    }

    private String extractShortName(String longName) {
        if(longName == null || longName.isBlank()) {
            return "";
        }
        String[] words = longName.trim().split("\\s+");
        return words[words.length - 1].toLowerCase();
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public int getWeight(){
        return weight;
    }

    public boolean matches(String input) {
        if (input == null) {
            return false;
        }
        String typed = input.trim().toLowerCase();
        return typed.equals(shortName.toLowerCase())
                || typed.equals(longName.toLowerCase());
    }
}

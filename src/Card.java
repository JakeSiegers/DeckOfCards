import java.util.HashMap;

public class Card {
    public char suit;
    public int value;
    private static HashMap<Character,String> suits = new HashMap<>();
    private static HashMap<Integer,String> specialCardValues = new HashMap<>();

    public static HashMap<Character, String> getSuits() {
        return suits;
    }

    /**
     * Init's maps for card translation purpose. We use maps to reduce the amount of data needed to be stored in each card.
     * Notice the card class is super simple.
     *
     * This is STATIC - it will only happen the first time the class is used. Saving memory kiddos!
     */
    static {
        suits.put('s',"Spades");
        suits.put('c',"Clubs");
        suits.put('h',"Hearts");
        suits.put('d',"Diamonds");

        specialCardValues.put(1,"Ace");
        specialCardValues.put(11,"Jack");
        specialCardValues.put(12,"Queen");
        specialCardValues.put(13,"King");
    }

    /**
     * Default card will be an ace of spades...
     */
    Card(){
        this.suit = 's';
        this.value = 1;
    }

    /**
     * @param suit The character value of the suit you'd like this card to have.
     * @param value The value of this card (1-13)
     */
    Card(char suit, int value){
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the suit
     * @return char
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Returns the value
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * Translates card into a nice format. Ex: 13s => ace of spaces
     * @param card Card to translate
     * @return String
     */
    private static String translateCard(Card card){
        String cardText = "";
        int value = card.getValue();
        if(specialCardValues.containsKey(value)){
            cardText += specialCardValues.get(value);
        }else{
            cardText += value;
        }

        cardText += " of ";

        char suit = card.getSuit();
        if(suits.containsKey(suit)){
            cardText += suits.get(suit);
        }

        return cardText;
    }

    /**
     * Returns the card in a readable format.
     * @return String
     */
    public String toString(){
        return translateCard(this);
    }

}

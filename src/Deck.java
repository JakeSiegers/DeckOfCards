import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    Deck(){
        resetDeck();
    }

    /**
     * Reset's deck to "New Deck Order"
     * Will Clear out all cards, and re-add a fresh, ordered set.
     */
    private void resetDeck(){
        cards.clear();
        for(Map.Entry<Character,String> suit:Card.getSuits().entrySet()){
            for(int i=1;i<=13;i++){
                cards.add(new Card(suit.getKey(),i));
            }
        }
    }

    private void sortDeck(){

    }

    /**
     * Shuffles deck using the Collections class
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Don't trust the system (The Collecions Class)? Well Here, use a simple shuffle method I thought of.
     */
    public void sirtoShuffle(){
        //swap 2 random cards around 50 times.
        for(int i=0;i<50;i++){
            int slot1 = (int)Math.floor(Math.random()*cards.size());
            int slot2 = (int)Math.floor(Math.random()*cards.size());
            //Hold the first card off to the side
            Card card1 = cards.get(slot1);
            //Move card 2 to card 1
            cards.set(slot1,cards.get(slot2));
            //Put card 1 where card 2 was.
            cards.set(slot2,card1);
        }
    }



    /**
     * Prints out the deck in a readable format
     * @return String
     */
    public String toString(){
        String out = "";
        for(int i=0;i<cards.size();i++){
            out+=cards.get(i)+"\n";
        }
        return out;
    }
}

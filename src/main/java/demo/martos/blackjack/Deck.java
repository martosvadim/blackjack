package demo.martos.blackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Deck implements Iterable<Card> {

    private static final int CAPACITY = 52;

    private Collection<Card> cards;

    public Deck() {
        cards = new ArrayList<>(CAPACITY);
        //init cards here
    }

    public void shuffle() {
        //shuffle cards here
    }

    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}

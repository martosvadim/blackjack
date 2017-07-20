package demo.martos.blackjack;

import java.util.Iterator;

public class Dealer extends Player {

    private static final int SCORE_LIMIT = 17;

    private Deck deck;

    private Card nextCard() {
        Iterator<Card> iterator = deck.iterator();
        if (!iterator.hasNext()) {
            changeDeck();
            iterator = deck.iterator();
        }
        Card c = iterator.next();
        iterator.remove();
        return c;
    }

    private void changeDeck() {
        this.deck = new Deck();
    }

    public void shuffleDesk() {
        this.deck.shuffle();
    }

    public void deal(Player player) {
        Card card = nextCard();
        player.offer(card);
        if (player != this) {
            card.flip();
        }
        card = nextCard();
        player.offer(card);
        card.flip();
    }

    public void askForACard(Player player) {
        Card card = nextCard();
        player.offer(card);
        card.flip();
    }

    @Override
    public void play(Dealer dealer) {
        hand.forEach(Card::flip); //flips the second card
        while (score() < SCORE_LIMIT) {
            if (true) {  //ask dealer through UI to hit or to stay
                dealer.askForACard(this); //hit
            } else {
                return; //or stay
            }
        }
    }
}

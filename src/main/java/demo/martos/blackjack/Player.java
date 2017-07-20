package demo.martos.blackjack;

import java.util.ArrayList;
import java.util.Collection;

public class Player {

    private static final int SCORE_LIMIT = 21;

    protected Collection<Card> hand;
    protected int money;

    public void offer(Card card) {
        hand.add(card);
    }

    protected int score() {
        int score = 0;
        for (Card card : hand) {
            if (card.isAce()) {
                score += chooseAceValue();
            } else {
                score += card.value();
            }
        }
        return score;
    }

    private int chooseAceValue() {
        if (true) { //ask player through UI to choose the value for Ace
            return 1;
        } else {
            return 11;
        }
    }

    public void play(Dealer dealer) {
        while (score() < SCORE_LIMIT) {
            if (true) { //ask player through UI to hit or to stay
                dealer.askForACard(this); //hit
            } else {
                return; //or stay
            }
        }
    }

    public void check(Dealer dealer) {
        int score = score();
        if (score > dealer.score() && score <= SCORE_LIMIT) {
            win(dealer);
        } else {
            loose(dealer);
        }
        dropHands();
    }

    private void win(Dealer dealer) {
        dealer.money -= this.money;
        this.money += this.money;
    }

    private void loose(Dealer dealer) {
        dealer.money += this.money;
        this.money = 0;
    }

    public void dropHands() {
        this.hand = new ArrayList<>();
    }
}

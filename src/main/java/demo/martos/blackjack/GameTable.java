package demo.martos.blackjack;

import java.util.ArrayList;
import java.util.Collection;

public class GameTable {

    private Dealer dealer;
    private Collection<Player> players;

    public GameTable() {
        dealer = new Dealer();
        players = new ArrayList<>();
        //initialize dealer and players here
    }

    public void playRound() {
        dealer.shuffleDesk();

        players.forEach(p -> dealer.deal(p));
        dealer.deal(dealer);

        players.stream().forEach(p -> p.play(dealer));
        dealer.play(dealer);

        players.forEach(p -> p.check(dealer));
        dealer.dropHands();
    }
}

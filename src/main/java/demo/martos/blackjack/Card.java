package demo.martos.blackjack;

public class Card {

    private Name name;
    private boolean faceDown = true;

    public Card(Name name) {
        this.name = name;
    }

    public int value() {
        return name.value;
    }

    public void flip() {
        faceDown = false;
    }

    public boolean isAce() {
        return name == Name.ACE;
    }

    public enum Name {
        TWO(2),
        THREE(3),
        //...
        ACE(1);

        Name(int value) {
            this.value = value;
        }

        private int value;
    }
}

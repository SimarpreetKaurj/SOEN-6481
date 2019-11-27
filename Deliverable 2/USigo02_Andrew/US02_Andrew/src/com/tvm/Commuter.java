package com.tvm;

public class Commuter {
    private int cash = 15;

    public int getCash() {
        return cash;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    Card card = new Card();
}

package com.mancala.domain;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Player {

    public static final int NUMBER_OF_STONES_PER_HOUSE = 6;

    private Houses houses = new Houses(NUMBER_OF_STONES_PER_HOUSE);
    private Mancala mancala = new Mancala();
    private int houseIndex = -1;
    private boolean turn = false;
    private boolean win = false;

    public Houses getHouses() {
        return houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public Mancala getMancala() {
        return mancala;
    }

    public void setMancala(Mancala mancala) {
        this.mancala = mancala;
    }

    public int getHouseIndex() {
        return houseIndex;
    }

    public void setHouseIndex(int houseIndex) {
        this.houseIndex = houseIndex;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}

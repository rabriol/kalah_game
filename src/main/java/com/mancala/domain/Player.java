package com.mancala.domain;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Player {

    public static final int NUMBER_OF_HOUSES = 6;
    public static final int NUMBER_OF_STONES_PER_HOUSE = 6;

    private Houses houses = new Houses(NUMBER_OF_HOUSES, NUMBER_OF_STONES_PER_HOUSE);
    private int mancala = 0;
    private int houseIndex = -1;

    public Houses getHouses() {
        return houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public int getMancala() {
        return mancala;
    }

    public void setMancala(int mancala) {
        this.mancala = mancala;
    }

    public int getHouseIndex() {
        return houseIndex;
    }

    public void setHouseIndex(int houseIndex) {
        this.houseIndex = houseIndex;
    }
}

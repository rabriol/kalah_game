package com.mancala.domain;

import java.util.Arrays;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Cups {
    public static final int NUMBER_OF_CUPS = 6;
    public static final int ZERO = 0;

    private int[] cups;

    public Cups(int stonesPerCup) {
        cups = new int[NUMBER_OF_CUPS];

        for (int i = ZERO; i < NUMBER_OF_CUPS; i++) {
            cups[i] = stonesPerCup;
        }
    }

    public int getStones(int index) {
        return cups[index];
    }

    public void clearStones(int index) {
        cups[index] = 0;
    }

    public void clearAllStones() {
        for (int i = ZERO; i < NUMBER_OF_CUPS; i++) {
            cups[i] = ZERO;
        }
    }

    public int getAllStones() {
        int stones = 0;
        for (int i = 0; i < cups.length; i++) {
            stones += cups[i];
        }

        return stones;
    }

    public int size() {
        return NUMBER_OF_CUPS;
    }

    public boolean isEmpty(int index) {
        return cups[index] == 0;
    }

    public void increment(int index) {
        int stones = cups[index];
        cups[index] = ++stones;
    }

    public void setHouse(int[] houses) {
        this.cups = houses;
    }

    @Override
    public String toString() {
        return "Cups{" +
                "cups=" + Arrays.toString(cups) +
                '}';
    }
}

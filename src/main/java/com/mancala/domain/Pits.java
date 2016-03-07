package com.mancala.domain;

import java.util.Arrays;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Pits {
    public static final int NUMBER_OF_PITS = 6;
    public static final int ZERO = 0;

    private int[] pits;

    public Pits(int stonesPerPit) {
        pits = new int[NUMBER_OF_PITS];

        for (int i = ZERO; i < NUMBER_OF_PITS; i++) {
            pits[i] = stonesPerPit;
        }
    }

    public int getStones(int index) {
        return pits[index];
    }

    public void clearStones(int index) {
        pits[index] = 0;
    }

    public void clearAllStones() {
        for (int i = ZERO; i < NUMBER_OF_PITS; i++) {
            pits[i] = ZERO;
        }
    }

    public int getAllStones() {
        int stones = 0;
        for (int i = 0; i < pits.length; i++) {
            stones += pits[i];
        }

        return stones;
    }

    public int size() {
        return NUMBER_OF_PITS;
    }

    public boolean isEmpty(int index) {
        return pits[index] == 0;
    }

    public void increment(int index) {
        int stones = pits[index];
        pits[index] = ++stones;
    }

    public void setPit(int[] pits) {
        this.pits = pits;
    }

    @Override
    public String toString() {
        return "Pits{" +
                "pits=" + Arrays.toString(pits) +
                '}';
    }
}

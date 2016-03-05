package com.mancala.domain;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Houses {
    public static final int NUMBER_OF_HOUSES = 6;
    public static final int ZERO = 0;

    private int[] houses;

    public Houses(int stones) {
        houses = new int[NUMBER_OF_HOUSES];

        for (int i = ZERO; i < NUMBER_OF_HOUSES; i++) {
            houses[i] = stones;
        }
    }

    public int get(int index) {
        return houses[index];
    }

    public void clear(int index) {
        houses[index] = 0;
    }

    public int size() {
        return NUMBER_OF_HOUSES;
    }

    public boolean isEmpty(int index) {
        return houses[index] == 0;
    }

    public void increment(int index) {
        int stones = houses[index];
        houses[index] = stones++;
    }
}

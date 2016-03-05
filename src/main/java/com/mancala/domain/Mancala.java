package com.mancala.domain;

/**
 * Created by brito on 3/5/16.
 */
public class Mancala {
    private int stones = 0;

    public void increment() {
        stones++;
    }

    public void add(int stones) {
        this.stones += stones;
    }
}

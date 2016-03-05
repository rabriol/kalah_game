package com.mancala.logic;

import com.mancala.domain.Player;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class GameBoard {

    public static final int ZERO = 0;
    public static final int ONE = 1;

    public void doMovement(int houseIndex, Player actual, Player opponent) {
        int stones = actual.getHouses().get(houseIndex);

        actual.getHouses().clear(houseIndex);

        int actualIndex = houseIndex;

        while (actualIndex < actual.getHouses().size()) {
            actual.getHouses().increment(++actualIndex);
            --stones;

            if (stones == ZERO && actual.getHouses().get(actualIndex) == ONE) {
                actual.getMancala().add(actual.getHouses().get(actualIndex));
                actual.getMancala().add(opponent.getHouses().get(actualIndex + (opponent.getHouses().size()-ONE)));

                actual.getHouses().clear(actualIndex);
                opponent.getHouses().clear(actualIndex + (opponent.getHouses().size()-ONE));
            }
        }

        if (stones != ZERO) {
            actual.getMancala().increment();
            --stones;

            if (stones == ZERO && actual.getHouses().get(actualIndex) == ONE) {
                actual.setTurn(Boolean.TRUE);
            } else {
                actual.setTurn(Boolean.TRUE);
            }
        }

        if (stones != ZERO) {
            for (int i = ZERO, j = (opponent.getHouses().size()-ONE); i < stones; i++) {
                opponent.getHouses().increment(j);
                i++;
            }
        }
    }
}

package com.mancala.logic;

import com.mancala.domain.Player;
import org.springframework.stereotype.Service;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
@Service
public class GameBoard {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int REINITIALIZE_INDEX = -1;

    public void doMovement(int index, Player actual, Player opponent) {


        int stones = actual.getCups().getStones(index);
        actual.getCups().clearStones(index);

        if (allotStones(index, actual, opponent, stones)) {
            return;
        }

        opponent.makePlay();
        actual.makeWait();
    }

    private boolean allotStones(int index, Player actual, Player opponent, int stones) {
        while (index < actual.getCups().size()-ONE && stones != ZERO) {
            stones--;
            actual.getCups().increment(++index);

            if (checkIfActualGetFromOpponent(index, actual, stones)) {
                actual.getMancala().add(actual.getCups().getStones(index));
                actual.getMancala().add(opponent.getCups().getStones((opponent.getCups().size() - ONE) - index));

                actual.getCups().clearStones(index);
                opponent.getCups().clearStones((opponent.getCups().size() - ONE) - index);

                actual.makeWait();
                opponent.makePlay();

                return true;
            }
        }

        if (stones != ZERO) {
            actual.getMancala().increment();
            stones--;

            if (stones == ZERO) {
                actual.makePlay();
                opponent.makeWait();

                return true;
            }
        }

        if (stones != ZERO) {
            for (int i = opponent.getCups().size()-ONE; i >= ZERO && stones != ZERO; i--) {
                stones--;
                opponent.getCups().increment(i);
            }
        }

        if (stones != ZERO) {
            return allotStones(REINITIALIZE_INDEX, actual, opponent, stones);
        }

        return false;
    }

    private boolean checkIfActualGetFromOpponent(int index, Player actual, int stones) {
        return stones == ZERO && actual.getCups().getStones(index) == ONE;
    }
}

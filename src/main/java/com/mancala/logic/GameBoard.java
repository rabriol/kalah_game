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

    /**
     * Do all movements rules, including:
     * <ul>
     *  <li>distributing stones along the board and mancala's player</li>
     *  <li>controlling player's turn</li>
     *  <li>checking if actual player should get stones from opponent</li>
     * <ul/>
     * @param index indicates which cups to read to get the stones
     * @param actual indicates the current player which is playing
     * @param opponent indicates the opponent of actual player
     */
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
        //start distributing stones on actual player cups
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

        //if there is stones yet it increments the actual player mancala
        if (stones != ZERO) {
            actual.getMancala().increment();
            stones--;

            if (stones == ZERO) {
                actual.makePlay();
                opponent.makeWait();

                return true;
            }
        }

        //if there is stones yet it distributes stones on opponent board
        if (stones != ZERO) {
            for (int i = ZERO; i < opponent.getCups().size() && stones != ZERO; i++) {
                stones--;
                opponent.getCups().increment(i);
            }
        }

        //when there is more stones than cups and mancalas, this part is executed to distribute the rest of stones
        // again to the actual player
        if (stones != ZERO) {
            return allotStones(REINITIALIZE_INDEX, actual, opponent, stones);
        }

        return false;
    }

    private boolean checkIfActualGetFromOpponent(int index, Player actual, int stones) {
        return stones == ZERO && actual.getCups().getStones(index) == ONE;
    }
}

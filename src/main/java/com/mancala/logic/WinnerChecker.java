package com.mancala.logic;

import com.mancala.domain.Player;
import org.springframework.stereotype.Service;

/**
 * Created by brito on 3/5/16.
 */
@Service
public class WinnerChecker {

    private static final int ZERO = 0;

    /**
     * Verifies if anyone has won, this is reached when there is no more stones left on some the board's side.
     * And it verifies who has won and summarize all stones that everybody has acquired during the game.
     * @param actual
     * @param opponent
     */
    public void check(Player actual, Player opponent) {
        int stonesP1 = actual.getPits().getAllStones();
        int stonesP2 = opponent.getPits().getAllStones();

        if (stonesP1 == ZERO || stonesP2 == ZERO) {
            actual.getKalah().add(stonesP1);
            opponent.getKalah().add(stonesP2);

            if (actual.getKalah().size() > opponent.getKalah().size()) {
                actual.makeWinner();
                actual.getPits().clearAllStones();
                opponent.getPits().clearAllStones();
            } else {
                opponent.makeWinner();
                opponent.getPits().clearAllStones();
                actual.getPits().clearAllStones();
            }
        }
    }
}

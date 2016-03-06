package com.mancala.logic;

import com.mancala.domain.Player;
import org.springframework.stereotype.Service;

/**
 * Created by brito on 3/5/16.
 */
@Service
public class WinnerChecker {

    private static final int ZERO = 0;

    public void check(Player p1, Player p2) {
        int stonesP1 = p1.getCups().getAllStones();
        int stonesP2 = p2.getCups().getAllStones();

        if (stonesP1 == ZERO || stonesP2 == ZERO) {
            p1.getMancala().add(stonesP1);
            p2.getMancala().add(stonesP2);

            if (p1.getMancala().size() > p2.getMancala().size()) {
                p1.makeWinner();
                p1.getCups().clearAllStones();
            } else {
                p2.makeWinner();
                p2.getCups().clearAllStones();
            }
        }
    }
}

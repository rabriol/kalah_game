package com.mancala.logic;

import com.mancala.domain.Cups;
import com.mancala.domain.Mancala;
import com.mancala.domain.Player;
import com.mancala.domain.PlayerId;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brito on 3/5/16.
 */
public class GameBoardTest {

    @Test
    public void testFirstMovement() throws Exception {
        Player actual = new Player(new Cups(6), new Mancala(), PlayerId.PLAYER_ONE);
        Player opponent = new Player(new Cups(6), new Mancala(), PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(1, actual, opponent);

        assertTrue(actual.getCups().isEmpty(1));

        assertTrue(actual.getCups().getStones(2) == 7);
        assertTrue(actual.getCups().getStones(4) == 7);
        assertTrue(actual.getCups().getStones(5) == 7);
        assertTrue(actual.getCups().getStones(5) == 7);
        assertTrue(opponent.getCups().getStones(4) == 6);

        assertTrue(actual.getMancala().size() == 1);

        assertFalse(actual.canPlay());
        assertTrue(opponent.canPlay());
    }

    @Test
    public void testWhenIsPlayerTurnAgainByLastStoneInCup() throws Exception {
        Player actual = new Player(new Cups(6), new Mancala(), PlayerId.PLAYER_ONE);
        Player opponent = new Player(new Cups(6), new Mancala(), PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(0, actual, opponent);

        assertTrue(actual.getCups().isEmpty(0));

        assertTrue(actual.getCups().getStones(1) == 7);
        assertTrue(actual.getCups().getStones(2) == 7);
        assertTrue(actual.getCups().getStones(4) == 7);
        assertTrue(actual.getCups().getStones(5) == 7);
        assertTrue(actual.getCups().getStones(5) == 7);
        assertTrue(opponent.getCups().getStones(5) == 6);

        assertTrue(actual.getMancala().size() == 1);

        assertTrue(actual.canPlay());
        assertFalse(opponent.canPlay());
    }

    @Test
    public void testWhenActualGetStonesFromOpponent() throws Exception {
        Cups cupsActual = new Cups(6);
        int[] housesActual = new int[]{1, 0, 8, 8, 8, 8};
        cupsActual.setHouse(housesActual);
        Mancala mancalaActual = new Mancala();
        mancalaActual.add(2);
        Player actual = new Player(cupsActual, mancalaActual, PlayerId.PLAYER_ONE);

        Cups cupsOpponent = new Cups(6);
        int[] housesOpponent = new int[]{1, 0, 9, 9, 8, 8};
        cupsOpponent.setHouse(housesOpponent);
        Mancala mancalaOpponent = new Mancala();
        mancalaOpponent.add(2);
        Player opponent = new Player(cupsOpponent, mancalaOpponent, PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(0, actual, opponent);

        assertTrue(actual.getCups().isEmpty(0));
        assertTrue(actual.getCups().isEmpty(1));

        assertTrue(actual.getCups().getStones(2) == 8);
        assertTrue(actual.getCups().getStones(3) == 8);
        assertTrue(actual.getCups().getStones(4) == 8);
        assertTrue(actual.getCups().getStones(5) == 8);

        assertTrue(opponent.getCups().isEmpty(1));
        assertTrue(opponent.getCups().isEmpty(4));

        assertTrue(opponent.getCups().getStones(0) == 1);
        assertTrue(opponent.getCups().getStones(2) == 9);
        assertTrue(opponent.getCups().getStones(3) == 9);
        assertTrue(opponent.getCups().getStones(5) == 8);

        assertTrue(actual.getMancala().size() == 11);
        assertTrue(opponent.getMancala().size() == 2);

        assertFalse(actual.canPlay());
        assertTrue(opponent.canPlay());
    }

    @Test
    public void testWhenActualGetStonesFromOpponentAnotherScenario() throws Exception {
        Cups cupsActual = new Cups(6);
        int[] housesActual = new int[]{0, 7, 7, 7, 7, 8};
        cupsActual.setHouse(housesActual);
        Mancala mancalaActual = new Mancala();
        mancalaActual.add(1);
        Player actual = new Player(cupsActual, mancalaActual, PlayerId.PLAYER_ONE);

        Cups cupsOpponent = new Cups(6);
        int[] housesOpponent = new int[]{6, 0, 7, 7, 7, 7};
        cupsOpponent.setHouse(housesOpponent);
        Mancala mancalaOpponent = new Mancala();
        mancalaOpponent.add(1);
        Player opponent = new Player(cupsOpponent, mancalaOpponent, PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(5, actual, opponent);

        assertTrue(actual.getCups().isEmpty(0));
        assertTrue(actual.getCups().isEmpty(5));

        assertTrue(actual.getCups().getStones(1) == 7);
        assertTrue(actual.getCups().getStones(2) == 7);
        assertTrue(actual.getCups().getStones(3) == 7);
        assertTrue(actual.getCups().getStones(4) == 7);

        assertTrue(opponent.getCups().isEmpty(5));

        assertTrue(opponent.getCups().getStones(0) == 7);
        assertTrue(opponent.getCups().getStones(1) == 1);
        assertTrue(opponent.getCups().getStones(2) == 8);
        assertTrue(opponent.getCups().getStones(3) == 8);
        assertTrue(opponent.getCups().getStones(4) == 8);

        assertTrue(actual.getMancala().size() == 11);
        assertTrue(opponent.getMancala().size() == 1);

        assertFalse(actual.canPlay());
        assertTrue(opponent.canPlay());
    }
}
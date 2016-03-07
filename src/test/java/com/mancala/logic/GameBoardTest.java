package com.mancala.logic;

import com.mancala.domain.Pits;
import com.mancala.domain.Kalah;
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
        Player actual = new Player(new Pits(6), new Kalah(), PlayerId.PLAYER_ONE);
        Player opponent = new Player(new Pits(6), new Kalah(), PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(1, actual, opponent);

        assertTrue(actual.getPits().isEmpty(1));

        assertTrue(actual.getPits().getStones(2) == 7);
        assertTrue(actual.getPits().getStones(4) == 7);
        assertTrue(actual.getPits().getStones(5) == 7);
        assertTrue(actual.getPits().getStones(5) == 7);
        assertTrue(opponent.getPits().getStones(4) == 6);

        assertTrue(actual.getKalah().size() == 1);

        assertFalse(actual.canPlay());
        assertTrue(opponent.canPlay());
    }

    @Test
    public void testWhenIsPlayerTurnAgainByLastStoneInpit() throws Exception {
        Player actual = new Player(new Pits(6), new Kalah(), PlayerId.PLAYER_ONE);
        Player opponent = new Player(new Pits(6), new Kalah(), PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(0, actual, opponent);

        assertTrue(actual.getPits().isEmpty(0));

        assertTrue(actual.getPits().getStones(1) == 7);
        assertTrue(actual.getPits().getStones(2) == 7);
        assertTrue(actual.getPits().getStones(4) == 7);
        assertTrue(actual.getPits().getStones(5) == 7);
        assertTrue(actual.getPits().getStones(5) == 7);
        assertTrue(opponent.getPits().getStones(5) == 6);

        assertTrue(actual.getKalah().size() == 1);

        assertTrue(actual.canPlay());
        assertFalse(opponent.canPlay());
    }

    @Test
    public void testWhenActualGetStonesFromOpponent() throws Exception {
        Pits pitsActual = new Pits(6);
        int[] housesActual = new int[]{1, 0, 8, 8, 8, 8};
        pitsActual.setPit(housesActual);
        Kalah kalahActual = new Kalah();
        kalahActual.add(2);
        Player actual = new Player(pitsActual, kalahActual, PlayerId.PLAYER_ONE);

        Pits pitsOpponent = new Pits(6);
        int[] housesOpponent = new int[]{1, 0, 9, 9, 8, 8};
        pitsOpponent.setPit(housesOpponent);
        Kalah kalahOpponent = new Kalah();
        kalahOpponent.add(2);
        Player opponent = new Player(pitsOpponent, kalahOpponent, PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(0, actual, opponent);

        assertTrue(actual.getPits().isEmpty(0));
        assertTrue(actual.getPits().isEmpty(1));

        assertTrue(actual.getPits().getStones(2) == 8);
        assertTrue(actual.getPits().getStones(3) == 8);
        assertTrue(actual.getPits().getStones(4) == 8);
        assertTrue(actual.getPits().getStones(5) == 8);

        assertTrue(opponent.getPits().isEmpty(1));
        assertTrue(opponent.getPits().isEmpty(4));

        assertTrue(opponent.getPits().getStones(0) == 1);
        assertTrue(opponent.getPits().getStones(2) == 9);
        assertTrue(opponent.getPits().getStones(3) == 9);
        assertTrue(opponent.getPits().getStones(5) == 8);

        assertTrue(actual.getKalah().size() == 11);
        assertTrue(opponent.getKalah().size() == 2);

        assertFalse(actual.canPlay());
        assertTrue(opponent.canPlay());
    }

    @Test
    public void testWhenActualGetStonesFromOpponentAnotherScenario() throws Exception {
        Pits pitsActual = new Pits(6);
        int[] housesActual = new int[]{0, 7, 7, 7, 7, 8};
        pitsActual.setPit(housesActual);
        Kalah kalahActual = new Kalah();
        kalahActual.add(1);
        Player actual = new Player(pitsActual, kalahActual, PlayerId.PLAYER_ONE);

        Pits pitsOpponent = new Pits(6);
        int[] housesOpponent = new int[]{6, 0, 7, 7, 7, 7};
        pitsOpponent.setPit(housesOpponent);
        Kalah kalahOpponent = new Kalah();
        kalahOpponent.add(1);
        Player opponent = new Player(pitsOpponent, kalahOpponent, PlayerId.PLAYER_TWO);

        new GameBoard().doMovement(5, actual, opponent);

        assertTrue(actual.getPits().isEmpty(0));
        assertTrue(actual.getPits().isEmpty(5));

        assertTrue(actual.getPits().getStones(1) == 7);
        assertTrue(actual.getPits().getStones(2) == 7);
        assertTrue(actual.getPits().getStones(3) == 7);
        assertTrue(actual.getPits().getStones(4) == 7);

        assertTrue(opponent.getPits().isEmpty(5));

        assertTrue(opponent.getPits().getStones(0) == 7);
        assertTrue(opponent.getPits().getStones(1) == 1);
        assertTrue(opponent.getPits().getStones(2) == 8);
        assertTrue(opponent.getPits().getStones(3) == 8);
        assertTrue(opponent.getPits().getStones(4) == 8);

        assertTrue(actual.getKalah().size() == 11);
        assertTrue(opponent.getKalah().size() == 1);

        assertFalse(actual.canPlay());
        assertTrue(opponent.canPlay());
    }
}
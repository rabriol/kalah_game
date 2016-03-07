package com.mancala.domain;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Player {
    private final Pits pits;
    private final Kalah kalah;
    private final PlayerId playerId;

    private Boolean turn = Boolean.FALSE;
    private Boolean winner = Boolean.FALSE;

    public Player(Pits pits, Kalah kalah, PlayerId playerId) {
        this.pits = pits;
        this.kalah = kalah;
        this.playerId = playerId;
    }

    public Pits getPits() {
        return pits;
    }

    public Kalah getKalah() {
        return kalah;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Boolean hasWin() {
        return winner;
    }

    public void makeLooser() {
        winner = Boolean.FALSE;
    }

    public void makeWinner() {
        winner = Boolean.TRUE;
    }

    public void makePlay() {
        turn = Boolean.TRUE;
    }

    public void makeWait() {
        turn = Boolean.FALSE;
    }

    public Boolean canPlay() {
        return turn;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pits=" + pits +
                ", kalah=" + kalah +
                ", playerId=" + playerId +
                ", turn=" + turn +
                ", winner=" + winner +
                '}';
    }
}

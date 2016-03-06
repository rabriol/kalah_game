package com.mancala.domain;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
public class Player {
    private final Cups cups;
    private final Mancala mancala;
    private final PlayerId playerId;

    private Boolean turn = Boolean.FALSE;
    private Boolean winner = Boolean.FALSE;

    public Player(Cups cups, Mancala mancala, PlayerId playerId) {
        this.cups = cups;
        this.mancala = mancala;
        this.playerId = playerId;
    }

    public Cups getCups() {
        return cups;
    }

    public Mancala getMancala() {
        return mancala;
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
                "cups=" + cups +
                ", mancala=" + mancala +
                ", playerId=" + playerId +
                ", turn=" + turn +
                ", winner=" + winner +
                '}';
    }
}

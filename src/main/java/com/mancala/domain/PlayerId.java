package com.mancala.domain;

/**
 * Created by brito on 3/5/16.
 */
public enum PlayerId {
    PLAYER_ONE("p1", "1"),
    PLAYER_TWO("p2", "2");

    private String value;
    private String number;

    PlayerId(String value, String number) {
        this.value = value;
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public String getNumber() {
        return number;
    }

    public static PlayerId get(String player) {
        for (PlayerId playerId : PlayerId.values()) {
            if (playerId.getValue().equalsIgnoreCase(player)) {
                return playerId;
            }
        }
        throw new IllegalArgumentException("playerId not found based on " + player);
    }

    @Override
    public String toString() {
        return "PlayerId{" +
                "value='" + value + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

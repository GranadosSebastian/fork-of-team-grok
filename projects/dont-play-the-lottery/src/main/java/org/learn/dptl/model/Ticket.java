package org.learn.dptl.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Ticket {

    private Set<Integer> whiteBalls;
    private int powerBall;
    private static final Random RANDOM = new Random();

    /**
     * Constructor for generating random number
     */
    public Ticket() {
        whiteBalls = new HashSet<>();
        while(whiteBalls.size() < 6) {
            whiteBalls.add(RANDOM.nextInt(70));
        }
        powerBall = RANDOM.nextInt(1,27);
    }

    /**
     * Constructor for non-quickpick option (player-specific)
     * @param whiteBalls - Whiteball numbers picked by the player
     * @param powerBall - Powerball number picked by the player
     */
    public Ticket(Set<Integer> whiteBalls, int powerBall) {
        this.whiteBalls = whiteBalls;
        this.powerBall = powerBall;
    }

    public Set<Integer> getWhiteBalls() {
        return new HashSet<>(whiteBalls);
    }

    private void setWhiteBalls(Set<Integer> whiteBalls) {
        this.whiteBalls = whiteBalls;
    }

    public int getPowerBall() {
        return powerBall;
    }

    public void setPowerBall(int powerBall) {
        this.powerBall = powerBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket draft = (Ticket) o;
        return powerBall == draft.powerBall && Objects.equals(whiteBalls, draft.whiteBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteBalls, powerBall);
    }

    @Override
    public String toString() {
        return "Draft{" +
                "whiteBalls=" + whiteBalls +
                ", powerBall=" + powerBall +
                '}';
    }
}

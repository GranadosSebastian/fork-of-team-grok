package org.learn.dptl.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public abstract class Draft {

    private LocalDate drawingDate;
    private Set<Integer> whiteBalls;
    private int powerBall;
    private Random rand;

    public Draft(LocalDate drawingDate) {
        whiteBalls = new HashSet<>();
        while(whiteBalls.size() < 6) whiteBalls.add(rand.nextInt(70));
        powerBall = rand.nextInt(1,28);
        this.drawingDate = drawingDate;
    }

    public Draft(Set<Integer> whiteBalls, int powerBall) {
        this.whiteBalls = whiteBalls;
        this.powerBall = powerBall;
    }

    public Set<Integer> getWhiteBalls() {
        return whiteBalls;
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
        Draft draft = (Draft) o;
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

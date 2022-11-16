package org.learn.dptl.model;
import java.math.BigDecimal;
import java.util.Set;

public enum Match {
    // namespace(isPowerBallRight, #ofmatchingwhite, prizeMoney)
    NONE(false, 0, 0),
    PB(true, 0, 4),
    PB_ONE(true, 1, 4),
    PB_TWO(true, 2, 7),
    THREE(false,3,7),
    PB_THREE(true, 3, 100),
    FOUR(false, 4, 100),
    PB_FOUR(true, 4, 50*1000),
    FIVE(false, 5, 1*1000*1000),
    PB_FIVE(true, 5, 20*1000*1000);

    private final boolean isPB;
    private final int whiteMatchCt;
    private final int prizeMoney;

    public int getPrizeMoney() {
        return prizeMoney;
    }

    Match(boolean isPB, int whiteMatchCt, int prizeMoney) {
        this.isPB = isPB;
        this.whiteMatchCt = whiteMatchCt;
        this.prizeMoney = prizeMoney;
    }

    public static Match calculatePrizeMoney(Ticket winningTicket, Ticket playingTicket) {
        Set<Integer> winningWhiteBalls = winningTicket.getWhiteBalls();
        Set<Integer> playingWhiteBalls = playingTicket.getWhiteBalls();

//        // using addall
//        // new size - old size = non match => 5 - (new size - old size) = total match
//        winningWhiteBalls.addAll(playingWhiteBalls); // 5  // 7
//        int totalMatch = 5 - (winningWhiteBalls.size() - 5);

        // using retainAll
        winningWhiteBalls.retainAll(playingWhiteBalls);
        int totalMatch = winningWhiteBalls.size();

//        // using removeAll
//        winningWhiteBalls.removeAll(playingWhiteBalls); // leaves the non-=matching balls
//        int totalMatch = 5 - winningWhiteBalls.size();

        boolean isPbMatch = winningTicket.getPowerBall() == playingTicket.getPowerBall();

        for (Match match : Match.values()) {
            if (match.isPB == isPbMatch && match.whiteMatchCt == totalMatch) {
                return match;
            }
        }

        return NONE;
    }


}

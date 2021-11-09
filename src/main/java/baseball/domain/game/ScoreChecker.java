package baseball.domain.game;

import baseball.number.BaseballNumbers;

import java.util.stream.IntStream;

public class ScoreChecker {
    private static final int NUMBER_INDEX_START = 0;
    private static final int NUMBER_INDEX_END = 2;

    public static int strikeCounting(BaseballNumbers target, BaseballNumbers user) {
        return (int) IntStream.rangeClosed(NUMBER_INDEX_START, NUMBER_INDEX_END)
                .filter(index -> isStrike(target, user, index))
                .count();
    }

    private static boolean isStrike(BaseballNumbers target, BaseballNumbers user, int index) {
        return target.match(user, index);
    }

    public static int ballCounting(BaseballNumbers target, BaseballNumbers user) {
        return (int) IntStream.rangeClosed(NUMBER_INDEX_START, NUMBER_INDEX_END)
                .filter(index -> isBall(target, user, index))
                .count();
    }

    private static boolean isBall(BaseballNumbers target, BaseballNumbers user, int index) {
        return !target.match(user, index)
                && target.contains(user, index);
    }
}

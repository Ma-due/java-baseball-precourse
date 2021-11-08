package baseball.domain.game;

import baseball.number.BaseballNumbers;

import java.util.stream.IntStream;

public class ScoreChecker {

    public static int strikeCounting(BaseballNumbers target, BaseballNumbers user) {
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isStrike(target, user, index))
                .count();
    }

    private static boolean isStrike(BaseballNumbers target, BaseballNumbers user, int index) {
        return target.match(user, index);
    }

    public static int ballCounting(BaseballNumbers target, BaseballNumbers user) {
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isBall(target, user, index))
                .count();
    }

    private static boolean isBall(BaseballNumbers target, BaseballNumbers user, int index) {
        return !target.match(user, index)
                && target.contains(user, index);
    }
}

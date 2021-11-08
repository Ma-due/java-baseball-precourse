package baseball.domain.game;

import baseball.number.BaseballNumber;
import baseball.number.BaseballNumbers;

import java.util.stream.IntStream;

public class ScoreChecker {

    public static int strikeCounting(BaseballNumbers targetBaseballNumbers,
                                     BaseballNumbers userBaseballNumbers) {
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isStrike(targetBaseballNumbers, userBaseballNumbers, index))
                .count();
    }

    private static boolean isStrike(BaseballNumbers targetBaseballNumbers,
                                    BaseballNumbers userBaseballNumbers,
                                    int index) {
        return targetBaseballNumbers.match(userBaseballNumbers, index);
    }

    public static int ballCounting(BaseballNumbers targetBaseballNumbers,
                                   BaseballNumbers userBaseballNumbers) {
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isBall(targetBaseballNumbers, userBaseballNumbers, index))
                .count();
    }

    private static boolean isBall(BaseballNumbers targetBaseballNumbers,
                                  BaseballNumbers userBaseballNumbers,
                                  int index) {
        return targetBaseballNumbers.contains(userBaseballNumbers, index);
    }


}

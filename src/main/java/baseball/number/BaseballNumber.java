package baseball.number;

import java.util.HashMap;
import java.util.Map;

public class BaseballNumber {
    public static final Map<Integer, BaseballNumber> CACHE = new HashMap<>();

    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber intToBaseballNumber(int baseballNumber) {
        return CACHE.computeIfAbsent(baseballNumber, BaseballNumber::new);
    }
}

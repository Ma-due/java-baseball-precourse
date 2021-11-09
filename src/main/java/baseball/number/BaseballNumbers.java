package baseball.number;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumbers {
    private static final int NUMBER_COUNT = 3;
    private static final int NUMBER_MINIMUM_RANGE = 1;
    private static final int NUMBER_MAXIMUM_RANGE = 9;

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while(randomNumbers.size() < NUMBER_COUNT) {
            int randomNumber = RandomUtils.nextInt(NUMBER_MINIMUM_RANGE, NUMBER_MAXIMUM_RANGE);
            randomNumbers.add(randomNumber);
        }

        System.out.println(randomNumbers);

        List<BaseballNumber> baseballNumbers = randomNumbers.stream()
                .map(BaseballNumber::intToBaseballNumber)
                .collect(Collectors.toList());

        return new BaseballNumbers(baseballNumbers);
    }

    public static BaseballNumbers generateInputNumbers(List<Integer> inputNumberList) {
        List<BaseballNumber> baseballNumbers =
                inputNumberList.stream()
                        .map(BaseballNumber::intToBaseballNumber)
                        .collect(Collectors.toList());

        return new BaseballNumbers(baseballNumbers);
    }

    public boolean match(BaseballNumbers targetBaseballNumbers, int index) {
        BaseballNumber baseballNumber = this.baseballNumbers.get(index);
        BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers.get(index);

        return baseballNumber.equals(targetBaseballNumber);
    }

    public boolean contains(BaseballNumbers targetBaseballNumbers, int index) {
        BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers.get(index);

        return this.baseballNumbers.contains(targetBaseballNumber);
    }
}

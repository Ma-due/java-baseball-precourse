package baseball.number;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumbers {

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while(randomNumbers.size() < 3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            randomNumbers.add(randomNumber);
        }

        List<BaseballNumber> baseballNumbers = randomNumbers.stream()
                .map(BaseballNumber::intToBaseballNumber)
                .collect(Collectors.toList());

        return new BaseballNumbers(baseballNumbers);
    }
}

package baseball.number;

import com.sun.org.apache.xerces.internal.impl.dv.xs.Base64BinaryDV;
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

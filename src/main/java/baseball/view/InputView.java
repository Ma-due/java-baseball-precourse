package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요. : ";
    private static final String DELIM = "";
    private static final String RESTART_INFO_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RE_INPUT_NUMBER_MESSAGE = "숫자를 재 입력 해주세요. : ";
    private static final int NUMBER_COUNT = 3;
    private static final int RESTART_OPT_LENGTH = 1;
    private static final int RESTART_CODE = 1;
    private static final int END_CODE = 2;
    private static final char NUMBER_MINIMUM_VALUE = '1';
    private static final char NUMBER_MAXIMUM_VALUE = '9';

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = scanner.nextLine();

        if (!isValidationInputNumber(inputNumber)) {
            inputNumber = scanner.nextLine();
        }

        return Arrays.stream(inputNumber.split(DELIM))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean inputRestartOpt() {
        System.out.println(RESTART_INFO_MESSAGE);
        String inputNumber = scanner.nextLine();

        if (!isValidationRestartOpt(inputNumber)) {
            System.out.println(RESTART_INFO_MESSAGE);
            inputNumber = scanner.nextLine();
        }

        return Integer.parseInt(inputNumber) == RESTART_CODE;
    }

    private boolean isValidationRestartOpt(String inputNumber) {
        try {
            validationRestartOpt(inputNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(RE_INPUT_NUMBER_MESSAGE);
            return false;
        }
    }

    private void validationRestartOpt(String inputNumber) {
        boolean isOneLengthInt = inputNumber.chars().count() == RESTART_OPT_LENGTH;
        if (!isOneLengthInt) throw new IllegalArgumentException();

        int restartOpt = Integer.parseInt(inputNumber);
        if (!(restartOpt == RESTART_CODE || restartOpt == END_CODE)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidationInputNumber(String inputNumber) {
        try {
            validationInputNumber(inputNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(RE_INPUT_NUMBER_MESSAGE);
            return false;
        }
    }

    private void validationInputNumber(String inputNumber) {
        boolean isDuplicated = inputNumber.chars()
                .filter(number -> NUMBER_MINIMUM_VALUE <= number && number <= NUMBER_MAXIMUM_VALUE)
                .distinct()
                .count() == NUMBER_COUNT;

        if (!isDuplicated) throw new IllegalArgumentException();
    }
}

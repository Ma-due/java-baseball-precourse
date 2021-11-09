package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> inputNumber() {
        System.out.println("숫자를 입력해주세요. : ");
        String inputNumber = scanner.nextLine();

        if(!isValidationInputNumber(inputNumber)) {
            inputNumber = scanner.nextLine();
        }

        return Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean inputRestartOpt() {
        System.out.println("재시작 하려면 1 종료는 2");
        String inputNumber = scanner.nextLine();

        if(!isValidationRestartOpt(inputNumber)) {
            System.out.println("재시작 하려면 1 종료는 2");
            inputNumber = scanner.nextLine();
        }

        return Integer.parseInt(inputNumber) == 1;
    }

    private boolean isValidationRestartOpt(String inputNumber) {
        try {
            validationRestartOpt(inputNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("숫자를 재입력해주세요");
            return false;
        }
    }

    private void validationRestartOpt(String inputNumber) {
        boolean isOneLengthInt = inputNumber.chars().count() == 1;
        if(!isOneLengthInt) throw new IllegalArgumentException();

        int restartOpt = Integer.parseInt(inputNumber);
        if(!(restartOpt == 1 || restartOpt == 2)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidationInputNumber(String inputNumber) {
        try {
            validationInputNumber(inputNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("숫자를 재입력해 주세요.");
            return false;
        }
    }

    private void validationInputNumber(String inputNumber) {
        boolean isDuplicated = inputNumber.chars()
                .filter(number -> '1' <= number && number <= '9')
                .distinct()
                .count() == 3;

        if(!isDuplicated) throw new IllegalArgumentException();
    }
}

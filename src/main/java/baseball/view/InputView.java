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

        /* 검증 로직 */

        return Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean inputRestartOpt() {
        System.out.println("재시작 하려면 1 종료는 2");
        String inputNumber = scanner.nextLine();

        /* 검증 로직 */

        int RestartOpt = Integer.parseInt(inputNumber);
        if(RestartOpt == 1) return true;

        return false;
    }
}

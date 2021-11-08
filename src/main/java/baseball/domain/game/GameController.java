package baseball.domain.game;


import baseball.number.BaseballNumbers;
import baseball.view.InputView;

import java.util.List;

public class GameController {

    private final BaseballNumbers targetNumber;
    private final InputView inputView;

    private BaseballNumbers userNumber;

    public GameController(InputView inputview) {
        this.targetNumber = BaseballNumbers.generateRandomNumbers();
        this.inputView = inputview;

        playGame();
    }

    private void playGame() {
        //숫자 입력
        userNumber = BaseballNumbers.generateInputNumbers(inputView.inputNumber());

        //점수 계산

        //종료 확인
    }
}

package baseball.domain;

import baseball.number.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final BaseballNumbers targetNumbers;
    private final InputView inputView;

    public GameController(InputView inputview) {
        this.targetNumbers = BaseballNumbers.generateRandomNumbers();
        this.inputView = inputview;
    }

    public boolean playGame() {
        //숫자 입력
        boolean exitCheck = false;

        while (!exitCheck) {
            BaseballNumbers userNumbers = BaseballNumbers.generateInputNumbers(inputView.inputNumber());

            //점수 계산
            int strikeCount = ScoreChecker.strikeCounting(targetNumbers, userNumbers);
            int ballCount = ScoreChecker.ballCounting(targetNumbers, userNumbers);

            //종료 확인
            GameResult gameResult = new GameResult(ballCount, strikeCount);
            exitCheck = OutputView.outMessage(gameResult);
        }

        return inputView.inputRestartOpt();
    }
}

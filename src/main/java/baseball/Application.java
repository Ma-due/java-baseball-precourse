package baseball;

import baseball.domain.game.GameController;
import baseball.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean restartOpt = true;

        InputView inputView = new InputView(scanner);
        while (restartOpt) {
            GameController gameController = new GameController(inputView);
            restartOpt = gameController.playGame();
        }
    }
}

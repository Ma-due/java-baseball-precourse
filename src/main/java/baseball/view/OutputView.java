package baseball.view;

import baseball.domain.game.GameResult;

public class OutputView {

    public static boolean outMessage(GameResult gameResult) {
        String resultMessage = getResultMessage(gameResult);
        System.out.println(resultMessage);

        return gameResult.isEndOfGame();
    }

    private static String getResultMessage(GameResult gameResult) {
        StringBuilder resultMessage = new StringBuilder();

        if((!gameResult.hasBallCount() && !gameResult.hasStrikeCount())) {
            resultMessage.append("낫싱");

            return resultMessage.toString();
        }
        if (gameResult.hasBallCount()) {
            resultMessage.append(String.format("%d볼 ", gameResult.getBallCount()));
        }
        if (gameResult.hasStrikeCount()) {
            resultMessage.append(String.format("%d스트라이크", gameResult.getStrikeCount()));
        }
        if(gameResult.isEndOfGame()) {
            resultMessage.append("게임이 끝났습니다. 리겜?");
        }

        return resultMessage.toString();
    }
}

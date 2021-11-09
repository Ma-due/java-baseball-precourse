package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼 ";
    private static final String STRIKE = "%d스트라이크";
    private static final String END_GAME_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static boolean outMessage(GameResult gameResult) {
        String resultMessage = getResultMessage(gameResult);
        System.out.println(resultMessage);

        return gameResult.isEndOfGame();
    }

    private static String getResultMessage(GameResult gameResult) {
        StringBuilder resultMessage = new StringBuilder();

        if ((!gameResult.hasBallCount() && !gameResult.hasStrikeCount())) {
            resultMessage.append(NOTHING);

            return resultMessage.toString();
        }
        if (gameResult.hasBallCount()) {
            resultMessage.append(String.format(BALL, gameResult.getBallCount()));
        }
        if (gameResult.hasStrikeCount()) {
            resultMessage.append(String.format(STRIKE, gameResult.getStrikeCount()));
        }
        if (gameResult.isEndOfGame()) {
            resultMessage.append(END_GAME_MESSAGE);
        }

        return resultMessage.toString();
    }
}

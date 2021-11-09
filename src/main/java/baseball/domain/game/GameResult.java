package baseball.domain.game;

public class GameResult {
    private static final int ZERO_VALUE = 0;
    private static final int ANSWER_VALUE = 3;

    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isEndOfGame() {
        if (this.strikeCount == ANSWER_VALUE) return true;

        return false;
    }

    public boolean hasBallCount() {
        return this.ballCount != ZERO_VALUE;
    }

    public boolean hasStrikeCount() {
        return this.strikeCount != ZERO_VALUE;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}

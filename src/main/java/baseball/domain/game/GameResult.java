package baseball.domain.game;

public class GameResult {

    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isEndOfGame() {
        if(this.strikeCount == 3) return true;

        return false;
    }

    public boolean hasBallCount() {
        return this.ballCount != 0;
    }

    public boolean hasStrikeCount() {
        return this.strikeCount != 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}

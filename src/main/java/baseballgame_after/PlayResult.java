package baseballgame_after;

public class PlayResult {
    int strike=0;
    int ball=0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void strike() {
        this.strike++;
    }

    public void ball() {
        this.ball++;
    }


    public int reportStrike() {
        return this.strike;
    }

    public int reportBall() {
        return this.ball;
    }

}

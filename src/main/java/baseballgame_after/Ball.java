package baseballgame_after;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
    }

    public BallStatus play(Ball input){
        if( this.equals(input) ) {
            return BallStatus.BALL_STRIKE;
        }
        if( this.matchBallNum(input) ) {
            return BallStatus.BALL_BALL;
        }
        return BallStatus.BALL_NOTHING;
    }

    private boolean matchBallNum(Ball input) {
        return input.num == this.num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, num);
    }
}

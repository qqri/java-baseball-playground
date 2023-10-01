package baseballgame_after;

public enum BallStatus {
    BALL_STRIKE, BALL_BALL, BALL_NOTHING;

    boolean isNotNothing(){
        //return !ballStatus.equals(BALL_NOTHING);
        return this != BALL_NOTHING;
    }
}

package baseballgame_after;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    public final List<Ball> balls;

    public Balls(List<Integer> answers){
        this.balls = makeBallList(answers);
    }
    public BallStatus play(Ball input) {
        return balls.stream()
                .map(answer -> answer.play(input))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.BALL_NOTHING)
                ;
    }
//    public static BallStatus play(List<Integer> computer, Ball input) {
//        List<Ball> balls = makeBallList(computer);
//        for(Ball ball : balls) {
//            if( isMatchStrike(ball , input) ) return BallStatus.BALL_STRIKE;
//            if( isMatchBall(ball, input) ) return BallStatus.BALL_BALL;
//        }
//        return BallStatus.BALL_NOTHING;
//    }
    static List<Ball> makeBallList(List<Integer> list) {
        return list.stream()
                .map(i -> new Ball(list.indexOf(i)+1, i))
                .collect(Collectors.toList());
    }
    static boolean isMatchStrike(Ball com, Ball input) {
        return com.play(input) == BallStatus.BALL_STRIKE;
    }

    static boolean isMatchBall(Ball com , Ball input) {
        return com.play(input) == BallStatus.BALL_BALL;
    }
}

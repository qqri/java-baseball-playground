package baseballgame_after;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answers){
        this.balls = makeBallList(answers);
    }

    public PlayResult play(List<Integer> input) {
        PlayResult playResult = new PlayResult();
        List<Ball> inputBalls = makeBallList(input);
        for(Ball inputBall : inputBalls) {
            if( isMatchStrike(inputBall) ) playResult.strike();
            if( isMatchBall(inputBall) ) playResult.ball();
        }
        /* 스트림으로 쓸 수 있으나 가독성에서 별 차이 없는듯
        inputBalls.stream()
                .forEach( i -> {
                    if(this.isMatchStrike(i)) playResult.strike();
                    if(this.isMatchBall(i)) playResult.ball();
                });*/
        return playResult;
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
    public boolean isMatchStrike(Ball input) {
        return this.play(input) == BallStatus.BALL_STRIKE;
    }

    public boolean isMatchBall( Ball input) {
        return this.play(input) == BallStatus.BALL_BALL;
    }
}

package baseballgame_after;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BallsTest {
    List<Integer> computer;
    List<Ball> balls;
    @BeforeEach
    void setting() {
        computer = Arrays.asList(1,8,9);
    }
    @Test
    public void strikeNum() {
        List<Integer> input = Arrays.asList(1,3,5);
        //Result result = Balls.
    }
    @Test
    public void strike() {
        Ball input = new Ball(1,1);
        Balls answers = new Balls(computer);
        BallStatus status = answers.play(input);
        assertThat(status).isEqualTo(BallStatus.BALL_STRIKE);
    }

    @Test
    public void ball() {
        Ball input = new Ball(1,8);
        Balls answers = new Balls(computer);
        BallStatus status = answers.play(input);
        assertThat(status).isEqualTo(BallStatus.BALL_BALL);
    }

    @Test
    public void nothing() {
        Ball input = new Ball(1,5);
        Balls answers = new Balls(computer);
        BallStatus status = answers.play(input);
        assertThat(status).isEqualTo(BallStatus.BALL_NOTHING);
    }
}

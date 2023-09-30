package baseballgame_after;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseTest {
    Ball computer;

    @BeforeEach
    void setting() {
        computer = new Ball(1,2);
    }

    @Test
    public void strike() throws Exception {
        //given
        Ball input = new Ball(1,2);
        //when
        BallStatus status = computer.play(input);
        //then
        assertThat(status).isEqualTo(BallStatus.BALL_STRIKE);
    }

    @Test
    public void ball() throws Exception {
        //given
        Ball input = new Ball(2,2);
        //when
        BallStatus status = computer.play(input);
        //then
        assertThat(status).isEqualTo(BallStatus.BALL_BALL);
    }

    @Test
    public void nothing() throws Exception {
        //given
        Ball input = new Ball(1,5);
        //when
        BallStatus status = computer.play(input);
        //then
        assertThat(status).isEqualTo(BallStatus.BALL_NOTHING);
    }

}

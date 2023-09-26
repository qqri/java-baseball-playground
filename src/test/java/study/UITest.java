package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UITest {

    @Test
    @DisplayName("자릿수가 맞지 않으면 오류를 발생시킨다.")
    void checkInputLength() throws Exception {
        Throwable thr = catchThrowable(() -> new UI().checkInputLength("71",3));
        assertThat(thr).hasMessageContaining("자릿수가 맞지 않음.");
    }
}

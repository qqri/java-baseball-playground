package baseballgame_after;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {

    @Test
    public void 숫자_1_9_validation() {
        assertThat(ValidationUtil.validationNo(1)).isTrue();
        assertThat(ValidationUtil.validationNo(9)).isTrue();
        assertThat(ValidationUtil.validationNo(2)).isTrue();
        assertThat(ValidationUtil.validationNo(10)).isFalse();
    }
    
    @Test
    public void 숫자_중복_validation() throws Exception {

        assertThat(ValidationUtil.validationDuplicateCheck("122")).isFalse();
        assertThat(ValidationUtil.validationDuplicateCheck("123")).isTrue();
    }
}

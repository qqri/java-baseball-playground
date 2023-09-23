package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] num1 = "1,2".split(",");
        assertThat(num1).contains("1","2");
        String[] num2 = "1".split(",");
        assertThat(num2).containsExactly("1"); // 순서를 포함하여 정확히 일치하는지
    }

    @Test
    void substring() throws Exception {
        //given
        String str = "(1,2)";
        //when
        str = str.substring(1,4);
        //then
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("위치값 벗어났을때 exception")
    public void character() throws Exception {
        //given
        String str = "abc";
        //when
        try {
            char c = str.charAt(5);
        } catch (IndexOutOfBoundsException e) {
                testException();
        } catch (Exception e) {
                fail("testGetByTooLargeIndexFromListWith5Elements - test failed. The expected exception was not catched");
        }
    }

    @Test
    public void testException() {
        assertThatThrownBy(() -> { throw new Exception("boom!"); }).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }

}

package study;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    private Set<Integer> numbers;

    // Test Case 구현
    @Test
    @DisplayName("set 크기 확인")
    public void setSize() throws Exception {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    public static boolean isContains(Set<Integer> numbers, int num) {
        return numbers.contains(num);
    }

    @DisplayName("set 포함여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isContains_ShouldReturnTrueForaContainNumbers (int n) {
        assertTrue(numbers.contains(n));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
    void isContains_ShouldReturnExpectedValue(String input, String expected) {
        int inputN = Integer.valueOf(input);
        assertEquals(expected , String.valueOf(numbers.contains(inputN)));
    }
}
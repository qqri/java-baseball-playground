package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class BaseballGameSelfTest {
    private ArrayList<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void strike() {
        String input = "253";

        ArrayList<String> inputList = new ArrayList<>();
        for(char c : input.toCharArray()) {
            inputList.add(c+"");
        }
        assertThat(input).isEqualTo("123");
    }

    @Test
    void ball() {
    }

    @Test
    void printResultString() {
    }
}
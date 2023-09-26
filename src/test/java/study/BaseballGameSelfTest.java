package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class BaseballGameSelfTest {
    private ArrayList<Integer> answer;
    @BeforeEach
    void setUp() {
        answer = new ArrayList<>();
        answer.add(1);
        answer.add(2);
        answer.add(3);
    }

    @Test
    void strike() {
        String input = "253";

        ArrayList<String> inputList = new ArrayList<>();
        for(char c : input.toCharArray()) {
            inputList.add(c+"");
        }

        input = inputList.stream()
                        .map(String::valueOf)
                                .collect(Collectors.toList(Collectors.joining()));


        assertThat(input).isEqualTo("123");
    }

    @Test
    void ball() {
    }

    @Test
    void printResultString() {
    }
}
package study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Scanner;

public class StringCalculatorTest {

    public static int calculator(String str) {
        int res = 0, currN = 0;
        String currOp = "";
        String[] ops = str.split(" ");

        for(int i = 0 ; i < ops.length ; i++ ) {
            if (i == 0) { //숫자
                res = Integer.parseInt(ops[i]);
            } else if(i%2 == 0) { //숫자
                currN = Integer.parseInt(ops[i]);
                switch(currOp) {
                    case "+":
                        res = res + currN;
                        break;
                    case "-":
                        res = res - currN;
                        break;
                    case "*":
                        res = res * currN;
                        break;
                    case "/":
                        res = res / currN;
                        break;
                }
            } else if(i%2 == 1) { //연산자
                currOp = ops[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(calculator(str));
    }

    @DisplayName("계산기프로그램")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10" , "3 + 5 / 2:4"} , delimiter = ':')
    public void calculatorTest(String input , String expected) {
        String actual = String.valueOf(calculator(input));
        assertThat(actual).isEqualTo(expected);
    }
}

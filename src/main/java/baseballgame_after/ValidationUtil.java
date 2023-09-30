package baseballgame_after;

import java.util.Arrays;
import java.util.List;

public class ValidationUtil {
    public static boolean validationNo(int no) {
        if(no >= 1 && no <= 9) return true;
        return false;
    }

    public static boolean validationDuplicateCheck(String input) {
        int inputNoCnt = (int) Arrays.asList(input.split("")).stream()
                                .distinct()
                                .count();
        if(inputNoCnt == 3) return true;

        return false;
    }
}

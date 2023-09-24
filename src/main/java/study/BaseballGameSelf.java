package study;

import java.util.HashSet;
import java.util.Set;

public class BaseballGameSelf {
    public static void main(String[] args) {
        RandomNum randomNum = new RandomNum();
        System.out.println(randomNum.makeRandomNumber());
    }
}

class RandomNum{
    Set<Integer> set = new HashSet<>();
    String answer = "";

    public String makeRandomNumber() {
        for(int i = 0 ; set.size() < 3 ; i++ ) {
            set.add((int)(Math.random()*9) + 1);
        }
        for(int n : set) {
            answer = answer + String.valueOf(n);
        }
        return answer;
    }
}
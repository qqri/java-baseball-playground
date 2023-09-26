package study;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;

import static study.UI.*;

public class BaseballGameSelf {
    static int strikeN = 0 , ballN = 0;
    public static void main(String[] args) throws Exception {

        RandomNum randomNum = new RandomNum();
        randomNum.makeRandomNumber();

        while( !play(randomNum) ) { }

    }
    public static boolean play(RandomNum randomNum) throws Exception {
        ArrayList<String> inputList = new ArrayList<>();

        String input = InputView();
        for(char c : input.toCharArray()) {
            inputList.add(c+"");
        }
        strikeN = strike(inputList , randomNum.ans);
        ballN = ball(inputList , randomNum.ans, randomNum.set);
        ResultView(strikeN , ballN);

        if(strikeN == 3 && !again()) return true; //게임 종료
        else if(strikeN == 3) { //게임 다시시작
            randomNum.makeRandomNumber();
            return false;
        }
        return false;
    }

    static int strike(ArrayList<String> inputList , ArrayList<String> ansList) {
        int res = 0;

        if(inputList.get(0).equals(ansList.get(0))) res++;
        if(inputList.get(1).equals(ansList.get(1))) res++;
        if(inputList.get(2).equals(ansList.get(2))) res++;

        return res;
    }

    static int ball(ArrayList<String> inputList , ArrayList<String> ansList , Set<String> set) {
        int res = 0;

        if(!inputList.get(0).equals(ansList.get(0)) && set.contains(inputList.get(0))) res++;
        if(!inputList.get(1).equals(ansList.get(1)) && set.contains(inputList.get(1))) res++;
        if(!inputList.get(2).equals(ansList.get(2)) && set.contains(inputList.get(2))) res++;

        return res;
    }
    static boolean again() {
        String input = InputViewAgain();
        if(input.equals("1")) return true;
        else if(input.equals("2")) return false;

        return false;
    }

}
class RandomNum{
    Set<String> set = new HashSet<>();
    ArrayList<String> ans = new ArrayList<>();


    public void makeRandomNumber() {
        set.clear();
        ans.clear();
        for(int i = 0 ; set.size() < 3 ; i++ ) {
            set.add( String.valueOf((int)(Math.random()*9) + 1));
        }
        for(String n : set) {
            ans.add(n);
        }
    }
}

class UI {

    static Scanner sc = new Scanner(System.in);
    static String InputView() throws Exception {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = sc.next();
        checkInputLength(input, 3);
        return input;
    }
    static String InputViewAgain() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.next();
    }
    static void ResultView(int strike, int ball) {
        String res = "";

        if(ball != 0) res += String.valueOf(ball) + "볼 ";
        if(strike != 0 && strike != 3) res += String.valueOf(strike) + "스트라이크";
        else if(strike == 3) res += "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        if(ball == 0 && strike == 0) res += "낫싱";

        System.out.println(res);
    }

    static void checkInputLength(String input, int len) throws Exception{
        if(input.length() != len) throw new Exception("자릿수가 맞지 않음.");
    }
}
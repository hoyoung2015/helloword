package douban;

import java.util.*;

/**
 * Created by hoyoung on 16-4-28.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(isBracketMath("[(12){}]"));
    }
    public static boolean isBracketMath(String s){
        Deque<Character> stack = new LinkedList<>();


        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('(',')');
            put('[',']');
            put('{','}');
        }};


        for (char c : s.toCharArray()){
            if(map.keySet().contains(c)){
                stack.push(c);
            }else if(map.values().contains(c)){
                if(map.get(stack.peek())==c){
                    stack.pop();
                }
            }
        }
        //如果栈是空的
        return stack.isEmpty();
    }
}

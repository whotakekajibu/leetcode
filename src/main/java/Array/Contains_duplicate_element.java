package Array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Date 2020/4/5 17:39
 **/
public class Contains_duplicate_element {
    public boolean duplicate(int[] arr){
        if(arr.length < 2){
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>(arr.length);
        for(int e: arr){
            while(!stack.isEmpty() && stack.peek() > e){
                stack.poll();
            }
            if(stack.peek() == e){
                return true;
            }
            stack.push(e);
        }
        return false;
    }

}

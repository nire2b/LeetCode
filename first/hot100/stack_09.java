package first.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class stack_09 {
    public static void main(String[] args) {
        Solution_09 solution09 = new Solution_09();
        solution09.decodeString("3[a]2[bc]");
    }
}
class Solution_09 {
    //20.有效括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='('){
                stack.push(')');
            }else if(charArray[i]=='['){
                stack.push(']');
            }else if (charArray[i]=='{'){
                stack.push('}');
            }else if (stack.isEmpty()||charArray[i]!=stack.pop()){
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    //394.字符串解码
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> str = new Stack<>();
        int num = 0;
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>='0'&&c<='9'){
                num = num*10+c-'0';
            }else if(c>='a'&&c<='z'){
                cur = cur+c;
            }else if(c=='['){
                nums.push(num);
                str.push(cur);
                num = 0;
                cur = "";
            }else{
                int n = nums.pop();
                StringBuilder sb = new StringBuilder(str.pop());
                for (int j = 0; j < n; j++) {
                    sb.append(cur);
                }
                cur = sb.toString();
            }
        }
        return cur;
    }

    //739.每日温度
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1;i<len;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

}

//155.最小栈
class MinStack {
    List<Integer> list;
    int index;
    int min;
    public MinStack() {
        this.list=new LinkedList<>();
        this.index = -1;
        this.min = Integer.MAX_VALUE;
    }
    public void push(int val) {
        list.add(val);
        index++;
        min = Math.min(min,val);
    }
    public void pop() {
        if (list.get(index)==min){
            list.remove(index--);
            min = Integer.MAX_VALUE;
            for (int a:list){
                min = Math.min(min,a);
            }
            return;
        }
        list.remove(index--);
    }
    public int top() {
        return list.get(index);
    }
    public int getMin() {
        return min;
    }
}
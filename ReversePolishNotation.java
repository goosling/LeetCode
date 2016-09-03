package leetcode;


import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {

        int returnVal = 0;

        String operators = "+-/*";

        Stack<String> stack = new Stack<>();

        for(String t : tokens) {
            if(!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = String.valueOf(stack.pop());
                int b = String.valueOf(stack.pop());
                int index = operators.indexOf(t);

                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(a - b));
                        break;
                    case 2:
                        stack.push(String.valueOf(a / b));
                        break;
                    case 3:
                        stack.push(String.valueOf(a * b));
                        break;
                }
            }
        }
        returnVal = Integer.valueOf(stack.pop());
        return returnVal;
    }
}
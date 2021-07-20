package com.algorithm.datastructure.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_Polish_Notation {
    public int priority(char c){
        if(c == '*' || c == '/') return 1;
        else if(c == '+' || c == '-') return 0;
        else if(c == '#') return -1;
        else return -100;
    }
    public String[] change_to_reverse(String s){
        // 3+4*2*3#
        // 3 4 2 3 * * +
        // (3+4)*2*3
        // 3 4 + 2 * 3 *
        s += "#"; // 添加结尾识别符
        char[] chars = s.toCharArray(); // 将字符串转换成字符组
        // count写入结果，len是为了去除括号的长度
        int n = chars.length, count = 0, len = n - 1;
        // 储存当前结果
        String[] result = new String[len];
        // 压入符号
        Stack<Character> stack = new Stack<>();
        // 实现多位数的录入
        String num = "";
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chars[i])) {
                num += chars[i];
                // 若下一位仍然是数字，构建多位数
                if(i == n - 1) {
                    result[count++] = num;
                    break;
                }
                if(Character.isDigit(chars[i+1])) {
                    len--;
                    continue;
                }
                // 放入数字
                result[count++] = num;
                num = "";
            }
            else if (chars[i] == '(') {
                // 压入左括号，减少无效长度
                stack.push('(');
                len--;
            }
            else if (chars[i] == ')') {
                // 减去无效长度
                len--;
                if (stack.empty()) {
                    throw new RuntimeException("Wrong!");
                }
                // 不断地弹出，知道栈顶为左括号
                while (stack.peek() != '(') {
                    char c = stack.pop();
                    result[count++] = Character.toString(c);
                }
                // 弹出左括号
                stack.pop();

            } else {
                // 栈是空的，直接压入符号
                if (stack.empty()) stack.push(chars[i]);
                // 如果优先级高于栈顶的符号，压入栈内
                else if (priority(chars[i]) > priority(stack.peek())) {
                    stack.push(chars[i]);
                }
                // 如果优先级相同，弹出栈顶，并压入当前符号
                else if (priority(chars[i]) == priority(stack.peek())){
                    char c = stack.pop();
                    result[count++] = Character.toString(c);
                    stack.push(chars[i]);
                } else {
                    // 如果优先级低于栈顶，弹出栈顶，一直弹出栈顶，直至栈顶的优先级小于等于该符号
                    while (priority(chars[i]) < priority(stack.peek())) {
                        char c = stack.pop();
                        result[count++] = Character.toString(c);
                        // 当为设计的#符号时，会将所有符号弹出，然后结束循环。
                        if(stack.empty()) break;
                    }
                    stack.push(chars[i]);
                }
            }
        }
        // 去除无效的长度
        String[] res = new String[len];
        for(int i = 0; i < len; i++){
            res[i] = result[i];
        }
        return res;
    }
    public void calculate(String[] s){
        Stack<String> stack = new Stack<>();
        int num1, num2, res=0;
        for(String c : s){
            // 匹配数字，可匹配到多位数
            if(c.matches("\\d+")) {
                stack.push(c);
//                System.out.println(c+" num");
            }
            else{
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                if(c.equals("*")) res = num1*num2;
                else if(c.equals("/")) res = num2/num1;
                else if(c.equals("+")) res = num1+num2;
                else if(c.equals("-")) res = num2-num1;
                stack.push(""+res);
//                System.out.println(stack.peek()+" get_num");
            }
        }
        System.out.println(stack.pop());
    }
    public static void main(String[] args) {
        Reverse_Polish_Notation rpn = new Reverse_Polish_Notation();
        String s = "";
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("输入表达式：");
            s = scan.next();
            if(s.equals("exit")) break;
            String[] reverse_expression = rpn.change_to_reverse(s);
            for(String ss : reverse_expression) System.out.print(ss+" ");
            System.out.println();
            rpn.calculate(reverse_expression);
        }
    }
}

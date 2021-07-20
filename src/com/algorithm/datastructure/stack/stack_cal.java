package com.algorithm.datastructure.stack;

import java.util.Scanner;

public class stack_cal {
    int top = -1;
    int[] arr;
    char[] chars;
    String[] strings;
    public stack_cal(){
        arr = new int[10];
        chars = new char[10];
        strings = new String[10];
    }
    public stack_cal(int size){
        arr = new int[size];
        chars = new char[size];
        strings = new String[size];
    }
    public void push(int val){
        if(top < arr.length){
            arr[++top] = val;
        }
        else{
            System.out.println("The stack is full");
        }
    }
    public void push(char oper){
        if(top < chars.length){
            chars[++top] = oper;
        }
        else{
            System.out.println("The stack is full");
        }
    }
    public void push(String s){
        if(top < strings.length){
            strings[++top] = s;
        }
        else{
            System.out.println("The stack is full");
        }
    }
    public char top(){
        return chars[top];
    }
    public int pop(){
        if(top >= 0){
            return arr[top--];
        }
        else {
            return 0;
        }
    }

    public char pop_c(){
        if(top >= 0){
            return (chars[top--]);
        }
        else {

            return 'x';
        }
    }
    public String pop_s(){
        if(top >= 0){
            return strings[top--];
        }
        else{

            return "wrong";
        }
    }
    public boolean empty(){
        return top == -1;
    }
    // 符号的优先级
    public int priority(char c){
        if(c == '*' || c == '/') return 1;
        else if(c == '(') return -1;
        else return 0;
    }
    public void show(){
        int temp = top;
        while(temp >= 0){
            System.out.println(arr[temp]);
            temp--;
        }
    }
    public void show_c(){
        int temp = top;
        while(temp >= 0){
            System.out.println(chars[temp]);
            temp--;
        }
    }
    // 两个数字的计算
    public int cal(int num1, int num2, char ope){
        if(ope == '*') return num1 * num2;
        else if(ope == '/') return num2 / num1;
        else if(ope == '+') return num1 + num2;
        else if(ope == '-') return num2 - num1;
        else return 0;
    }
    public static void calculator(String s){
        stack_cal numStack = new stack_cal(); // 数字栈
        stack_cal operStack = new stack_cal(); // 符号栈
        int num1, num2, res;
        char ope;
        String num = "";
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            // 将左括号压入栈内
            if(chars[i] == '(') operStack.push('(');
            else if(chars[i] == ')'){
                // 遇到右括号后，不断弹出栈顶并计算，得到括号内的计算结果，直至左括号
                while(operStack.top() != '(') {
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    ope = operStack.pop_c();
                    res = numStack.cal(num1, num2, ope);
                    numStack.push(res);
                }
                // 弹出左括号
                operStack.pop_c();
            }
            else if(Character.isDigit(chars[i])){
                num += chars[i];
                // 若来到最后一位，将数字压入
                if(i == chars.length - 1) numStack.push(Integer.parseInt(num));
                else{
                    // 若下位仍为数字，继续添加数字的位数
                    if(Character.isDigit(chars[i+1])){
                        continue;
                    }
                    else {
                        numStack.push(Integer.parseInt(num));
                        num = ""; // 初始化num
                    }
                }
            }
            else{
                // 符号栈为空直接压入
                if(operStack.empty()) operStack.push(chars[i]);
                else{
                    // 符号栈顶优先级大于等于当前符号，弹出计算两个数字和符号的结果
                    if(operStack.priority(chars[i]) <= operStack.priority(operStack.top())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        ope = operStack.pop_c();
                        res = numStack.cal(num1, num2, ope);
                        // 压入结果数和当前符号
                        numStack.push(res);
                        operStack.push(chars[i]);
                    }
                    else{
                        // 优先级大于栈顶符号，直接压入栈内
                        operStack.push(chars[i]);
                    }
                }
            }
        }

        while(true){
            if(operStack.empty()) break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            ope = operStack.pop_c();
            res = numStack.cal(num1, num2, ope);

            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d\n", s, res2);
    }
    public static void main(String[] args) {
        String s = "";
        while(true) {
            System.out.println("输入表达式：(exit:退出)");
            Scanner scanner = new Scanner(System.in);
            s = scanner.next();
            if(s.equals("exit"))  break;
            char[] chars = s.toCharArray();
            calculator(s);
        }
    }
}

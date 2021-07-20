package com.algorithm.datastructure.stack;

public class stack {
    int top;
    int[] arr;
    public stack(){
        top = -1;
        arr = new int[10];
    }
    public stack(int size){
        top = -1;
        arr = new int[size];
    }
    public void push(int value){
        if(top < arr.length - 1) arr[++top] = value;
        else System.out.println("The stack is full");
    }
    public int pop(){
        if(top < 0) throw new RuntimeException("There is no num in the stack");
        else return arr[top--];
    }
    public void show(){
        int temp = top;
        while(temp != -1){
            System.out.println(arr[temp]);
            temp--;
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(4);
        s.pop();
        s.show();
    }
}

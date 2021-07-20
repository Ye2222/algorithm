package com.algorithm.datastructure;

import java.util.Scanner;

public class queue{
    int rear = 0, front = 0;
    int MaxSize;
    int[] arr;

    public queue(){
        this.MaxSize = 10;
        arr = new int[this.MaxSize];
    }
    public queue(int MaxSize){
        this.MaxSize = MaxSize;
        arr = new int[this.MaxSize];
    }

    public boolean isFull(){
        return (rear + 1) % MaxSize == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    // 加入队尾
    public void append(int x){
        if(isFull()){
            System.out.println("The queue is Full!");
            return;
        }
        arr[rear] = x;
        rear = (rear+1) % MaxSize;
    }

    // 弹出队头
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("The queue is empty!");
        }
        int res = arr[front];
        arr[front] = -1;
        front = (front+1) % MaxSize;
        return res;
    }

    // 显示队头
    public void head(){
        if(isEmpty()){
            throw new RuntimeException("The queue is empty!");
        }
        System.out.println(arr[front]);
    }

    public int size(){
        return (rear+MaxSize-front) % MaxSize;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return;
        }
        for(int i = front; i < front + size(); i++)
            System.out.printf("arr[%d]=%d\n", i % MaxSize, arr[i%MaxSize]);
        System.out.println();
    }


    public void menu(){
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(显示队列)\ne(退出)\na(添加数据到队列)\ng(取出队头的数据)\nh(显示当前队头的数据)");
            System.out.println("输入你的选择：");
            char key = s.next().charAt(0);
            switch (key){
                case 's':
                    show();
                    break;
                case 'e':
                    s.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入你要添加的数字：");
                    int x = s.nextInt();
                    append(x);
                    break;
                case 'g':
                    try{
                        int res = pop();
                        System.out.println("取出的数据为：" + res);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                case 'h':
                    try{
                        head();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }
    public static void main(String[] args){
        queue q = new queue(3);
        q.menu();
    }
}

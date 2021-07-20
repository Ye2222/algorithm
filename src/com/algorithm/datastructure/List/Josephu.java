package com.algorithm.datastructure.List;

public class Josephu {
    public Node head = new Node();
    public void setHead(int value){
        head.value = value;
    }
    public void add(int value){
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = new Node(value);
    }
    public void josephu(int k, int m){
        Node temp = head;
        while(temp != null){
            if(temp.value == k){
                break;
            }
            temp = temp.next;
        }
        int count = 1;
        int cnt = 0;
        while(temp.next != null){
            count += 1;
            if(m == count){
                if(cnt<4) System.out.printf("%d->",temp.next.value);
                else System.out.println(temp.next.value);
                temp.next = temp.next.next;
                count = 1;
                cnt += 1;
            }
            if(cnt == 5) break;
            temp = temp.next;
        }
    }
    public void show(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void link(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
    }

    static class CircleSingleLinkedList{
        private Boy first = null;
        public void addBoy(int nums){
            if(nums < 1){
                System.out.println("nums的值不正确");
                return;
            }
            Boy curBoy = null;
            for(int i = 1; i <= nums; i++){
                Boy boy = new Boy(i);
                if(i == 1){
                    first = boy;
                    first.setNext(first);
                    curBoy = first;
                }
                else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy = boy;
                }
            }
        }

        public void showBoy(){
            if(first == null){
                System.out.println("没有任何小孩");
                return;
            }
            Boy curBoy = first;
            while(true){
                System.out.printf("小孩的编号 %d\n", curBoy.no);
                if(curBoy.next == first) break;
                curBoy = curBoy.next;
            }
        }

        public void countBoy(int start, int count, int nums){
            if(first == null || start < 1 || start > nums){
                System.out.println("参数输入有误。。");
                return;
            }
            Boy helper = first;
            while(helper.next != first) helper = helper.next;
            for(int i = 0; i < start - 1; i++){
                first = first.next;
                helper = helper.next;
            }
            while(true){
                if(helper == first) break;
                for(int i = 0; i < count - 1; i++){
                    first = first.next;
                    helper = helper.next;
                }
                System.out.printf("小孩%d出圈\n", first.no);
                first = first.next;
                helper.setNext(first);
            }
            System.out.printf("最后留在圈中的小孩编号%d\n", first.no);
        }

    }
    static class Boy{
        int no;
        Boy next;
        public Boy(int no){
            this.no = no;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        public Boy getNext() {
            return next;
        }
    }
    public static void main(String[] args) {
        Josephu j = new Josephu();
        j.setHead(1);
        j.add(2);
        j.add(3);
        j.add(4);
        j.add(5);
        j.link();
        j.josephu(1,5);
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBoy(5);
        c.showBoy();
        c.countBoy(1, 5, 5);
    }

    class Node{
        int value;
        Node next;
        public Node(){}
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        @Override
        public String toString(){
            return "(" + value + ")";
        }
    }
}

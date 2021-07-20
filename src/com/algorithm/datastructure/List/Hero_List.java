package com.algorithm.datastructure.List;

public class Hero_List {
    Hero_node head = new Hero_node();
    Hero_node[] heros;
    public Hero_List(){
        heros = new Hero_node[10];
    }
    public Hero_List(int n){
        heros = new Hero_node[n];
    }
    public void add(int no, String name, String nickname){
        Hero_node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Hero_node(no, name, nickname);
    }

    public void add_no(int no, String name, String nickname){
        Hero_node temp = head;
        while(temp.next != null){
            if(temp.no == no) throw new RuntimeException("The no is already used");
            if(temp.next.no > no) break;
            temp = temp.next;
        }
        if(temp.no == no) throw new RuntimeException("The no is already used");
        temp.next = new Hero_node(no, name, nickname, temp.next);
    }

    public void update(int no, String name, String nickname){
        if(head.next == null){
            System.out.println("There is no node...");
            return;
        }
        Hero_node temp = head.next;
        while(temp != null){
            if(temp.no == no){
                temp.name = name;
                temp.nickname = nickname;
                System.out.println("Update! " + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("No such a node...");
    }

    public void delete(int no){
        Hero_node temp = head;
        while(temp != null){
            if(temp.next.no == no){
                System.out.println("Delete! " + temp.next);
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("No such a node...");
    }
    public void show(){
        if(head.next == null){
            System.out.println("There is no node...");
            return;
        }
        Hero_node temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        Hero_List h = new Hero_List();
        h.add(1, "宋江", "及时雨");
        h.add(2, "林冲", "豹子头");
        h.update(2, "吴用","智多星");
        h.show();
        h.delete(1);
        h.show();
    }

    class Hero_node{
        int no;
        String name;
        String nickname;
        Hero_node next;
        public Hero_node(){}
        public Hero_node(int no, String name, String nickname){
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        public Hero_node(int no, String name, String nickname, Hero_node next){
            this.no = no;
            this.name = name;
            this.nickname = nickname;
            this.next = next;
        }
        @Override
        public String toString(){
            return "HeroNode [no = " + no + ", name = " + name + ", nickname = " + nickname + "]";
        }
    }

}

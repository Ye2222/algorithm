package com.algorithm.datastructure.Hash_table;

import java.util.Scanner;

public class Hash_table {
    class EmpNode{
        String name;
        int id, sex, age;
        String address;
        EmpNode next;
        public EmpNode() {
        }

        public EmpNode(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public EmpNode(String name, int id, int sex, int age, String address) {
            this.name = name;
            this.id = id;
            this.sex = sex;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return "EmpNode{" +
                    "name='" + name + '\'' +
                    ", id=" + id + "}";
        }
    }
    class EmpLinkedList{
        public EmpNode head = null;
        public EmpLinkedList() {
        }

        public void add(EmpNode newNode) {
            if(head == null) {
                head = newNode;
                return;
            }
            EmpNode temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = newNode;
        }

        public void delete(int id) {
            if(head.id == id) {
                head = head.next;
            }
            EmpNode temp = head;
            while (temp.next != null) {
                if(temp.next.id == id){
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }
            System.out.println("No such a man...");
        }

        public EmpNode find(int id) {
            EmpNode temp = head;
            while (temp != null) {
                if(temp.id == id) return temp;
                temp =temp.next;
            }
            System.out.println("No such a man...");
            return null;
        }

        public void list(){
            if(head == null) {
                System.out.println("There is no emp!");
                return;
            }
            EmpNode temp = head;
            while(temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    public EmpLinkedList[] empLinkedLists;
    private static Hash_table h;
    private Hash_table() {
        empLinkedLists = new EmpLinkedList[10];
        // 注意初始化每一条链表
        for(int i = 0; i < 10; i++)
            empLinkedLists[i] = new EmpLinkedList();
    }

    public void add(EmpNode newNode) {
        int id = newNode.id;
        while(id / 10 != 0) id /= 10;
        if(empLinkedLists[id] == null) empLinkedLists[id].head = newNode;
        else empLinkedLists[id].add(newNode);
        System.out.println("Successfully add" + newNode);
    }

    public void list() {
        for(int i = 1; i < empLinkedLists.length; i++){
            if(empLinkedLists[i].head == null) continue;
            System.out.println("Id begin with " + (i)+" :");
            empLinkedLists[i].list();
        }
        System.out.println();
    }

    public void del(int id) {
        int temp = id;
        while(temp / 10 != 0) temp /= 10;
        empLinkedLists[temp].delete(id);
    }

    public void find(int id) {
        int temp = id;
        while(temp / 10 != 0) temp /= 10;
        empLinkedLists[temp].find(id);
    }

    public void menu() {
        Hash_table h = new Hash_table();

        while(true) {
            System.out.println("Select the function\n" +
                    "add(1) \t list(2) \t find(3) \t delete(4) \t exit(5)");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Input the id and name of the emp:");
                    id = s.nextInt();
                    String name = s.next();
                    h.add(new EmpNode(name, id));
                    break;
                case 2:
                    h.list();
                    break;
                case 3:
                    System.out.println("Input the id which you want to find");
                    id = s.nextInt();
                    h.find(id);
                    break;
                case 4:
                    System.out.println("Input the id which you want to delete");
                    id = s.nextInt();
                    h.del(id);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Input the right choice");
            }
        }
    }

    public static Hash_table getInstance(){
        if(h == null){
            h = new Hash_table();
        }
        return h;
    }
    public static void main(String[] args) {
        Hash_table Emplist = getInstance();
        Emplist.menu();
    }
}

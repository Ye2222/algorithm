package com.algorithm.datastructure;

import java.io.*;
import java.util.Scanner;

public class Sparse_array {
    int col = 0, row = 0;
    int count = 1;
    int[][] array;
    int[][] sparse_array;
    Scanner s = new Scanner(System.in);

    public Sparse_array(){}

    public Sparse_array(int row, int col){
        this.col = col;
        this.row = row;
        array = new int[row][col];
        sparse_array = new int[row*col+1][3];
        sparse_array[0][0] = row;
        sparse_array[0][1] = col;
    }

    public void add_number(){
        System.out.print("请输入要添加的数字的数目：");
        int times = s.nextInt();
        sparse_array[0][2] += times;
        for(int i = 0; i < times; i++) {
            System.out.println("输入你要添加的位置和数字");
            sparse_array[count][0] = this.s.nextInt();
            sparse_array[count][1] = this.s.nextInt();
            sparse_array[count][2] = this.s.nextInt();
            array[sparse_array[count][0]][sparse_array[count][1]] = sparse_array[count][2];
            this.count += 1;
        }
    }

    public void write_in(){
        File file  =new File("data/sparse_array.txt");
        try{
            FileWriter fos = new FileWriter(file);
            String first = "\trow\tcol\tnum\n";
            fos.write(first);
            for(int i = 0; i < count; i++){
                fos.write(Integer.toString(i));
                for(int j = 0; j < 3; j++) {
                    String s = Integer.toString(sparse_array[i][j]);
                    fos.write("\t" +s);
                }
            fos.write("\n");
            }
            fos.flush();
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void read_in(){
        int count = 0;
        try{
            File file  =new File("data/sparse_array.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while(line!=null){
                char[] chars = line.toCharArray();
                if(count == 0){
                    this.row = (int) chars[2] - '0';
                    this.col = (int) chars[4] - '0';
                    int nums = (int) chars[6] - '0';
                    this.array = new int[this.row][this.col];
                    this.sparse_array = new int[nums + 1][3];
                    this.sparse_array[count][0] = row;
                    this.sparse_array[count][1] = col;
                    this.sparse_array[count][2] = nums;
                }
                else{
                    int x = (int) chars[2] - '0';
                    int y = (int) chars[4] - '0';
                    int z = (int) chars[6] - '0';
                    this.array[x][y] = z;
                    this.sparse_array[count][0] = x;
                    this.sparse_array[count][1] = y;
                    this.sparse_array[count][2] = z;
                }
                line = bufferedReader.readLine();
                count++;
            }
            this.count = count;
            bufferedReader.close();
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void transfer(){

    }
    public void scan(){

    }


    public void print(){
        System.out.println("矩阵：");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                System.out.print(array[i][j] + "\t");
                System.out.println();
        }
        System.out.println("稀疏矩阵：");
        System.out.println("\t" + "row\t" + "col\t" + "num");
        for(int i = 0; i < count; i++){
            System.out.print( i +"\t");
            for(int j = 0; j < 3; j++){
                System.out.print(sparse_array[i][j] + "\t");
            }
                System.out.println();
        }
    }

    public static void main(String[] args) {
        Sparse_array s = new Sparse_array();
        s.read_in();
        s.print();
    }
}

package com.algorithm.algorithm.recursion;

public class eight_queen {
    static int num = 0;
    public static void solution(int[][] chessboard, int count){
        if(count == 8) {
            num++;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++)
                    System.out.print(chessboard[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < 8; i++){
            if(!not_attack(chessboard, count, i)) continue;
            chessboard[count][i] = 1;
            solution(chessboard, count+1);
            chessboard[count][i] = 0;
        }
    }
    public static boolean not_attack(int[][] chessborad, int row, int col){
        for(int i = 0; i < row; i++){
            if(chessborad[i][col] == 1) return false;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chessborad[i][j] == 1) return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++){
            if(chessborad[i][j] == 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] chessboard = new int[8][8];
        solution(chessboard, 0);
        System.out.println(num);
    }
}

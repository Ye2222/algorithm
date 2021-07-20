package com.algorithm.algorithm.recursion;

public class maze {
    public static boolean set_way(int[][] map, int i, int j){
        // 0:没有走过 1:墙 2:可以走，走过了 3:走过了，走不通
        if(map[6][6] == 2) return true;
        else{
            if(map[i][j] == 0)
            {
                // 下->右->上->左
                map[i][j] = 2;
                if(set_way(map, i+1, j)) return true; // 下
                else if(set_way(map, i, j+1)) return true; // 右
                else if(set_way(map, i-1, j)) return true; // 上
                else if(set_way(map, i, j-1)) return true; // 左
                else {
                    map[i][j] = 3;
                    return false;
                }
            }
            else return false;
        }
    }
    public static boolean set_way_2(int[][] map, int i, int j){
        // 0:没有走过 1:墙 2:可以走，走过了 3:走过了，走不通
        if(map[6][6] == 2) return true;
        else{
            if(map[i][j] == 0)
            {
                // 下->右->上->左
                map[i][j] = 2;
                if(set_way(map, i-1, j)) return true; // 上
                else if(set_way(map, i, j+1)) return true; // 右
                else if(set_way(map, i+1, j)) return true; // 下
                else if(set_way(map, i, j-1)) return true; // 左
                else {
                    map[i][j] = 3;
                    return false;
                }
            }
            else return false;
        }
    }
    public static void main(String[] args){
        int[][] map = new int[8][8];
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][7] = 1;
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[1][3] = 1;
        map[4][2] = 1;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                System.out.print(map[i][j]+ " ");
            System.out.println();
        }
        System.out.println();
//        set_way(map, 1, 1);
        set_way_2(map, 1, 1);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                System.out.print(map[i][j]+ " ");
            System.out.println();
        }

    }
}

package com.algorithm.algorithm;

public class LCS {
    public static void main(String[] args){
        String s1 = "cbacad", s2 = "accbadcb";
        int len1 = s1.length(), len2 = s2.length();
        int[][] lcs = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            lcs[i][0] = 0;
        }
        for(int i = 0; i <= len2; i++){
            lcs[0][i] = 0;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                Character a = s1.charAt(i-1), b = s2.charAt(j-1);
                if(a.equals(b)){
                    lcs[i][j] = lcs[i- 1][j - 1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        System.out.print(lcs[len1][len2]);

    }

}

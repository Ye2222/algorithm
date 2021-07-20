package com.compute;
import javax.script.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ScriptTest {

    public static String txt2String(File file){
        String res = "";
        try{
            BufferedReader br = new BufferedReader((new FileReader(file)));
            String s = null;
            while((s = br.readLine()) != null)
                res = res + "\n" + s;
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }



    public static void main(final String[] args) {


    }
}
package com.compute;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class compute {

    public String res;
    public List<Double> store = new ArrayList<>();

    public void output(){
        try {
            for (int count = 0; count < store.size(); count += 2) {
                double o1 = store.get(count);
                double o2 = store.get(count + 1);
                System.out.println(o1 / (220 * o2));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // 提取txt中的内容为String
    public static String txt2String(File file) {
        String result = "";
        try{
            BufferedReader br = new BufferedReader((new FileReader(file)));
            String s = null;
            while((s = br.readLine()) != null)
                result = result + "\n" + s;
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static void reg(String res){
        String regEx = "[^0-9]";  // 匹配除了0-9的字符
        Pattern p = Pattern.compile(regEx); // 预编译
        Matcher m = p.matcher(res); // 匹配
        System.out.println(m.replaceAll("").trim());
    }//得到的是连在一起的数字

    public static void get_StringNum(String res){
        List<String> digitList = new ArrayList<String>();
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(res);
        String result = m.replaceAll("");
        for(int i = 0; i < result.length(); i++)
            digitList.add(result.substring(i, i+1));
        System.out.println(digitList);
    }//将数字分割成一个一个

    // 判断一个字符串是否都为数字
    public boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }

    // 截断数字
    public void getNumbers(String content) {
        List<Double> l = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            Double d = Double.parseDouble(matcher.group(0));
            l.add(d);
        }
        store = l;
        System.out.println(l);
    }

    public static void compute(String content) {
        ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine engine = manager.getEngineByName("js");

        if (engine == null) {
            System.err.println("No engine for JavaScript");
            System.exit(1);
        }
        try {
            // 此行可变为从文件读入的表达式串。
            // String content = "2+3+4";
            System.out.print(content + " = ");
            Object result = engine.eval(content);
            // 类型转换要修正下。上面那样写一直报错
            String str = result+"";
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        compute g = new compute();
        String s = "输入0/1/2/3(0:退出; 1:读取文件; 2:公式计算; 3:计算式子):";

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(s);
            int choice = sc.nextInt();
            if(choice == 0){
                break;
            }
            else if(choice == 1){
                File file = new File("D:\\java_data\\2\\src\\com\\compute\\file.txt");
                g.res = txt2String(file);
                System.out.println(g.res);
                g.getNumbers(g.res);
            }
            else if(choice == 2) {
                g.output();
            }
            else if(choice == 3){
                System.out.println("输入1/2(1：手动输入一条式子 2：计算文件里的式子) 1不好用" );
                int com_choice = 2;
                if(com_choice == 1){
                    while(true) {
                        System.out.println("请输入式子： (输入0退出)");
                        String content = sc.next();
                        if(content.equals("0")) break;
                        compute(content);
                    }
                }
                else if(com_choice == 2){
                    File file = new File("D:\\java_data\\2\\src\\com\\compute\\file.txt");
                    try{
                        BufferedReader br = new BufferedReader((new FileReader(file)));
                        String content = null;
                        while((content = br.readLine()) != null)
                            compute(content);
                        br.close();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Exit...");
    }
}

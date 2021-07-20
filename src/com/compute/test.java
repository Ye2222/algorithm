package com.compute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String test = "0323 123";
        String s = "([0-9]+)";
        Pattern p = Pattern.compile(s);
        System.out.println(p);
        Matcher m = p.matcher(test);
        int c = m.groupCount();
        System.out.println(c);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            for (int i = 1; i <= c; i++) {
                m.appendReplacement(sb, "-");
                System.out.println(m.group(i));
                System.out.println("start："+ m.start(i));
                System.out.println("end："+ m.end());
            }
        }
        System.out.println("sb:"+ sb.toString());
    }
}

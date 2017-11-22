package com.example;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATestClass {

    public static void main(String[] args) {

        String line = "<em>A</em>B<em>C</em>DEFG";

        Pattern pattern = Pattern.compile("<.*?>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        List<EMItem> targetPosition = new ArrayList<>();
        List<String> matchStr = new ArrayList<>();
        while (matcher.find()) {
            targetPosition.add(new EMItem(matcher.start(), matcher.end()));
        }
        for (int i = 0; i < targetPosition.size(); i++) {
            //脚标有效
            if (i + 1 < targetPosition.size())
                //每个item的结束位置到下一个item的起始位置
                matchStr.add(line.substring(targetPosition.get(i).end, targetPosition.get(i + 1).start));
        }
        System.out.println();
        //整句
//        StringBuilder totalStr = new StringBuilder();
//        String[] split = line.split("<.*?>");
//        for (int i = 0; i < split.length; i++) {
//            if (split[i].length() != 0) {
//                totalStr.append(split[i]);
//            }
//        }
//        System.out.println(totalStr.toString());

    }

    public static class EMItem {

        public int start;
        public int end;

        public EMItem(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class B extends C {
    }

    public static class C {

    }
}

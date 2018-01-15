package com.example;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATestClass {

    public static void main(String[] args) {
        HashMap<Integer, Double> aa = new HashMap<>();

        Integer rand = getRand(aa, 1000);
        System.out.println(rand);
    }

    public static final Integer getRand(Map<Integer, Double> map, int multiple) {
        // 放大位数

        // 求和
        int sum = 0;
        Iterator<Map.Entry<Integer, Double>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Double> entry = iter.next();
            Double v = entry.getValue();
            sum += v * multiple;
        }

        if (sum <= 0) {
            return 0;
        }

        // 产生0-sum的整数随机
        int luckNum = new Random().nextInt(sum) + 1;
        int tmp = 0;
        iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Double> entry = iter.next();
            Double v = entry.getValue();
            tmp += v * multiple;
            if (luckNum <= tmp) {
                return entry.getKey();
            }
        }
        return null;
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

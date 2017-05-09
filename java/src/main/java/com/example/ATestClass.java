package com.example;

import java.util.HashMap;
import java.util.Map;

public class ATestClass {

    public static void main(String[] args) {


        String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/{size}/{page}/{fuck}";
        Map<String, String> paths = new HashMap<>();
        paths.put("size", "20");
        paths.put("page", "1");
        paths.put("fuck", "2");


        System.out.println(getPathUrl(url, paths));

    }

    public static String getPathUrl(String Ourl, Map<String, String> paths) {

        String url = Ourl;
        for (Map.Entry<String, String> entry : paths.entrySet()) {

            url = url.replace("{" + entry.getKey() + "}", entry.getValue());

        }
        return url;

    }

    public static class A {

    }

    public static class B extends A {
    }
}

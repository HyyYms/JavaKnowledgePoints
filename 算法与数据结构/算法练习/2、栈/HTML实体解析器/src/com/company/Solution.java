package com.company;

import java.util.HashMap;

/**
 * @program: HTML实体解析器
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-26 20:52
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().entityParser1("and I quote: &quot;...&quot;"));
    }

    public String entityParser2(String text) {
        text = text.replaceAll("&quot;", "\"");
        text = text.replaceAll("&apos;", "'");
        text = text.replaceAll("&gt;", ">");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&frasl;", "/");
        text = text.replaceAll("&amp;", "&");
        return text;
    }

    public String entityParser1(String text) {
        if (text == null || text.length() == 0) {
            return text;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '&') {
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(j) == ';') {
                        String ch = text.substring(i, j + 1);
                        String word = map.get(ch);
                        if (word != null) {
                            sb = sb.replace(i, j + 1, word);
                        }
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

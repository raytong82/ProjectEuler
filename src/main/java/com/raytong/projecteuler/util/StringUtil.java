package com.raytong.projecteuler.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private StringUtil() {
    }
    
    public static List<String> retrieveCombination(String prefix, String str) {
        if (str.length() == 1) {
            String s = prefix.concat(str);
            List<String> result = new ArrayList<String>();
            result.add(s);
            return result;
        }
        List<String> combination = new ArrayList<String>();
        for (int i=0; i<str.length(); i++) {
            StringBuilder prefixSb = new StringBuilder(prefix.length() + 1);
            prefixSb.append(prefix);
            prefixSb.append(str.charAt(i));
            StringBuilder suffixSb = new StringBuilder(str.length() - 1);
            if (i > 0) { 
                suffixSb.append(str.substring(0, i));
            }
            if (i < str.length() - 1) {
                suffixSb.append((str.substring(i + 1)));
            }
            List<String> newStrList = retrieveCombination(prefixSb.toString(), suffixSb.toString());
            combination.addAll(newStrList);
        }
        return combination;
    }
    
    public static List<String> retrieveCircular(String str) {
        List<String> circularList = new ArrayList<String>();
        for (int i=0; i<str.length(); i++) {
            StringBuilder newStrSb = new StringBuilder(str.length());
            newStrSb.append(str.substring(i));
            newStrSb.append(str.substring(0, i));
            circularList.add(newStrSb.toString());
        }
        return circularList;
    }
    
    public static List<String> retrieveTruncated(String str) {
        List<String> truncatedList = new ArrayList<String>();
        truncatedList.add(str);
        for (int i=1; i<str.length(); i++) {
            truncatedList.add(str.substring(i));
            truncatedList.add(str.substring(0, i));
        }
        return truncatedList;
    }
}

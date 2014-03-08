package com.raytong.projecteuler;

import com.raytong.projecteuler.util.StringUtil;

import java.util.List;

public class Problem24 {
    public static void main(String[] args) {
        List<String> newStrList = StringUtil.retrieveCombination("", "0123456789");
        //for (String s : newStrList) {
        //    System.out.println(s);
        //}
        System.out.println(newStrList.get(1000000-1));
    }
    
    
}

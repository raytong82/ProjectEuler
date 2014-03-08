package com.raytong.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        br.close();
        fr.close();
        String[] names = line.split("[\",]+");
        List<String> firstNameList = Arrays.asList(names);
        Collections.sort(firstNameList);
        long totalScore = 0;
        for (int i=0; i<firstNameList.size(); i++) {
            String name = firstNameList.get(i);
            int score = 0;
            for (int l=0; l<name.length(); l++) {
                score += name.charAt(l) - 'A' + 1;
            }
            totalScore += score * i;
            System.out.println("name=[" + name + "], i=[" + i + "], score=[" + score + "]");
        }
        System.out.println(">>>" + totalScore);
    }
}

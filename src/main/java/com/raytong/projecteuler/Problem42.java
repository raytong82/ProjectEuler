package com.raytong.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Problem42 {
    public static void main(String[] args) throws Exception {
        Set<Integer> triangleSet = new HashSet<Integer>() {{
            add(1);
            add(3);
            add(6);
            add(10);
            add(15);
            add(21);
            add(28);
            add(36);
            add(45);
            add(55);
            }};
        int maxTriangleNum = 55;
        int n = 10;
            
        FileReader fr = new FileReader("words.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        br.close();
        fr.close();
        int triangleNum = 0;
        String[] texts = line.split("[\",]+");
        for (String text : texts) {
            int score = calScore(text);
            while (score > maxTriangleNum) {
                n++;
                maxTriangleNum = n * (n + 1) / 2;
                triangleSet.add(maxTriangleNum);
            }
            if (triangleSet.contains(score)) {
                triangleNum++;
            }
        }
        System.out.println(">>>" + triangleNum);
    }
    
    private static int calScore(String s) {
        int score = 0;
        for (int i=0; i<s.length(); i++) {
            score += s.charAt(i) - 'A' + 1;
        }
        return score;
    }
}

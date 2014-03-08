package com.raytong.projecteuler;

import java.io.File;
import java.util.Scanner;

public class Problem67 {
    public static void main(String[] args) throws Exception {
        int p[][] = new int[100][100];
        int row = 0;
        int col = 0;
        Scanner scanner = new Scanner(new File("triangle.txt"));
        while (scanner.hasNextInt()) {
            p[row][col++] = scanner.nextInt();
            if (col > row) {
                col = 0;
                row++;
            }
        }
        for (int r=p.length-2; r>=0; r--) {
            for (int c=0; c<=r; c++) {
                p[r][c] += Math.max(p[r+1][c], p[r+1][c+1]);
            }
        }
        System.out.println(p[0][0]);
    }
}

package com.raytong.projecteuler;

public class Problem15 {
    public static void main(String[] args) {
        long f[][] = new long[21][21];
        f[1][1] = 1;
        for (int i=2; i<f.length; i++) {
            for (int j=1; j<i; j++) {
                for (int k=1; k<=j; k++) {
                    f[i][j] += f[i-1][k];
                }
            }
            for (int k=1; k<i; k++) {
                f[i][i] += f[i-1][k];
            }
            f[i][i] *= 2;
        }
        
        for (int i=1; i<f.length; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(f[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println(">>>");
        long sum = 0;
        for (int i=1; i<f.length; i++) {
            sum += f[20][i];
        }
        sum *= 2;
        System.out.println(sum);
    }
}

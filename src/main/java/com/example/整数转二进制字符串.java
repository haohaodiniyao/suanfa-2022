package com.example;

public class 整数转二进制字符串 {
    public static void main(String[] args) {
        String ans = "";
        int a = 11;
        while(a>0){
            ans = a%2 + ans;
            a = a/2;
        }
        //1011
        System.out.println("ans = "+ans);
    }
}

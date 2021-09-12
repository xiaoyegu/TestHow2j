package com.how2j.test;

import java.util.Scanner;

class SumTest{
    //首先可以输入字符串
    //根据空格分割字符串
    //将分割的字符串用Integer类转换为数值类型（个数控制为2以上，否则返回错误）
    //将两数相加
    //该整数循环
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] arr = str.split("\\s+");//根据空格分割字符串
        int sum = 0;
        try {
            for(String ss : arr){
                sum += Integer.parseInt(ss);
            }
        }catch (Exception e){
            System.out.println("输入有误");
        }
        System.out.println(sum);
        sum = 0;
    }

}


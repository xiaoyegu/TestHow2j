package com.how2j.集合框架.Arraylist;

import com.how2j.集合框架.Hero;

import java.util.ArrayList;

public class TestDifferenceOfArray {
    public static void main(String[] args) {

    }

    //使用数组的局限性
//    如果要存放多个对象，可以使用数组，但是数组有局限性
//    比如 声明长度是10的数组
//    不用的数组就浪费了
//    超过10的个数，又放不下

    //ArrayList存放对象
//    为了解决数组的局限性，引入容器类的概念。 最常见的容器类就是
//            ArrayList
//    容器的容量"capacity"会随着对象的增加，自动增长
//    只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
    public static void ArrayListStoreObject(){
        //容器类ArrayList，用于存放对象
        ArrayList heros = new ArrayList();
        heros.add(new Hero("盖伦"));
        System.out.println(heros.size());
        //容器的容量"capacity"会随着对象的增长，自动增加，
        //不用担心数组的边界问题
        heros.add(new Hero("剑仙"));
        System.out.println(heros.size());

    }
}

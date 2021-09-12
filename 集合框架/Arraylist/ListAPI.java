package com.how2j.集合框架.Arraylist;

import com.how2j.集合框架.Hero;

import java.util.ArrayList;
import java.util.List;

public class ListAPI {
    public static void main(String[] args) {


    }

    //ArrayList和List
    /*ArrayList实现了接口List
常见的写法会把引用声明为接口List类型
注意：是java.util.List,而不是java.awt.List
     */
    public static void ListApi(){
        //ArrayList实现了接口List

        //常见的写法会把引用声明为接口List类型
        //注意：是java.util.List,而不是java.awt.List
        //接口引用指向子类对象（多态）

        List heros = new ArrayList();
        heros.add( new Hero("盖伦"));
        System.out.println(heros.size());
    }
}

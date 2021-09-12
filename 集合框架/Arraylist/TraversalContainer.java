package com.how2j.集合框架.Arraylist;

import com.how2j.集合框架.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraversalContainer {

    //有三种方法可以遍历容器内的元素
    public static void main(String[] args) {
        useForTraversal();
        useIteratorTraversal();
        useFor2Traversal();
    }
    //第一种，用for循环来遍历
    public static void useForTraversal(){
        List<Hero> heroes = new ArrayList<Hero>();
        //放入五个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("Hero name "+i));

        }
        //第一钟遍历for循环
        System.out.println("---------for 循环---------");
        for (int i = 0; i < heroes.size(); i++) {
            Hero h = heroes.get(i);
            System.out.println(h);

        }
    }
    //第二种，迭代器遍历
    public static void useIteratorTraversal(){
        List<Hero> heros = new ArrayList<Hero>();

        //放5个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero name " +i));
        }

        //第二种遍历，使用迭代器
        System.out.println("--------使用while的iterator-------");

        Iterator<Hero> it = heros.iterator();
        //从最开始的位置判断“下一个”位置是否有数据
        //如果有就通过next取出来，并且把指针向下移动
        //直到“下一个”位置没有数据
        while(it.hasNext()){
            Hero h = it.next();
            System.out.println(h);
        }
        //迭代器的for写法
        for(Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();) {
            Hero hero = (Hero)iterator.next();
            System.out.println(hero);
        }
    }
    //第三种，用增强型for循环
    public static void useFor2Traversal(){
        List<Hero> heros = new ArrayList<Hero>();

        // 放5个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero name " + i));
        }

        // 第三种，增强型for循环
        System.out.println("--------增强型for循环-------");
        for (Hero h : heros) {
            System.out.println(h);
        }
    }
}

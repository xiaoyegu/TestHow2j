package com.how2j.集合框架.Arraylist;

import com.how2j.集合框架.Hero;

import java.util.ArrayList;

public class TestArrayListMethod {
    public static void main(String[] args) {

        System.out.println("--------------add---------------");
        add();
        System.out.println("--------------contains---------------");
        contains();
        System.out.println("--------------get---------------");
        get();
        System.out.println("--------------indexOf---------------");
        indexOf();
    }

    //常用的方法
    /*
    add      增加
    contains 判断是否存在
    get      获取指定位置的对象
    indexOf  获取对象所处的位置
    remove   删除
    set      替换
    size     获取大小
    toArray  转换为数组
    addAll   把另一个容器里面所有的对象都加进来
    clear    清空
     */

    //增加
    public static void add() {
        ArrayList heros = new ArrayList();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero "+i));
        }
        System.out.println(heros);

        //在指定位置添加对象
        Hero special_hero = new Hero("special hero");
        heros.add(3,special_hero);
        System.out.println(heros.toString());
    }

    //判断是否存在
    public static void contains() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);

        //判断一个对象是否在容器中
        //判断标准：是否是同一个对象，而不是name是否相同
        System.out.print("虽然一个新的对象名字也叫 hero 1，但是contains的返回是:");
        System.out.println(heros.contains(new Hero("hero 1")));
        System.out.print("而对specialHero的判断，contains的返回是:");
        System.out.println(heros.contains(specialHero));
    }

    //  获取指定位置的对象
    public static void get() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        //获取指定位置的对象
        System.out.println(heros.get(5));
        //如果超出了范围，依然会报错
//        System.out.println(heros.get(6));
    }

    //获取对象所处的位置
    public static void indexOf() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("specialHero所处的位置:"+heros.indexOf(specialHero));
        System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:"+heros.indexOf(new Hero("hero 1")));

    }

    //删除
    public static void remove() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        heros.remove(2);
        System.out.println("删除下标是2的对象");
        System.out.println(heros);
        System.out.println("删除special hero");
        heros.remove(specialHero);
        System.out.println(heros);
    }

    public static void set() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("把下标是5的元素，替换为\"hero 5\"");
        heros.set(5, new Hero("hero 5"));
        System.out.println(heros);
    }

    public static void size() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);
        System.out.println(heros);
        System.out.println("获取ArrayList的大小：");
        System.out.println(heros.size());
    }

    public static void toArray() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);
        System.out.println(heros);
        Hero hs[] = (Hero[])heros.toArray(new Hero[]{});
        System.out.println("数组:" +hs);
    }

    public static void addAll() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }

        System.out.println("ArrayList heros:\t" + heros);

        //把另一个容器里所有的元素，都加入到该容器里来
        ArrayList anotherHeros = new ArrayList();
        anotherHeros.add(new Hero("hero a"));
        anotherHeros.add(new Hero("hero b"));
        anotherHeros.add(new Hero("hero c"));
        System.out.println("anotherHeros heros:\t" + anotherHeros);
        heros.addAll(anotherHeros);
        System.out.println("把另一个ArrayList的元素都加入到当前ArrayList:");
        System.out.println("ArrayList heros:\t" + heros);

    }

    public static void clear() {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }

        System.out.println("ArrayList heros:\t" + heros);
        System.out.println("使用clear清空");
        heros.clear();
        System.out.println("ArrayList heros:\t" + heros);
    }
}

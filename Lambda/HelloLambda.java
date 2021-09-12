package com.how2j.Lambda;

import com.how2j.集合框架.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloLambda {

    //本章有以下元素：普通方法，匿名类，Lambda
    public static void main(String[] args) {
        testLambda();
    }
    //普通方法
    public static void testMethodsCommon(){
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("hero "+i,r.nextInt(1000),r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heroes);
        System.out.println("筛选出hp>100&&damange<50的英雄");
        filter(heroes);
    }
    private static void filter(List<Hero> heroes){
        for (Hero hero : heroes){
            if (hero.hp>100 && hero.damage<50){
                System.out.println(hero);
            }
        }
    }
    //匿名类
    public static void testAnonymousc(){
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp>100 && h.damage<50);
            }
        };
        filter(heros,checker);
    }
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
    //Lambda
    /*
        与匿名类 概念相比较，
        Lambda 其实就是匿名方法，这是一种把方法作为参数进行传递的编程思想。

        虽然代码是这么写

        filter(heros, h -> h.hp > 100 && h.damage < 50);


        但是，Java会在背后，悄悄的，把这些都还原成匿名类方式。
        引入Lambda表达式，会使得代码更加紧凑，而不是各种接口和匿名类到处飞。
     */
    public static void testLambda(){
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
        filter(heros,h->h.hp>100 && h.damage<50);
    }
}

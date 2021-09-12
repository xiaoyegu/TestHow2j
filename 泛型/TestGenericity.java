package com.how2j.泛型;

import java.util.ArrayList;

//public class TestGenericity extends Integer {
//    public static void main(String[] args) {
//
//
//    }
//
//    //使用泛型是为了将同类类（抽象类，接口）放入容器，不要将不同的混淆
//    //假设容器的泛型是Hero,那么Hero的子类APHero,ADHero都可以放进去
//    //和Hero无关的类型Item还是放不进去
//    //为了不使编译器出现警告，需要前后都使用泛型，像这样：
//    //ArrayList<Hero> heros = new ArrayList<Hero>();
//
//    public static void testGenericity(){
//        ArrayList<APHero> heros = new ArrayList<APHero>();
//
//        //只有APHero可以放进去
//        heros.add(new APHero());
//
//        //ADHero甚至放不进去
//        //heros.add(new ADHero());
//
//        //获取的时候也不需要进行转型，因为取出来一定是APHero
//        APHero apHero =  heros.get(0);
//    }
//
//
//    //练习-设计一个集合，这个集合里面可以放整数，也可以放浮点数，就是不能放字符串
//    public static void testNumberCollection(){
//        Integer i ;
//        Double o;
//
//    }
//}

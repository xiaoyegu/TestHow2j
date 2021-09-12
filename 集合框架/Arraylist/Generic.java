package com.how2j.集合框架.Arraylist;

import com.how2j.集合框架.Hero;

import java.util.ArrayList;

public class Generic {
    public static void main(String[] args) {


    }

    //泛型Generic
//    不指定泛型的容器，可以存放任何类型的元素
//    指定了泛型的容器，只能存放指定类型的元素以及其子类
    public static void testCollection(){
        //对于不适用泛型的容器，可以往里面放英雄，也可以往里面放物品
        ArrayList heros = new ArrayList();
        heros.add(new Hero("盖伦"));
        //本来用于存放英雄的容器，现在也可以放物品了

        //对象桩型会出现问题

        //尤其是在容器里面放入的对象太多的时候，就记不清哪个位置放置的是哪种类型的容器了

        //引入泛型Generic
        //声明容器的时候，就指定了这种容器，只能放Hero，放其他的就会出错

        //如果不是Hero类型，根本就放不进去

        //除此之外i，还能存放Hero的子类

        //并且在取数据的时候，不需要在进行转型了，因为里面肯定放的是Hero或者其子类


    }

}

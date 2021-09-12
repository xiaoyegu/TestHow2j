package com.how2j.输入输出流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//什么是流
/*
什么时候用字节流，什么时候用字符流？？？
1、定义不同;
2、结尾不同;
3、处理方式不同;
4、缓冲区不同;
5、编码方式不同。
字节流 默认不使用缓冲区,而 字符流 使用缓冲区。
字节流 采用ASCII编码, 字符流 采用unicode编码。
 */
public class TestStream {
    public static void main(String[] args) {

    }
    //建立一个文件输入流
    public static void fileInStream(){
        try {
            File f = new File("C:\\windows");
            FileInputStream fis = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }
    //创建一个文件输出流
    public static void fileOutStream(){
        File f = new File("C:\\windows");
        try {
            FileOutputStream fis = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

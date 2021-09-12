package com.how2j.输入输出流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class TestCharacterStream {
    public static void main(String[] args) {
        File f = new File("D:\\Desktop\\ab.txt");
//        readFileByFileReader(f);
        writeFileByFileReader(f);

    }

    //使用字符流读取文件
    public static void readFileByFileReader(File f){
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            //创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            //以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b:all
            ) {
                //打印出来是AB
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fr!=null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    System.out.println("没有文件");
                }
            }
        }
    }

    //使用字符流把字符串写入到文件
    public static void writeFileByFileReader(File f){
        FileWriter fr = null;
        try {
            //创建基于文件的writer
            fr = new FileWriter(f);
            //以字符流的形式把数据写入到文件中
            String data = "abcdefg1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fr!=null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    System.out.println("没有文件");
                }
            }
        }
    }
}

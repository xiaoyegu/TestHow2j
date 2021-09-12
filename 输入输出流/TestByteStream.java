package com.how2j.输入输出流;

import java.io.*;
import java.util.Arrays;

/*
InputStream字节输入流
OutputStream字节输出流
用于以字节的形式读取和写入数据
 */
public class TestByteStream {
    public static void main(String[] args) {
//        printASCⅡ();//ASCⅡ码表的输出
        File f = new File("D:\\Desktop\\ab.txt");
        File f1 = new File("D:\\Desktop\\Desktop\\ab.txt");
//        readFileByInputStream(f);
//        writeFileByInputStream(f);
//        writeFileByInputStreamAutoCreateFolders(f1);
        int eachSize = 100 * 1024; // 100k
        File srcFile = new File("C:\\Users\\86153\\Downloads\\Free_Loop-Daniel_Powter-9898924.mp3");
        splitFile(srcFile, eachSize);
    }


    //ASCⅡ码表的输出
    /*
    所有的数据存放在计算机中都是以数字的形式存放的。 所以字母就需要转换为数字才能够存放。
比如A就对应的数字65，a对应的数字97. 不同的字母和符号对应不同的数字，就是一张码表。
ASCII是这样的一种码表。 只包含简单的英文字母，符号，数字等等。 不包含中文，德文，俄语等复杂的。
     */
    public static void printASCⅡ(){
        System.out.println("字符\t"+"十进制\t"+"十六进制\t");
        for (int i = 33; i < 127; i++) {
            System.out.println((char)i+"\t\t"+i+"\t\t"+Integer.toHexString(i));
        }
    }

    //以字节流的形式读取文件内容
    //InputStream 是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现
    //FileInputStream是InputStream子类，以FileInputStream为例进行文件读取
    public static void readFileByInputStream(File f){
        //准备文件
        FileInputStream fis = null;
        try {
            //创建基于文件的输入流
            fis = new FileInputStream(f);
            //创建字节数组，其长度就是文件的长度
            byte[] all = new byte[(int) f.length()];
            //以字节流的形式读取文件所有内容
            fis.read(all);
            for (byte b:all) {
                System.out.println((char)b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //每次用完流，都应该进行关闭
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //以字节流的形式向文件写入数据
//    OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
//    FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
//
//    注: 如果文件d:/lol2.txt不存在，写出操作会自动创建该文件。
//    但是如果是文件 d:/xyz/lol2.txt，而目录xyz又不存在，会抛出异常
    public static void writeFileByInputStream(File f){

        //创建基于文件的输出流
        FileOutputStream fos = null;
        try {
            //准备长度是2的字节数组，用88，89初始化，其对应的字符分别是XY
            byte[] data = {
                    88,89
            };
            fos = new FileOutputStream(f);
            //把数据写入到输出流
            fos.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //使用完关闭输出流
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //练习-写入数据到文件
//    以字节流的形式向文件写入数据 中的例子，当lol2.txt不存在的时候，是会自动创建lol2.txt文件的。
//    但是，如果是写入数据到d:/xyz/lol2.txt，而目录xyz又不存在的话，就会抛出异常。
//    那么怎么自动创建xyz目录？
//    如果是多层目录 d:/xyz/abc/def/lol2.txt 呢？
    public static void writeFileByInputStreamAutoCreateFolders(File f){

        FileOutputStream fos = null;
        try {
            //获取文件所在 的目录
            //如果该目录不存在，则创建该目录
            if(!f.getParentFile().exists()){
                //使用mkdirs则会把不存在的目录都创建好
                f.getParentFile().mkdirs();
            }
            //准备长度是2的字节数组，用88，89初始化，其对应的字符分别是XY
            byte[] data = {
                    88,89
            };
            fos = new FileOutputStream(f);
            //把数据写入到输出流
            fos.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //使用完关闭输出流
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //练习-拆分文件
//    找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
//    比如文件 eclipse.exe，大小是309k。
//    拆分之后，成为
//    eclipse.exe-0
//    eclipse.exe-1
//    eclipse.exe-2
//    eclipse.exe-3
    /**
     * 拆分的思路，先把源文件的所有内容读取到内存中，然后从内存中挨个分到子文件里
     * @param srcFile 要拆分的源文件
     * @param eachSize 按照这个大小，拆分
     */
    private static void splitFile(File srcFile, int eachSize){
        if(0 == srcFile.length())
            throw new RuntimeException("文件长度为0，不可拆分");
        byte[] fileContent = new byte[(int) srcFile.length()];
        //先把文件读取到数组
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(srcFile);
            fis.read(fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //计算需要被划分成多少分子文件
        int fileNumber;
        //文件是否能被整除得到的文件个数是不是一样的
        //（假设文件长度是25，每份的大小是5，那么就是5个
        //（假设文件长度是26，每份的大小是5，那么就是6个
        if(0 == fileContent.length % eachSize){
            fileNumber = (int)(fileContent.length/eachSize);
        }else {
            fileNumber = (int)(fileContent.length/eachSize)+1;
        }
        //创建这么多个子文件
        for (int i = 0; i < fileNumber; i++) {
            String eachFileName = srcFile.getName() + "-" +i;
            File eachFile = new File(srcFile.getParent(), eachFileName);
            byte[] eachContent;
            //从源文件的内容里面，复制部分数据到子文件
            //除开最后一个文件，其他文件大小都是100k
            //最后一个文件的大小都是剩余的
            if(i != fileNumber - 1)//不是最后一个
                eachContent = Arrays.copyOfRange(fileContent,eachSize*i,eachSize*(i+1));
            else //最后一个
                eachContent = Arrays.copyOfRange(fileContent,eachSize*i,fileContent.length);
            try {
                // 写出去
                FileOutputStream fos = new FileOutputStream(eachFile);
                fos.write(eachContent);
                // 记得关闭
                fos.close();
                System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

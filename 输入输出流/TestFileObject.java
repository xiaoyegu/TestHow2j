package com.how2j.输入输出流;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFileObject {
    public static void main(String[] args) {
        //遍历文件夹方法
        //给出最大文件和最小文件（不包含文件夹）
        traverseFolder("C:\\windows");
    }

//    一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。
//
//    遍历这个目录下所有的文件(不用遍历子目录)
//
//    找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
    public static void traverseFolder(String path){
        File f = new File(path);
        File[] fs = f.listFiles();
        //如果文件夹为空则返回
        if(null==fs)
            return;
        long minSize = Integer.MAX_VALUE;
        long maxSize = 0;
        File minFile = null;
        File maxFile = null;
        for(File file : fs){
            if (file.isDirectory())
                continue;
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0 && file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }

        }
        System.out.println("最大文件是"+maxFile.getAbsolutePath()+"，其大小是"+maxFile.length()+"字节");
        System.out.println("最小文件是"+minFile.getAbsolutePath()+"，其大小是"+minFile.length()+"字节");

    }

}
class 创建一个文件对象{
    public static void test01(){
        File f1 = new File("D:\\Desktop\\ab.txt");
        //获取文件的相对路径
        System.out.println("文件的绝对路径"+
                f1.getAbsolutePath());
        //把f2作为父目录船舰文件对象
        File f2 = new File("D:\\Desktop\\abcd");
        File f3 = new File(f2, "abc.txt");
        System.out.println("f3的绝对路径"+
                f3.getAbsolutePath());
    }
}
class  文件夹常用的方法{
    public void test01(){
        File f = new File("D:\\Desktop");
        System.out.println("当前的文件是"+f);
        //文件是否存在
        f.exists();
        //是否是文件夹
        f.isDirectory();
        //是否是文件（非文件夹）
        f.isFile();
        //文件长度
        f.length();
        //文件最后修改时间
        f.lastModified();
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println(d);
        //设置文件修改时间为时间戳零时
        f.setLastModified(0);
        //文件重命名
        File f2 = new File("");
        f.renameTo(f2);
    }
    public void test02(){
        File f = new File("D:\\Desktop\\abc");
        //以字符串数组的形式，返回当前文件夹下的所有文件（不不包含子文件及子文件夹）
        f.list();
        //以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及文件夹）
        File[] fs = f.listFiles();
        //以字符串形式返回获取所在文件夹
        f.getParent();
        //以文件形式返回获取所在文件夹
        f.getParentFile();
        //创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();
        //创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();
        //创建一个空文件，如果fuwenjianskin不存在，就会抛出异常
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();
        //列出所有的盘符c:D:E:
        f.listRoots();
        //删除文件
        f.delete();
        //jvm结束时候，删除文件，常用于临时文件的删除
        f.deleteOnExit();
    }
}

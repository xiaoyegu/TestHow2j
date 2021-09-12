package com.how2j.输入输出流;

import java.io.*;
import java.nio.charset.Charset;

public class TestChinese {
    public static void main(String[] args) {
        String str = "中";
//        unicodeChinese("中文");
//        showCode(str);
        File f = new File("D:\\Desktop\\ab.txt");
        readChineseByFileInputStream(f);
    }

    //Java采用的是Unicode
    //写在.java源代码中的汉字，在执行之后，都会变成JVM中的字符。
    // 而这些中文字符采用的编码方式，都是使用UNICODE. "中"字对应的UNICODE是4E2D,所以在内存中，实际保存的数据就是十六进制的0x4E2D, 也就是十进制的20013。
    public static void unicodeChinese(String strint){
        char[] chars = strint.toCharArray();
        for (char aChar : chars) {
            System.err.println("char字符:"+aChar);
            String x = Integer.toHexString(aChar);
            if (x.length() <= 2) {
                x = "\\u00" + x;
            } else {
                x = "\\u" + x;
            }
            System.err.println("unicode码" + x);
        }
    }

    //一个汉字使用不同编码方式的表现
    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);

        }

    }
    //一个汉字使用不同编码方式的表现
    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }

    //用FileInputStream 字节流正确读取中文
    public static void readChineseByFileInputStream(File f){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            System.out.println("默认编码方式:"+ Charset.defaultCharset());
            byte[] all = new byte[(int) f.length()];
            fis.read(all);

            //文件中读出来的数据是
            System.out.println("文件中读出来的数据是:");
            for (byte b:all
                 ) {
                int i = b&0x000000ff;//只取16进制中的后两位
                System.out.println("把这个数字，放在UTF-8的上：");
                String str = new String(all,"UTF-8");
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

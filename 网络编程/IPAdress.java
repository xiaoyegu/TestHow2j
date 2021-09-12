package com.how2j.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAdress {
    public static void main(String[] args) {
        try {
            testGetHostAddress();
            testexe();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void testGetHostAddress() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        System.out.println("本机ip地址：" + ip);
    }

    public static void testexe() throws IOException {
        Process p = Runtime.getRuntime().exec("ping baidu.com");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }
}

package com.czxy.io;

import java.io.*;

public class testFileInput {
    public static void main(String[] args) throws IOException {
        /**
         * 从输入流中读取数据的下一个字节（一次读取一个字节）
         *  abstract int read()
         *
         * 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b中
         *  int read(byte[] b)
         *
         * 将输入流中最多 len 个数据字节读入 byte 数组
         *  int read(byte[] b, int off, int len)
         *
         * 跳过和丢弃此输入流中数据的 n个字节
         * long skip(long n)
         *
         * 关闭此输入流并释放与该流关联的所有系统资源（关闭流）
         * void close()
         */
        //构造方法1
        //通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的File对象file指定
        InputStream inputStream = new FileInputStream(new File("G://javaTest/testIO.txt"));
        int i=0;

        //跳过2个字节
        inputStream.skip(2);
        //一次读取一个字节
        while ((i=inputStream.read())!=-1){
            System.out.println(i);  //97,98,99,100  字符在底层存储的时候就是存储的数值。即字符对应的ASCII码。
            System.out.println((char) i);  //asdf
        }


        //关闭IO流
        inputStream.close();

        //构造方法二
        InputStream inputStream2 = new FileInputStream("G://javaTest/testIO.txt");
        //字节数组
        byte[] b=new byte[3];
        //读取的字节长度
        int i2 = 0;

        while ((i2=inputStream2.read(b))!=-1){
            System.out.println("构造方法二:"+new String(b,0,i2));
        }

        inputStream2.close();


    }
}

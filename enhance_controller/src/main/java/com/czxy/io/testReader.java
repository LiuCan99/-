package com.czxy.io;

import org.junit.Test;

import java.io.*;

public class testReader {

    public static void main(String[] args) throws IOException {
        /**
         * Reader:读取字符流的抽象类.
         * 常用方法：
         * 读取单个字符
         * int read()
         *
         * 将字符读入数组
         * int read(char[] cbuf)
         *
         * 将字符读入数组的某一部分
         * abstract int read(char[] cbuf, int off, int len)
         *
         * 跳过字符
         * long skip(long n)
         *
         * 关闭该流并释放与之关联的所有资源
         * abstract void close()
         */

        /**
         * InputStreamReader：字节流转字符流，
         *      它使用的字符集可以由名称指定或显式给定，否则将接受平台默认的字符集。
         *
         * 构造方法：
         *创建一个使用默认字符集的 InputStreamReader
         *InputStreamReader(InputStream in)
         *
         *创建使用给定字符集的 InputStreamReader
         *InputStreamReader(InputStream in, Charset cs)
         *
         *创建使用给定字符集解码器的 InputStreamReader
         *InputStreamReader(InputStream in, CharsetDecoder dec)
         *
         *创建使用指定字符集的 InputStreamReader
         *InputStreamReader(InputStream in, String charsetName)
         *
         * 特有方法：
         *返回此流使用的字符编码的名称
         *String getEncoding()
         */

        //使用默认编码
        InputStreamReader reader = new InputStreamReader(new FileInputStream("G://javaTest/testIO_02.txt"));
        int len ;
        while ((len=reader.read())!=-1){
            System.out.println((char) len);
        }

        reader.close();

        //指定编码
        /**
         * Eclipse默认使用GBK编码,test.txt文件所以是GBK编码，当指定utf-8编码时所以会乱码。
         */
        InputStreamReader reader2 = new InputStreamReader(new FileInputStream("G://javaTest/testIO_02.txt"),"utf-8");
        int len2;
        while ((len2=reader2.read())!=-1){
            System.out.println((char) len2);
        }

        reader2.close();


        /**
         * BufferedReader：字符缓冲流，从字符输入流中读取文本，缓冲各个字符，
         *      从而实现字符、数组和行的高效读取。
         *
         *  构造方法：
         * 创建一个使用默认大小输入缓冲区的缓冲字符输入流
         * BufferedReader(Reader in)
         * 创建一个使用指定大小输入缓冲区的缓冲字符输入流
         * BufferedReader(Reader in, int sz)
         *
         *  特有方法：
         *     // 读取一个文本行
         *     String readLine()
         *
         */

         //生成字符缓冲流对象 = new 字符高效流（new 字节流转字符流（new 字节文件输入流））
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("G://javaTest/testIO_02.txt")));
        String str;

        //一次读一行
        while ((str=bufferedReader.readLine())!=null){
            System.out.println(str);
        }
    }

}

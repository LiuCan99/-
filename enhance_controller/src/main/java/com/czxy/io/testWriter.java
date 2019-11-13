package com.czxy.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class testWriter {

    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Writer:写入字符流的抽象类
         * 常用方法：
         * 写入字符数组
         *  void write(char[] cbuf)
         * 写入字符数组的某一部分
         * abstract void write(char[] cbuf, int off, int len)
         * 写入单个字符
         * void write(int c)
         * 写入字符串
         * void write(String str)
         * 写入字符串的某一部分
         * void write(String str, int off, int len)
         *
         *  将指定字符添加到此 writer
         *  Writer append(char c)
         *  将指定字符序列添加到此 writer
         *  Writer append(CharSequence csq)
         *  将指定字符序列的子序列添加到此 writer.Appendable
         *  Writer append(CharSequence csq, int start, int end)
         *
         *  闭此流，但要先刷新它
         *  abstract void close()
         *  刷新该流的缓冲
         *  abstract void flush()
         */

        /**
         * OutputStreamWriter：字节流转字符流
         *
         *  构造方法：
         * 创建使用默认字符编码的 OutputStreamWriter
         * OutputStreamWriter(OutputStream out)
         * 创建使用给定字符集的 OutputStreamWriter
         * OutputStreamWriter(OutputStream out, Charset cs)
         * 创建使用给定字符集编码器的 OutputStreamWriter
         * OutputStreamWriter(OutputStream out, CharsetEncoder enc)
         * 创建使用指定字符集的 OutputStreamWriter
         * OutputStreamWriter(OutputStream out, String charsetName)
         *
         *  特有方法：
         * 返回此流使用的字符编码的名称
         * String getEncoding()
         */

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("G://javaTest/testIO_02.txt")));
        String str;


    }
}

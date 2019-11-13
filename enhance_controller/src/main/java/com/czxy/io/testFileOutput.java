package com.czxy.io;

import java.io.*;

public class testFileOutput {

    public static void main(String[] args) throws IOException {

        /**
         * 将 b.length 个字节从指定的 byte 数组写入此输出流
         *  void write(byte[] b)
         *
         * 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流
         *  void write(byte[] b, int off, int len)
         *
         * 将指定的字节写入此输出流
         *  abstract void write(int b)
         *
         * 关闭此输出流并释放与此流有关的所有系统资源
         *  void close()
         *
         * 刷新此输出流并强制写出所有缓冲的输出字节
         *  void flush()
         */

        /**
         * 输出的目的地文件不存在，则会自动创建，不指定盘符的话，默认创建在项目目录下;
         * 输出换行符时一定要写\r\n不能只写\n,因为不同文本编辑器对换行符的识别存在差异性。
         */
        //原数据会被覆盖
        OutputStream outputStream = new FileOutputStream(new File("G://javaTest/testIO_02.txt"));
        //写数据
        outputStream.write("ABC".getBytes());
        //关闭IO流
        outputStream.close();


        //内容追加，在原数据上进行追加
        OutputStream outputStream2 = new FileOutputStream("G://javaTest/testIO_02.txt",true);
        //输出换行符
        outputStream2.write("\r\n".getBytes());
        //输出追加内容
        outputStream2.write("hello".getBytes());
        //关闭流
        outputStream2.close();


    }
}

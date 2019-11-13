package com.czxy.io;

import java.io.*;

public class testBuffered {

    public static void main(String[] args) throws IOException {
        /**
         * 字符缓冲流（高效流）
         *创建一个 BufferedInputStream并保存其参数，即输入流in，以便将来使用。
         * BufferedInputStream(InputStream in)
         *
         * 创建具有指定缓冲区大小的 BufferedInputStream并保存其参数，即输入流in以便将来使用
         * BufferedInputStream(InputStream in, int size)
         */

        InputStream inputStream = new FileInputStream("G://javaTest/testIO_02.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bs = new byte[20];
        int len = 0;

        while ((len = bufferedInputStream.read(bs))!=-1){
            System.out.println(new String(bs,0,len));
        }

        //关流
        bufferedInputStream.close();
        inputStream.close();


        /**
         * BufferedOutputStream：字节缓冲输出流，提高了写出效率
         * 创建一个新的缓冲输出流，以将数据写入指定的底层输出流
         *  BufferedOutputStream(OutputStream out)
         *
         * 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流
         *  BufferedOutputStream(OutputStream out, int size)
         *
         * 常用方法：
         * 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此缓冲的输出流
         * void write(byte[] b, int off, int len)
         *
         * 将指定的字节写入此缓冲的输出流
         * void write(int b)
         *
         * 刷新此缓冲的输出流
         * void flush()
         */

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("G://javaTest/testIO_02.txt",true));

        //写入
        bufferedOutputStream.write("\r\n".getBytes());
        bufferedOutputStream.write("Hello Buffered".getBytes());
        //刷新此缓冲的输出流
        bufferedOutputStream.flush();
        //关闭流
        bufferedOutputStream.close();

    }

}

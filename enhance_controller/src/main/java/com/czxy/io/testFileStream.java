package com.czxy.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: liucan
 * @Date: 2019/11/19 15:32
 */
public class testFileStream {

    /**
     * 拷贝文件，一个一个字节的拷贝
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        FileInputStream fis=new FileInputStream("G://javaTest/file/file_1.txt");
        FileOutputStream fos=new FileOutputStream("G://javaTest/file/file_2.txt");
        int n;
        //这里面是n等于读取到的字节数，当读取到末尾时，返回的是-1，所以这里用！=-1来表示没有读到文件末尾
        while ((n=fis.read())!=-1){
            fos.write(n);
        }

        fos.close();
        fis.close();
    }

    /**
     * 拷贝视频：1024个字节1024个字节的拷贝
     * @throws IOException
     */
    @Test
    public void  test02() throws IOException {
        FileInputStream fis=new FileInputStream("G://javaTest/file/file_1.txt");
        FileOutputStream fos=new FileOutputStream("G://javaTest/file/file_2.txt");

        byte[] n=new byte[1024];
        int len;

        //这里是1024个字节的读取，所以在read（）里面放的是每次读取的字节数
        while ((len=fis.read(n))!=-1){
            fos.write(n,0,len);
        }

        fos.close();
        fis.close();
    }








}

package com.czxy.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: liucan
 * @Date: 2019/11/19 14:40
 */
public class testFile {


    /**
     * 创建文件、文件目录 createNewFile()、mkdir()
     * @throws IOException
     */
    @Test
    public void Test01() throws IOException {
        File file =new File("G://javaTest/file/file_2.txt");

        //判断文件目录是否存在，不存在就创建
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }else {
            System.out.println("文件路径已存在");
        }

        //判断文件是否存在，不存在就创建
        if(!file.exists()){
            file.createNewFile();
        }else {
            System.out.println("文件已存在");
        }

    }

    /**
     * 删除文件 、文件路径 delete()
     * 只会删除一级，如果当前目录下有文件则删除失败
     */
    @Test
    public void Test02(){
        File file =new File("G://javaTest/file/file_1.txt");
        //删除文件  如果删除的是路径，路径底下有文件则无法成功
        file.delete();

        if(!file.exists()){
            System.out.println("文件已被删除");
        }
        //删除目录
        File parentFile = file.getParentFile();
        parentFile.delete();
        System.out.println("删除成功");

    }


    /**
     *创建多个层级目录 mkdirs()
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        File file =new File("G://javaTest/file1/file2/file3/file_1.txt");
        //创建多个层级
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }else {
            System.out.println("创建多层目录成功:"+file.getParentFile());
        }

        //创建文件
        if(!file.exists()){
            file.createNewFile();
        }
    }


    /**
     *输出指定目录下的所有文件
     * list()   listFiles()
     * getAbsolutePath() 全路径
     */
    @Test
    public void test04(){
        File file =new File("G://javaTest/file");

        //获得指定目录下的所有文件
        String[] list = file.list();
        System.out.println("获得指定目录下的所有文件:");
        for(String str:list){
            System.out.println(str);
        }

        //获得指定目录下的所有文件信息
        File[] files = file.listFiles();
        System.out.println("获得指定目录下的所有文件信息:");
        for(File f:files){
            System.out.println(f.getName()+"-->"+f.getAbsolutePath());
        }
        
        //获得指定目录下的所有后缀为.txt文件
        System.out.println("获得指定目录下的所有后缀为.txt文件:");
        String[] list1 = file.list();
        for(String txt:list1){
            if(txt.endsWith(".txt")){
                System.out.println(txt);
            }
        }


    }








}

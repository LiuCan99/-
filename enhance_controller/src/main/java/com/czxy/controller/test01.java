package com.czxy.controller;

import com.czxy.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/user")
public class test01 {

    public static void main(String[] args) throws Exception{
        /**
         * 直接初始化，「正射」
         * 在未运行时就已经确定了要运行的类 User
         */
        User user = new User();
        user.setUsername("张三");
//        System.out.println(user);

        /**
         * 反射就是在运行时才知道要操作的类是什么，
         * 并且可以在运行时获取类的完整构造，并调用对应的方法。
         * 反射：开始并不知道我要初始化的类对象是什么，自然也无法使用 new 关键字来创建对象
         * 使用 JDK 提供的反射 API 进行反射调用
         * 运行时通过字符串值才得知要运行的类 com.czxy.domain.User
         */

        //使用反射获取一个对象的步骤：
        //1.获取类的 Class 对象实例 (全路径名)
        Class clz =Class.forName("com.czxy.domain.User");
        //使用 .class 方法(编译前就知道操作的 Class)
        Class clz2 = User.class;
        //使用类对象的 getClass() 方法
        User u=new User();
        Class clz3 = u.getClass();


        //2.根据 Class 对象实例获取 Constructor 对象
        Constructor constructor = clz.getConstructor();

        //3.使用 Constructor 对象的 newInstance 方法获取反射类对象
        Object object = constructor.newInstance();

        //调用方法步骤：
        //1.获取方法的 Method 对象
        Method method  = clz.getMethod("setUsername", String.class);

        //2.利用 invoke 方法调用方法
        method.invoke(object, "李四");
//        System.out.println(object);

        Method getUsername = clz.getMethod("getUsername");
        System.out.println("反射："+getUsername.invoke(object));


        /**
         * 通过反射创建类对象
         * 通过反射创建类对象主要有两种方式：
         *  1.通过 Class 对象的 newInstance() 方法、
         *  2.通过 Constructor 对象的 newInstance() 方法。
         *

         */

        //第一种：通过 Class 对象的 newInstance() 方法。
        Class user1 = User.class;
        Object obj1= user1.newInstance();

        //第二种：通过 Constructor 对象的 newInstance() 方法
        Class user2 = User.class;
        Constructor constructor2 = user2.getConstructor();
        Object  obj2 = constructor2.newInstance();


        /**
         * 例：
         * 通过 Constructor 对象创建类对象可以选择特定构造方法，
         * 而通过 Class 对象则只能使用默认的无参数构造方法。
         * 下面的代码就调用了一个有参数的构造方法进行了类对象的初始化。
         */

        Class cla = User.class;
        Constructor constructor1 = cla.getConstructor(Integer.class,String.class, String.class);
        Object obj3 = constructor1.newInstance(20, "王五", "1189");
        Method getUsername1 = cla.getMethod("getUsername");
        System.out.println(getUsername1.invoke(obj3));
    }

}

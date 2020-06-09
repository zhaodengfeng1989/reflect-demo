package com.zhaodf.javaBean;

import com.zhaodf.annotation.BookAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类：Book
 * @author zhaodf
 * @date 2020/6/9
 */
@BookAnnotation(value = "book类上注解")
public class Book implements IBook{
    @BookAnnotation(value = "Book类上author属性注解")
    private String author;
    private String name;
    protected String publisher;
    public boolean isFirst;

    //无参构造函数
    public Book() {
    }

    //有参构造函数
    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void buy(String name) {
        System.out.println("我买了一本书，名字叫"+name);
    }

    //私有方法
    private String publisher(String author){
        return "Electronic publishing house publishes the " + author + " book";
    }

    //内部类和内部接口
    public class A{}

    private class B{}

    public interface C{}

    private interface D{}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public static void main(String[] args){
        try {
            //================Class类相关方法===========================
//            Class<?> clazz = Class.forName("com.zhaodf.javaBean.Book");
//            Class<?> cartoonClazz = Class.forName("com.zhaodf.javaBean.CartoonBook");
//            System.out.println("simpleName为："+clazz.getSimpleName());
//            System.out.println("类的完成路径为："+clazz.getName());
//            System.out.println("加载clazz的类加载器为："+clazz.getClassLoader());//sun.misc.Launcher$AppClassLoader@14dad5dc
//            System.out.println("类的包："+clazz.getPackage());
//            System.out.println("类的父类："+clazz.getSuperclass());
//            System.out.println("类实现的接口："+clazz.getInterfaces()[0]);
//
//            IBook book = (Book) clazz.newInstance();
//            System.out.println("创建的类实例为："+book);
//            System.out.println("把对象转换为代表类或者接口的对象："+clazz.cast(book));
//            System.out.println("转换成子类："+cartoonClazz.asSubclass(clazz));
//
//            Class<?>[] declaredClasses = clazz.getDeclaredClasses();
//            for (int i = 0; i < declaredClasses.length; i++) {
//                System.out.println("对应的类中声明的内部类或者接口："+declaredClasses[i]);
//            }
//            Class<?>[] classes = clazz.getClasses();
//            for (int i = 0; i < classes.length; i++) {
//                System.out.println("对应的类中声明的公开内部类或者接口："+classes[i]);
//            }



              //======================属性Field类相关方法==================
//            Class<?> clazz = Class.forName("com.zhaodf.javaBean.Book");
//            Book book = (Book) clazz.newInstance();
//            book.setAuthor("zhaodf");
//            book.setName("Java 程序语言");
//            //获取类中声明的类的全部属性
//            Field[] declaredFields = clazz.getDeclaredFields();
//            for (int i = 0; i < declaredFields.length ; i++) {
//                System.out.println("获取类中声明的全部属性："+declaredFields[i]);
//            }
//            //获取公开的属性
//            Field[] fields = clazz.getFields();
//            for (int i = 0; i < fields.length ; i++) {
//                System.out.println("获取类中公开的属性："+fields[i]);
//            }
//
//            //获取类中声明的类的某个属性
//            Field declaredField = clazz.getDeclaredField("name");
//            System.out.println("获取类中声明的某个属性："+declaredField);
//
//            //获取类中声明的类的公开属性
//            Field publicField = clazz.getField("isFirst");
//            System.out.println("获取类中声明的某个公开属性："+publicField);
//
//            String name = (String)declaredField.get(book);
//            System.out.println("获取类中声明的某个属性的值："+name);
//
//            boolean isFirst = (boolean)publicField.get(book);
//            System.out.println("获取类中声明的某个属性的值："+isFirst);
//
//            System.out.println("获取类中声明的某个属性的修饰符："+publicField.getModifiers());
//
//            System.out.println("获取类中声明的某个属性的类型："+publicField.getType());

            //======================注解Annotation相关方法==================
            Class<?> clazz = Class.forName("com.zhaodf.javaBean.Book");
            boolean isExistOnClass = clazz.isAnnotationPresent(BookAnnotation.class);
            if(isExistOnClass){
                Annotation[] annotations = clazz.getAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    System.out.println("获取类上的所有公有注解"+annotations[i]);
                }
                Annotation annotation = clazz.getAnnotation(BookAnnotation.class);
                System.out.println("获取类上的某个注解，并获取值："+((BookAnnotation) annotation).value());
            }
            Field declaredField = clazz.getDeclaredField("author");
            boolean isExistOnField = declaredField.isAnnotationPresent(BookAnnotation.class);
            if(isExistOnField){
                Annotation[] annotations = declaredField.getAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    System.out.println("获取属性上的所有公有注解"+annotations[i]);
                }
                Annotation annotation = declaredField.getAnnotation(BookAnnotation.class);
                System.out.println("获取属性上的某个注解，并获取值："+((BookAnnotation) annotation).value());
            }

            //=======================Method的相关方法===================
//            Class<?> clazz = Class.forName("com.zhaodf.javaBean.Book");
//            Book book = (Book) clazz.newInstance();
//            book.setAuthor("zhaodf");
//            book.setName("Java 程序语言");
//            Method[] declaredMethods = clazz.getDeclaredMethods();
//            for (int i = 0; i <declaredMethods.length ; i++) {
//                System.out.println("获取类中声明的全部方法："+declaredMethods[i]);
//            }
//
//            Method[] methods = clazz.getMethods();
//            for (int i = 0; i <methods.length ; i++) {
//                System.out.println("获取类中声明的全部公开方法："+methods[i]);
//            }
//
//            Method declaredMethod = clazz.getDeclaredMethod("publisher",String.class);
//            System.out.println("获取类中声明的某个方法："+declaredMethod);
//
//            Method method = clazz.getMethod("setName",String.class);
//            System.out.println("获取类中声明的公开方法："+method);
//
//            //方法的调用
//            String publisherDesc = (String)declaredMethod.invoke(book,"zhanghl");
//            System.out.println("调用book对象的publisher方法："+publisherDesc);

              //===================Constructor构造器类相关方法===================
//            Class<?> clazz = Class.forName("com.zhaodf.javaBean.Book");
//            Constructor noArgsConstructor = clazz.getConstructor();
//            Book book = (Book) noArgsConstructor.newInstance();
//            book.setAuthor("zhaodf");
//            book.setName("Java 程序语言");
//            System.out.println("无参构造函数Constructor构造实例："+ book.getAuthor());
//
//            Constructor argsConstructor = clazz.getConstructor(String.class,String.class);
//            Book book1 = (Book)argsConstructor.newInstance("hanxb","C++ 语言");
//            System.out.println("有参构造函数Constructor构造实例："+book1.getAuthor());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

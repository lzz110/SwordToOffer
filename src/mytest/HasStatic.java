package mytest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HasStatic {
    //satement new variable name: studentName

    public static String studentName = "王燕";

    //satetment new variable nmae: country

    public static String country;

    //satement new variable name: nation

    private static String nation;

    //satement new variable name: subject

    public String subject = "物理";

    //satement new variable name: school

    private String school;

    //create main method

    private static int x=100;
   public static void main(String args[]){

       Queue<Integer> que2 = new PriorityQueue<Integer>();
       que2.add(11);
       que2.add(2);
       que2.add(14);
       que2.add(5);
       que2.add(7);

       while(que2.size()>0){
           System.out.print(" " + que2.poll());
       }
       System.out.println();

       //重写compare后
       que2=new PriorityQueue<>(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2.compareTo(o1);
           }
       });
       System.out.println("重写compare后-------");

       que2.add(11);
       que2.add(2);
       que2.add(14);
       que2.add(5);
       que2.add(7);
       while(que2.size()>0){
           System.out.print(" " + que2.poll());
       }
       System.out.println();

    }
    //create  new method name: Method_1()

    public void Method_1() {

        System.out.println("Method_1是一个公共的、非静态的方法");

        System.out.println("在非静态方法Method_1中访问静态成员变量“学生姓名”（studentName）:" + studentName);

        System.out.println("在method_1中直接调用非静态成员变量subject:" + subject);

    }
    private static  int f(int x) {
        int s=0;
        while(x-->0)   s+=f(x);
        return Math.max(s,1);
    }
    public static void doSomething(Integer integer){
        integer=new Integer(2);
    }

}


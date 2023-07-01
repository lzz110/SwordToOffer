package mytest;

/**
 * @author lzz
 * @version 1.0
 * @description: TODO
 * @date 2020/12/18 10:28
 */
public class MeinRef {
    private int x;
    public MeinRef(int val){
        this.x=val;
    }
    public void foo(int x,MeinRef ref){
        ref=new MeinRef(100);
        x+=200;
        this.x+=ref.x;
    }

    public static void main(String[] args) {
        MeinRef a=new MeinRef(10);
        MeinRef b=new MeinRef(20);
        int c=30;
        a.foo(c,b);
        System.out.println(a.x+" "+b.x+" "+c);
    }
}

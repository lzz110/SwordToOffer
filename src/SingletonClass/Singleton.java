package SingletonClass;

/**
 * @author lzz
 * @version 1.0
 * @description: TODO
 * @date 2020/9/10 14:36
 */
public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){};

    public static Singleton getinstance() {
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}

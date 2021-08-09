package singleton;

public class Singleton {
    /**
     * 懒汉式，延迟加载
     */
//    private static Singleton instance;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if(null == instance)
//            instance = new Singleton();
////        return instance;
//    }
    /**
     * 饿汉式，上来就创建实例，占用大量空间
      */
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}

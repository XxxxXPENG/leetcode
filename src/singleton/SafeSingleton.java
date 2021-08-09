package singleton;
//线程安全的单例模式
public class SafeSingleton {
    private static SafeSingleton instance;
    private SafeSingleton(){}

    //锁住类
//    public SafeSingleton getInstance(){
//        synchronized (SafeSingleton.class){
//            if(null == instance )
//                instance = new SafeSingleton();
//        }
//        return instance;
//    }
    //锁住方法
     public synchronized static SafeSingleton getInstance(){
        if(null == instance)
            instance =  new SafeSingleton();
        return instance;
    }
}

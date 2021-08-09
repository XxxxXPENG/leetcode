package singleton;
// Double Check Locking 双检查锁机制
public class DCL_Singleton {
    public volatile static DCL_Singleton instance; //volatile 保证多线程的可见性
    private  DCL_Singleton (){}
    public static DCL_Singleton getInstance(){
        if( null == instance){
            synchronized (DCL_Singleton.class){
                if( null == instance)
                    instance = new DCL_Singleton();
            }
        }
        return instance;
    }
}

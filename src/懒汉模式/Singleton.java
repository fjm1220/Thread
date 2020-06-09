package 懒汉模式;

/**
 * 这种安全但效率不高
 */
/*
 class Singleton {
    private static Singleton instance = null;
    private Singleton(){}
    public synchronized static Singleton getInstance(){
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
*/

class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null)
        {
            synchronized(Singleton.class){
                if(instance == null)
                {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
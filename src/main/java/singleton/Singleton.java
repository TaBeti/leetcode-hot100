package singleton;

/**
 * 饿汉式
 */
public class Singleton {
    //1.私有化构造方法
    private Singleton() {}

    //2.类加载时立刻实例化对象
    private static final Singleton instance = new Singleton();

    //3.提供全局访问点
    public static Singleton getInstance() {
        return instance;
    }
}

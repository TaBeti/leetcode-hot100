package singleton;

/**
 * 饿汉式
 */
/*public class Singleton {
    //1.私有化构造方法
    private Singleton() {}

    //2.类加载时立刻实例化对象
    private static final Singleton instance = new Singleton();

    //3.提供全局访问点
    public static Singleton getInstance() {
        return instance;
    }
}*/


/**
 * 懒汉式 - 线程不安全
 */
/*public class Singleton {
    private Singleton() {}
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/

/**
 * 懒汉式 - 线程安全
 */
/*
public class Singleton {
    private Singleton() {}
    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}*/

/**
 * 双重检查锁 DCL
 */
public class Singleton {
    private Singleton() {}

    // 必须使用 volatile 关键字修饰，防止指令重排
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        // 第一重检查：如果实例已经存在，直接返回，避免不必要的同步
        if (instance == null) {
            // 同步代码块
            synchronized (Singleton.class) {
                // 第二重检查：防止多个线程同时通过了第一重检查后重复创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 */
/*public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}*/

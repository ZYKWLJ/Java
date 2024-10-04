# 背景引出
对于一个软件系统的某些类而言，我们无须创建多个实例。举个大家都熟知的例子——Windows任务管理器

# 单例模式定义
单例模式(Singleton Pattern)：确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。单例模式是一种对象创建型模式。

# 单例模式三大步
(1)构造函数的可见性改为private
(2)在类中创建该单例类的静态私有变量
(3)在getInstance()方法里面对私有变量赋值

# 真实项目
## 负载均衡软件
Sunny软件公司承接了一个服务器负载均衡(Load Balance)软件的开发工作，该软件运行在一台负载均衡服务器上，可以将并发访问和数据流量分发到服务器集群中
的多台设备上进行并发处理，提高系统的整体处理能力，缩短响应时间。由于集群中的服务器需要动态删减，且客户端请求需要统一分发，因此需要确保负载均衡器的
唯一性，只能有一个负载均衡器来负责服务器的管理和请求的分发，否则将会带来服务器状态的不一致以及请求分配冲突等问题。如何确保负载均衡器的唯一性是该软件成功的关键。

## 具体实现
将负载均衡器LoadBalancer设计为单例类，其中包含一个存储服务器信息的集合serverList，每次在serverList中随机选择一台服务器来响应客户端的请求



版本一的问题：
# 多线程并发出现错误
现在我们对负载均衡器的实现代码进行再次分析，当第一次调用getLoadBalancer()方法创建并启动负载均衡器时，instance对象为null值，因此系统将执行代码
instance= new LoadBalancer()，在此过程中**，由于要对LoadBalancer进行大量初始化工作，需要一段时间来创建LoadBalancer对象**。而在此时，如果再一次
调用getLoadBalancer()方法（通常发生在多线程环境中），由于instance尚未创建成功，仍为null值，判断条件(instance== null)为真值，因此代码
instance= new LoadBalancer()将再次执行，导致最终创建了多个instance对象，这违背了单例模式的初衷，也导致系统运行发生错误。

# 解决方法
## 一、饿汉式单例与懒汉式单例的讨论
## (1)饿汉式单例类    
定义：在定义静态变量的时候实例化单例类，因此在类加载的时候就已经创建了单例对象
 ```java
   class EagerSingleton { 
       private static final EagerSingleton instance = new EagerSingleton(); 
       private EagerSingleton() { } 
    
       public static EagerSingleton getInstance() {
           return instance; 
       }   
   }
```



## (2)懒汉式单例类与线程锁定 ——延时加载
### 1.定义
**懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自行实例化**，这种技术又称为延迟加载(Lazy Load)技术，即需要的时候再加载实例，
为了避免多个线程同时调用getInstance()方法，我们可以使用关键字synchronized

### 2.锁住语句即可，降低线程开销
 public static LazySingleton getInstance() { 
     if (instance == null) {
         synchronized (LazySingleton.class) {
             instance = new LazySingleton(); 
         }
     }
     return instance; 
 }

### 3.双重检查锁定(Double-Check Locking) ————————这就是大名鼎鼎的DCL问题！！
### 问题 
上面的代码依然会出现问题，原因是进行if()判断时，没有双重锁定的话，依然会出现多个单例的情况。比如AB线程都判断了instance==null，A创建好对象之后
B获得了锁，依然会进入创建，U所以这里会多创建第一次判断了instance==null的线程数量的对象。

### 解决 ——双重锁定
```java
class LazySingleton { 
    private volatile static LazySingleton instance = null; 
 
    private LazySingleton() { } 
 
    public static LazySingleton getInstance() { 
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton(); //创建单例实例
                }
            }
        }
        return instance; 
    }
}

```
### 4.使用volatile确定共享变量即时刷新！！
保证可见性： 在没有volatile的情况下，某个线程创建了单例实例后，其他线程可能无法立即看到这个变化，因为线程之间对共享变量的更新操作可能会被缓存，
导致某些线程仍然认为instance是null。volatile关键字确保了当一个线程修改了instance的值后，其他线程能够立即看到这个变化，保证了多线程环境下的可见性。


## (3)饿汉式单例类与懒汉式单例类比较
饿汉式——资源浪费但多线程性能友好
懒汉式——资源节约但多线程性能有影响


# 一种更好的实现方式IoDH——静态内部类
## 问题引出
 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控制烦琐，而且性能受影响。
 可见，无论是饿汉式单例还是懒汉式单例都存在这样那样的问题，有没有一种方法，能够将两种单例的缺点都克服，而将两者的优点合二为一呢？答案是：Yes

## IoDH
 ### 定义：
 下面我们来学习这种更好的被称之为Initialization Demand Holder (IoDH)的技术。

   在IoDH中，我们在单例类中增加一个静态(static)内部类
```java
//Initialization on Demand Holder
class Singleton {
	private Singleton() {
	}
	
	private static class HolderClass {
            private final static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() { //这里由虚拟机来保证他的线程安全性！！！
	    return HolderClass.instance;
	}
	
	public static void main(String args[]) {
	    Singleton s1, s2; 
            s1 = Singleton.getInstance();
	    s2 = Singleton.getInstance();
	    System.out.println(s1==s2);
	}
}

```
## 性能说明
由于静态单例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton，第一次调用getInstance()时将加载内部类HolderClass，
在该内部类中定义了一个static类型的变量instance，此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。
由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响。

## 为什么IoDH天然保证延迟与线程安全 ？
### 延迟加载
  静态内部类的特点是：
  它不会随着外部类的加载而加载，只有在外部类的某个方法（如getInstance()）调用时，静态内部类才会被加载。
            

### 线程安全

**JVM的类加载机制**
JVM对类的加载、链接和初始化有明确的规范，**并且类的加载是线程安全的,由JVM来保证线程安全**具体来说，JVM在加载类时会保证：

每个类只会被加载一次。
类的加载过程是按需进行的，只有在首次使用类时，才会加载并初始化该类



# 最优秀的单例实现方法————枚举

## IoDH的问题 
IoDH不能避免克隆、反射和反序列化对单例模式的破坏。

## 枚举类的优点
利用枚举类，既可以避免多线程同步问题；还可以防止通过反射和反序列化来重新创建新的对象。

## 枚举类的定义
  枚举是在JDK1.5以及以后版本中增加的一个“语法糖”，它主要用于维护一些实例对象固定的类。例如一年有四个季节，就可以将季节定义为一个枚举类型，
  然后在其中定义春、夏、秋、冬四个季节的枚举类型的实例对象。

## 枚举类的原理
  因为Java虚拟机会保证枚举对象的唯一性，因此每一个枚举类型和定义的枚举变量在JVM中都是唯一的。如果使用了反射，会打破实例存在多个的原则，会报异常
  而且使用时财创建，有保证了延迟加载！













# 引出
我的笔记本电脑的工作电压是20V，而我国的家庭用电是220V，如何让20V的笔记本电脑能够在220V的电压下工作？答案是引入一个电源适配器(AC Adapter)，
俗称充电器或变压器，有了这个电源适配器，生活用电和笔记本电脑即可兼容. 在软件开发中，有时也存在类似这种不兼容的情况，我们也可以像引入一个电源适配器
一样引入一个称之为适配器的角色来协调这些存在不兼容的结构，这种设计方案即为适配器模式。

![img.png](img.png)

# 适配器模式

## 定义
适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。

## 分类
根据适配器类与适配者类的关系不同， 适配器模式可分为**对象适配器和类适配器**两种，在对象适配器模式中，**适配器与适配者之间是关联关系**；
在类适配器模式中，**适配器与适配者之间是继承（或实现）关系**。 在实际开发中，对象适配器的使用频率更高，对象适配器模式结构如图9-3所示：
![img_1.png](对象适配器.png)

## 组成角色

       ● Target（目标抽象类）：目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以是具体类。

       ● Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，适配器类是适配器模式的核心，在对象适配器中，
         它通过继承Target并关联一个Adaptee对象使二者产生联系。

       ● Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码。

典型的适配器类模式代码：

```java
class Adapter extends Target {
	private Adaptee adaptee; //维持一个对适配者对象的引用
	
	public Adapter(Adaptee adaptee) {
		this.adaptee=adaptee;
	}
	
	public void request() {
		adaptee.specificRequest(); //转发调用
	}
}
```

# 对象适配器
# 项目__没有源码的算法库

## 背景
       Sunny软件公司在很久以前曾开发了一个算法库，里面包含了一些常用的算法，例如排序算法和查找算法，在进行各类软件开发时经常需要重用该算法库中的算法。
       在为某学校开发教务管理系统时，开发人员发现需要对学生成绩进行排序和查找，该系统的设计人员已经开发了一个成绩操作接口ScoreOperation，在该接口中
       声明了排序方法sort(int[]) 和查找方法search(int[], int)，为了提高排序和查找的效率，开发人员决定重用算法库中的快速排序算法类QuickSort和二分查找算法类BinarySearch，
       其中QuickSort的quickSort(int[])方法实现了快速排序，BinarySearch 的binarySearch (int[], int)方法实现了二分查找。

       由于某些原因，现在Sunny公司开发人员已经找不到该算法库的源代码，无法直接通过复制和粘贴操作来重用其中的代码；部分开发人员已经针对ScoreOperation接口编程，
       如果再要求对该接口进行修改或要求大家直接使用QuickSort类和BinarySearch类将导致大量代码需要修改。

       Sunny软件公司开发人员面对这个没有源码的算法库，遇到一个幸福而又烦恼的问题：如何在既不修改现有接口又不需要任何算法库代码的基础上能够实现算法库的重用？

通过分析，我们不难得知，现在Sunny软件公司面对的问题有点类似本章最开始所提到的电压问题，成绩操作接口ScoreOperation好比只支持20V电压的笔记本，
而算法库好比220V的家庭用电， 这两部分都没有办法再进行修改，而且它们原本是两个完全不相关的结构，如图9-2所示：
![img_1.png](项目介绍.png)


## 使用适配器模式解决

![img_1.png](使用适配器模式解决.png)
上图中，ScoreOperation接口充当抽象目标，QuickSort和BinarySearch类充当适配者，OperationAdapter充当适配器。


## 总结

在本实例中使用了对象适配器模式，同时引入了配置文件，将适配器类的类名存储在配置文件中。如果需要使用其他排序算法类和查找算法类，可以增加一个新的适配器类，
使用新的适配器来适配新的算法，原有代码无须修改。通过引入配置文件和反射机制，可以在不修改客户端代码的情况下使用新的适配器，无须修改源代码，符合“开闭原则”。


# 类适配器
## 特点
上述的是对象适配器，还有一种类适配器，他们之间的区别在于适配器与适配者之间的关系不同，对象适配器与适配者之间是关联关系(依赖关系)。但是类适配器与适配者
之间是继承关系。
![img_1.png](类适配器.png)

典型代码：
```java
class Adapter extends Adaptee implements Target {
	public void request() {
		specificRequest();
	}
}
```

## 局限性
单继承性：
由于Java、C#等语言不支持多重类继承，因此类适配器的使用受到很多限制，例如如果目标抽象类Target不是接口，而是一个类，就无法使用类适配器；

最终类性：
此外，如果适配者Adaptee为最终(Final)类，也无法使用类适配器。在Java等面向对象编程语言中，大部分情况下我们使用的是对象适配器，类适配器较少使用。


# 双向适配器
## 定义
在对象适配器的使用过程中，**如果在适配器中同时包含对目标类和适配者类的引用**，适配者可以通过它调用目标类中的方法，目标类也可以通过它调用适配者类中的方法，
那么该适配器就是一个双向适配器
![img_1.png](双向适配器.png)

```java

class Adapter implements Target,Adaptee {
    //同时维持对抽象目标类和适配者的引用
	private Target target;
	private Adaptee adaptee;
	
	public Adapter(Target target) {
		this.target = target;
	}
	
	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	public void request() {
		adaptee.specificRequest();
	}
	
	public void specificRequest() {
		target.request();
	}
}
```
在实际开发中，我们很少使用双向适配器。



# 缺省适配器

## 定义
缺省适配器模式是适配器模式的一种变体，其应用也较为广泛。

缺省适配器模式的定义如下： 
缺省适配器模式(Default Adapter Pattern)：**当不需要实现一个接口所提供的所有方法时，可先设计一个抽象类实现该接口， 并为接口中每个方法提供一个默认实现（空方法）**，
那么**该抽象类的子类可以选择性地覆盖父类的某些方法来实现需求，它适用于不想使用一个接口中的所有方法的情况， 又称为单接口适配器模式**。

## 结构图
![img_1.png](缺省适配器.png)

## 组成

在缺省适配器模式中，包含如下三个角色：

      ● ServiceInterface（适配者接口）：它是一个接口，通常在该接口中声明了大量的方法。

      ● AbstractServiceClass（缺省适配器类）：它是缺省适配器模式的核心类，使用空方法的形式实现了在ServiceInterface接口中声明的方法。通常将它定义为抽象类，因为对它进行实例化没有任何意义。

      ● ConcreteServiceClass（具体业务类）：它是缺省适配器类的子类，在没有引入适配器之前，它需要实现适配者接口，因此需要实现在适配者接口中定义的所有方法，
        而对于一些无须使用的方法也不得不提供空实现。在有了缺省适配器之后，可以直接继承该适配器类，根据需要有选择性地覆盖在适配器类中定义的方法。



# 适配器模式总结

## 现实使用
适配器模式将现有接口转化为客户类所期望的接口，实现了对现有类的复用，它是一种使用频率非常高的设计模式，在软件开发中得以广泛应用，
在Spring等开源框架、驱动程序设计（如JDBC中的数据库驱动程序）中也使用了适配器模式。


## 主要优点

### 两者共同优点：
       (1) 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构。

       (2) 增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。

       (3) 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。

### 类适配器独有的优点

置换方法
    由于适配器类是适配者类的子类，因此可以在适配器类中置换一些适配者的方法，使得适配器的灵活性更强。

### 对象适配器独有的优点 

      (1) 一个对象适配器可以把多个不同的适配者适配到同一个目标；

      (2) 可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据“里氏代换原则”，适配者的子类也可通过该适配器进行适配。


### 类适配器缺点
类适配器模式的缺点如下：
（完全就是Java继承的局限性）

      (1) 对于Java、C#等不支持多重类继承的语言，**一次最多只能适配一个适配者类，不能同时适配多个适配者**；

      (2) 适配者类不能为最终类，如在Java中不能为final类，C#中不能为sealed类；

      (3) 在Java、C#等语言中，**类适配器模式中的目标抽象类只能为接口，不能为类**，其使用有一定的局限性。


## 适用场景
       (1) 系统需要使用一些现有的类，而这些类的接口（如方法名）不符合系统的需要**，甚至没有这些类的源代码**。

       (2) 想创建一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。

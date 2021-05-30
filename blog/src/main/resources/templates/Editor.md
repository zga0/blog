*首先声明：本人学生也还未毕业，一家之言，有什么错误欢迎大家指点，还有什么补充的也欢迎评论区写写！*


方法有两种abstract 和普通方法；abstract修饰的方法叫抽象方法，不需要方法体;

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210523201452893.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxODczMTQzMzgx,size_16,color_FFFFFF,t_70#pic_center)
如图，在eclipse中创建一个abstract class，其中定义一个抽象方法
，这个方法要是有方法体就会报错。



**1.interface中方法默认是抽象抽象方法，abstract class则相反**
（1）interface中的方法默认为abstract，即使你不加abstract修饰符他也是抽象方法，不能有方法体；但JDK1.8之前里面只能有抽象方法，不能有方法体的，但是1.8之后interface中的方法可以被default修饰（修饰之后就能有方法体），且能被实现这个接口的class继承带类体的方法。
```java
interface InterfaceA{
	public void sout(); 
	
	public default void soutDefault() {
		System.out.println("InterfaceA的soutDefault方法");
	};
}
class ClassA implements InterfaceA{
	@Override
	public void sout() {
		System.out.println("ClassA重写InterfaceA的sout方法");
	}
}

public class Test {
	public static void main(String[] args) {
		ClassA a = new ClassA();
		a.sout();
		a.soutDefault();
	}
}
```
<br><br>
![这个](https://img-blog.csdnimg.cn/20210523203607926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxODczMTQzMzgx,size_16,color_FFFFFF,t_70#pic_center)
这里可以看到class并没有soutDefault()方法，但还是执行了InterfaceA定义的default void soutDefault()方法体中的内容;
（2）然后就是abstract class中方法默认是有方法体的，只有加abstract修饰符才能定义抽象方法，值得注意的是，
（3）普通类没有抽象方法，如下图，普通类定义了抽象方法，eclipse就会直接语法检错，值得注意的是class不管是继承了抽象类还是实现了接口，都需要重写它们的抽象方法,抽象方法被定义出来就是被重写的。企业里面就是先定义接口或抽象类的抽象方法然后让你重写他的方法，实现里面方法体的内容（还未工作，以上是我的猜想）。


![在这里插入图片描述](https://img-blog.csdnimg.cn/2021052320464013.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxODczMTQzMzgx,size_16,color_FFFFFF,t_70#pic_center)
**2.interface中的变量修饰符默认就是public static fina**l 
即使你不写，变量也是这些修饰符；
![**在这里插入图片描述**](https://img-blog.csdnimg.cn/2021052322020787.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxODczMTQzMzgx,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210523220149239.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxODczMTQzMzgx,size_16,color_FFFFFF,t_70#pic_center)
如图，即使没有加static 变量还是可以通过interface名InterfaceA来访问字符串InterA，

经测试，即使没有加public修饰符也可以通过另外一个包（前提是InterfaceA需要被public修饰）访问InterfaceA的静态变量InterA；即使没有加final修饰符，这个变量也无法修改！（此处大家可以自行测试）![在这里插入图片描述](https://img-blog.csdnimg.cn/20210523221018198.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxODczMTQzMzgx,size_16,color_FFFFFF,t_70#pic_center)
而abstract class的变量声明创建规范和普通的class一样（mu'qian'me）；

**3.继承和实现的关系**
（1）接口只能被implements,或者extends另一个接口，就是说他的父类只能是接口。
（2）abstract class 则可以继承class，也可以实现implements接口，
（3）calss同abstract class

**4.实例化**
jdk1.8之前接口和抽象类都无法被实例化，但1.8增添了函数式接口和lambda表达式，也可以new.详情百度


<br>
综上述，abstract class就像是class和interface的一个中间产物。
没有interface那么抽象化，但也也具有interface的特性（可以定义抽象方法，无需具体的方法体，)这使得java更适应现实生活中的代码构筑。
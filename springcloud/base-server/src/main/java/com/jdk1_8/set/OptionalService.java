package com.jdk1_8.set;

import java.util.Optional;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 *  Optional 不是接口而是一个类，这是个用来防止NullPointerException异常的辅助类型
	Optional 被定义为一个简单的容器，其值可能是null或者不是null。
	在Java8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，不推荐你返回null而是返回Optional。
	这是一个可以为null的容器对象。
	如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * @Date: Created In 17:54 2018/8/31
 * @Modified By:
 */
public class OptionalService
{
	/**
	 * 创建Optional
	 */
	public static void create()
	{
		/*of方法 为非null的值创建一个Optional*/
		//of方法通过工厂方法创建Optional类。
		//需要注意的是，创建对象时传入的参数不能为null。
		//如果传入参数为null，则抛出NullPointerException
		Optional<String> data = Optional.of("11");
		System.out.println("创建出的Optional实例: " + data);
		/*ofNullable方法 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。*/
		//ofNullable与of方法相似，唯一的区别是可以接受参数为null的情况
		Optional<String> data1 = Optional.ofNullable(null);
		System.out.println("创建出的Optional实例: " + data1);
	}

	public static void isPresent()
	{
		Optional<String> data=Optional.of("1");
		System.out.println("Optional实例中是否有元素: " + data.isPresent());
		Optional<String> data1=Optional.of("");
		System.out.println("Optional实例中是否有元素: " + data1.isPresent());
		Optional<String> data2 = Optional.ofNullable(null);
		System.out.println("Optional实例中是否有元素: " + data2.isPresent());
	}

	/**
	 * 判断Optional中是否有元素，如果有则执行Consumer接口函数
	 */
	public static void ifPresent()
	{
		Optional<String> data = Optional.of("1");
		data.ifPresent(item -> System.out.println("Optional中元素为: " + item));
	}

	/**
	 * 如果有值则将其返回，否则返回指定的其它值
	 */
	public static void orElse()
	{
		Optional<String> data = Optional.ofNullable(null);
		System.out.println(data.orElse("返回其他信息"));
	}

	/**
	 * 如果有值则将其返回，否则按照自定义的Suplier函数返回其它值
	 */
	public static void orElseGet()
	{
		Optional<String> data = Optional.ofNullable(null);
		System.out.println(data.orElseGet(()->"函数返回的元素"));
	}

	/**
	 * 如果没有值就抛出指定异常
	 */
	public static void orThrow()
	{
		Optional<String> data = Optional.ofNullable(null);
		try
		{
			data.orElseThrow(Exception::new);
		}
		catch (Exception e)
		{
			System.out.println("catch到异常.");
		}
	}

	/**
	 * 如果创建的Optional对象中包含满足filter条件的数据，则返回该值的Optional对象，否则返回空值
	 */
	public static void filter()
	{
		Optional<String> data = Optional.ofNullable("123");
		System.out.println(data.filter(item -> item.length() > 3));
		//结合orElse使用
		System.out.println(data.filter(item -> item.length()> 3).orElse("4567"));
	}

	/**
	 * 如果Optional对象有值，则执行map转换操作
	 */
	public static void map()
	{
		Optional<String> data = Optional.ofNullable(null);
		System.out.println(data.map(item -> item.toUpperCase()).orElse("空值"));
	}

	/**
	 * 扁平化处理返回Optional对象
	 */
	public static void flatMap()
	{
		Optional<String> data = Optional.ofNullable("123");
		//扁平化为Optional类型
		Optional<String> newdata = data.flatMap(item -> Optional.ofNullable(item.toUpperCase()));
		System.out.println(newdata);
	}

	public static void main(String[] args)
	{
		create();
		isPresent();
		ifPresent();
		orElse();
		orElseGet();
		orThrow();
		filter();
		map();
		flatMap();
	}

}

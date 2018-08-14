package jdk1_8.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 16:21 2018/8/13
 * @Modified By:
 */
public class BaseOperateService
{
	/**
	 * 消费型接口示例
	 * @param consumer 消费接口
	 * @param count 消费次数
	 */
	public static void consumer(Consumer<Integer> consumer, int count)
	{
		consumer.accept(count);
	}

	/**
	 * 供给型接口示例
	 * @param supplier 供给接口
	 */
	public static void supply(Supplier<Integer> supplier)
	{
		System.out.println("获取数据:" + supplier.get());
	}

	/**
	 * 断言型接口示例
	 * @param predicate 断言接口
	 */
	public static void predicate(Predicate<Integer> predicate, int index)
	{
		System.out.println("满足要求:" + predicate.test(index));
	}

	/**
	 * 自定义函数式接口示例
	 * @param param 函数式接口
	 */
	public static void testFunc(TestFunc<String> func, String param)
	{
		System.out.println("是否ok:" + func.ok(param));
	}


	public static void main(String[] args)
	{
		//测试消费型接口
		consumer(count -> System.out.println("消费" + count + "次"), 10);

		//测试供给型接口
		supply(() -> (int)(Math.random()*100));

		//测试断言型接口
		predicate(index -> index > 2, 3);

		//测试函数式接口
		testFunc(param -> param != null, null);
	}


}

/**
 * 函数式接口
 */
@FunctionalInterface
interface TestFunc<T>
{
	boolean ok(T t);
}

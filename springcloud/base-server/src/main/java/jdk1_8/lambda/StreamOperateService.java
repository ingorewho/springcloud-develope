package jdk1_8.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 16:11 2018/8/13
 * @Modified By:
 */
public class StreamOperateService
{
	/**
	 * 创建Stream的几种方式
	 */
	public static void createStream()
	{
		//方式1：传入多个值的方式来创建
		Stream<String> stream = Stream.of("1", "2");
		//方式2：传入数组的方式来创建,可接受多个数组
		String[] array = new String[]{"1","2"};
		Stream<String> stream1 = Stream.of(array);
		//方式3：传入集合的方式来创建，可接受多个集合
		List<String> list = Arrays.asList(array);
		Stream<String> stream3 = list.stream();
	}

	/**
	 * Stream转换成其他类型
	 */
	public static void transferStream()
	{
		//转化成数组
		Stream stream = Stream.of("1","2");
		System.out.println(stream.toArray());
		//转化成集合
		stream = Stream.of("1","2");
		System.out.println(stream.collect(Collectors.toList()));
		//转化成String
		stream = Stream.of("1","2");
		System.out.println(stream.collect(Collectors.joining()).toString());
	}
	/**
	 * 测试Stream.forEach
	 * @param data 集合
	 */
	public static void streamForEach(List<String> data)
	{
		data.stream().forEach(item -> System.out.println(item));
	}

	/**
	 * 中间操作map将元素根据指定的Function接口来将元素转成另外的元素
	 * @param data .
	 */
	public static void streamMap(List<String> data)
	{
		List<String> result = data.stream().map(item -> item.toUpperCase()).collect(Collectors.toList());
		result.stream().forEach(item -> System.out.println(item));
	}

	/**
	 * 中间操作：flatMap用于处理一对多映射的关系
	 * 将多个流扁平化成一个流
	 */
	public static void streamFlatMap()
	{
		String[] str = new String[]{"123", "456"};
		List<String[]> result1 = Arrays.stream(str).map(item -> item.split("")).distinct().collect(Collectors.toList());
		result1.forEach(System.out::println);

		List<String> result2 = Arrays.stream(str).map(item->item.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		result2.forEach(System.out::println);
	}

	/**
	 * 中间操作filter用于过滤元素
	 * @param data .
	 */
	public static void streamFilter(List<String> data)
	{
		List<String> result = data.stream().filter(item -> item != null && !item.equals("test")).collect(Collectors.toList());
		result.forEach(item -> System.out.println(item));
	}

	/**
	 * 中断操作：peek，peek操作会返回一个stream，必须后面跟最终操作
	 */
	public static void streamPeek()
	{
		List<String> list = Arrays.asList("1","2");
		List<String> list2 =list.stream().peek(item ->System.out.println("中断")).collect(Collectors.toList());
		list2.forEach(System.out::println);
	}

	/**
	 * 中间操作：sort，sort操作会返回一个stream，必须后面跟最终操作
	 */
	public static void streamSort()
	{
		List<String> list = Arrays.asList("11","2", "3");
		//使用默认过滤方法
		list.stream().sorted().forEach(item -> System.out.println("sort:" + item));
		//自定义过滤方法
		list.stream().sorted((s1, s2) -> s1.length() - s2.length()).forEach(item -> System.out.println("sort: " + item));
	}

	/**
	 * Match 匹配
	 * Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。
	 * 所有的匹配操作都是最终操作，并返回一个boolean类型的值
	 */
	public static void streamMatch()
	{
		List<String> list = Arrays.asList("a","b", "c");
		boolean result = list.stream().anyMatch(item -> item.equals("a"));
		System.out.println("anyMatch: " + result);
		result = list.stream().allMatch(item -> item.equals("a"));
		System.out.println("allMatch: " + result);
	}

	/**
	 * 最终操作：count统计stream中的元素
	 */
	public static void streamCount()
	{
		List<String> list = Arrays.asList("a","b", "c");
		long count = list.stream().filter(item -> item.startsWith("a")).count();
		System.out.println("count: " + count);
	}

	/**
	 * 最终操作：允许通过指定的函数来将stream中的多个元素规约合并为一个元素
	 */
	public static void reduce()
	{
		//range不包含最后元素
		IntStream intStream = IntStream.range(1, 10);
		//指定初始值，将元素进行相加
		Integer result = intStream.reduce(0, (a, b) -> a+b);
		System.out.println("reduce: " + result);
		//一个Stream只能用一次
		intStream = IntStream.range(1, 10);
		//不指定初始值，这时会把 Stream 的前面两个元素组合起来，返回的是 Optional
		OptionalInt minInt = intStream.reduce((a, b) -> a < b ? a : b);
		System.out.println("reduce: " + minInt.getAsInt());
	}

	/**
	 * 中间操作：limit 返回 Stream 的前面 n 个元素；skip 则是跳过前 n 个元素只要后面的元素
	 */
	public static void streamLimitAndSkip()
	{
		Stream<String> stream = Stream.of("a", "b", "c");
		stream.limit(2).forEach(item -> System.out.println("limit: " + item));
		stream = Stream.of("a", "b", "c");
		stream.skip(2).forEach(item -> System.out.println("skip: " + item));
	}

	/**
	 * 	通过Supplier接口，可以自己来控制Stream的生成。这种情形通常用于随机数、常量的 Stream，
	 * 	或者需要前后元素间维持着某种状态信息的 Stream。把 Supplier 实例传递给 Stream.generate() 生成的 Stream，
	 * 	由于它是无限的，在管道中，必须利用limit之类的操作限制Stream大小。可以使用此方式制造出海量的测试数据
	 */
	public static void streamGenerate()
	{
		//生成100个随机数并打印
		Stream.generate(() -> (int)(Math.random()*100)).limit(100).forEach(item -> System.out.println("generate: " + item));
	}

	/**
	 * iterate 跟 reduce 操作很像，接受一个种子值，和一个 UnaryOperator（假设是 f）。
	 * 然后种子值成为 Stream 的第一个元素，f(seed) 为第二个，f(f(seed)) 第三个，
	 * f(f(f(seed))) 第四个,以此类推。
	 */
	public static void streamIterate()
	{
		Stream.iterate(1, n -> n + 2).limit(10).forEach(item -> System.out.println("iterate: " + item));
	}

	/**
	 * 双冒号地使用，将方法作为参数传入，流中每个元素都执行一遍该方法
	 * 书写方式：类名::方法名
	 */
	public static void doubleColon()
	{
		Stream<String> data = Stream.of("abc");
		List<String> result = data.map(String::toUpperCase).collect(Collectors.toList());
		result.forEach(System.out::println);
	}
	public static void main(String[] args)
	{
	    List<String> data = new ArrayList<>();
	    data.add("xiaoming");
	    data.add("lisan");
	    data.add("test");

	    //测试创建Stream
		createStream();

	    //测试Stream转化
		transferStream();
		//测试Stream.forEach
		streamForEach(data);
		//测试Stream.map
		streamMap(data);
		//测试Stream.flatMap
		streamFlatMap();
		//测试Stream.filter
		streamFilter(data);
		//测试Stream.peek
		streamPeek();
		//测试Stream.sort
		streamSort();
		//测试Stream.match
		streamMatch();
		//测试Stream.count
		streamCount();
		//测试reduce
		reduce();
		//测试limit和skip
		streamLimitAndSkip();
		//测试Stream.generate
		streamGenerate();
		//测试Stream.iterate
		streamIterate();
		//测试双冒号使用
		doubleColon();
	}

}

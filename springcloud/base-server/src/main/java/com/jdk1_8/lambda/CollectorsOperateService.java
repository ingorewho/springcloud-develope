package com.jdk1_8.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * 将流中的数据转成集合类型: toList、toSet、toMap、toCollection
   将流中的数据(字符串)使用分隔符拼接在一起：joining
   对流中的数据求最大值maxBy、最小值minBy、求和summingInt、求平均值averagingDouble
   对流中的数据进行映射处理 mapping
   对流中的数据分组：groupingBy、partitioningBy
   对流中的数据累计计算：reducing
 * @Date: Created In 11:57 2018/8/23
 * @Modified By:
 */
public class CollectorsOperateService
{
	public static void transfer()
	{
		List<String> datas = Arrays.asList("1", "2", "3");
		//转换成集合
		List<Integer> intList = datas.stream().map(item -> item.length()).collect(Collectors.toList());
		//转换成Map
		Map<String, Integer> map = datas.stream().collect(Collectors.toMap(key -> key, value-> value.length()));
		//转换成Set
		Set<String> set = datas.stream().collect(Collectors.toSet());
		//转换成TreeSet
		TreeSet<String> treeSet = datas.stream().collect(Collectors.toCollection(TreeSet::new));
	}

	/**
	 * 测试元素连接
	 */
	public static void join()
	{
		List<String> datas = Arrays.asList("1","2","3");
		String result = datas.stream().collect(Collectors.joining(","));
		System.out.println(result);

		result = datas.stream().collect(Collectors.collectingAndThen(Collectors.joining(","), item-> item+"d"));
		System.out.println(result);
	}

	/**
	 * Collectors分组操作
	 */
	public static void groupingBy()
	{
		List<String> dataList = Arrays.asList("1" , "12" , "3");
		Map<Integer, List<String>> groupDatas = dataList.stream().collect(Collectors.groupingBy(item -> item.length()));
		for (Map.Entry<Integer, List<String>> entry : groupDatas.entrySet())
		{
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	/**
	 * Collectors分割操作
	 */
	public static void partitingBy()
	{
		List<String> datas = Arrays.asList("1" , "2" , "31");
		Map<Boolean, List<String>> result = datas.stream().collect(Collectors.partitioningBy(s -> s.length() > 1));
		for (Map.Entry<Boolean, List<String>> entry : result.entrySet())
		{
			System.out.println("partiting: " + entry.getKey() + ":" + entry.getValue());
		}
	}

	/**
	 * Collectors求平均值
	 */
	public static void average()
	{
		List<String> datas = Arrays.asList("1" , "22" , "333");
		Double average = datas.stream().collect(Collectors.averagingDouble(item -> item.length()));
		System.out.println("average: " + average);
	}

	/**
	 * 测试聚合函数
	 */
	public static void converge()
	{
		List<Integer> datas = Arrays.asList(1, 2, 3);
		//求平均值
		double average = datas.stream().collect(Collectors.averagingDouble(x->x));
		System.out.println("平均值: " + average);
		//求最小值
		int min = datas.stream().collect(Collectors.collectingAndThen(Collectors.minBy((a, b) -> a - b), Optional::get));
		System.out.println("最小值: " + min);
		//求最大值
		int max = datas.stream().collect(Collectors.collectingAndThen(Collectors.maxBy((a, b) -> a - b), Optional::get));
		System.out.println("最大值: " + max);
	}

	/**
	 * 累计操作
	 */
	public static void reducing()
	{
		List<Integer> datas = Arrays.asList(1, 2, 3);
		int result = datas.stream().collect(Collectors.reducing(0, x -> x + 1, (sum, b) -> {
			return sum + b;}));
		System.out.println("汇总结果: " + result);
	}

	public static void main(String[] args)
	{
		//测试分组操作
//		groupingBy();
		//测试分割操作
//		partitingBy();
		//测试元素连接
//		join();
		//测试聚合函数
		converge();
		//测试累计函数
		reducing();
	}
}

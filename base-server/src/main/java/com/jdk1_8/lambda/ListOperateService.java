package com.jdk1_8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 16:11 2018/8/13
 * @Modified By:
 */
public class ListOperateService
{
	/**
	 * List.forEach
	 * @param data 集合
	 */
	public static void forEach(List<String> data)
	{
		data.forEach(item -> System.out.println(item));
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
	 * 中间操作filter用于过滤元素
	 * @param data .
	 */
	public static void streamFilter(List<String> data)
	{
		List<String> result = data.stream().filter(item -> item != null && !item.equals("test")).collect(Collectors.toList());
		result.forEach(item -> System.out.println(item));
	}



	public static void main(String[] args)
	{
	    List<String> data = new ArrayList<>();
	    data.add("xiaoming");
	    data.add("lisan");
	    data.add("test");

	    //测试List.forEach
		forEach(data);

		//测试Stream.forEach
		streamForEach(data);

		//测试Stream.map
		streamMap(data);

		//测试Stream.filter
		streamFilter(data);
	}

}

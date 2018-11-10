package com.jdk1_8.set;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:46 2018/8/30
 * @Modified By:
 */
public class CollectionUtilsService
{
	public static void isEmpty()
	{
		List<String> datas = null;
		System.out.println("集合是否为空: " + CollectionUtils.isEmpty(datas));
		datas = new ArrayList<>();
		System.out.println("集合是否为空: " + CollectionUtils.isEmpty(datas));
	}

	/**
	 * 判断集合是否不为空
	 */
	public static void isNotEmpty()
	{
		List<String> datas = null;
		System.out.println("集合是否不为空: " + CollectionUtils.isNotEmpty(datas));
		datas = new ArrayList<>();
		System.out.println("集合是否不为空: " + CollectionUtils.isNotEmpty(datas));
	}

	/**
	 * 判断两个集合是否相等
	 */
	public static void equals()
	{
		List<String> datas1 = Arrays.asList("1");
		List<String> datas2 = Arrays.asList("1", "2");
		System.out.println("两个集合是否相等: " + CollectionUtils.isEqualCollection(datas1, datas2));
	}
	/**
	 * 集合并集(会去重)
	 */
	public static void union()
	{
		List<String> datas1 = Arrays.asList("1");
		List<String> datas2 = Arrays.asList("1", "2");
		Collection result = CollectionUtils.union(datas1, datas2);
		System.out.println("求并集: " + result);
	}

	/**
	 * 求交集
	 */
	public static void intersection()
	{
		List<String> datas1 = Arrays.asList("1");
		List<String> datas2 = Arrays.asList("1", "2");
		System.out.println("求交集: " + CollectionUtils.intersection(datas1, datas2));
	}

	/**
	 * 判断两个集合是否有相同元素
	 */
	public static void containsAny()
	{
		List<String> datas1 = Arrays.asList("1");
		List<String> datas2 = Arrays.asList("1", "2");
		System.out.println("两个集合中有相同元素: " + CollectionUtils.containsAny(datas1, datas2));
	}

	/**
	 * 求交集的补集
	 */
	public static void disjunction()
	{
		List<String> datas1 = Arrays.asList("1");
		List<String> datas2 = Arrays.asList("1", "2");
		System.out.println("求交集的补集: " + CollectionUtils.disjunction(datas1, datas2));
	}

	/**
	 * 求差集
	 */
	public static void substract()
	{
		List<String> datas1 = Arrays.asList("1");
		List<String> datas2 = Arrays.asList("1", "2");
		//data1-data2
		System.out.println("求差集: " + CollectionUtils.subtract(datas1, datas2));
	}

	/**
	 * 得到一个不可修改集合
	 */
	public static void unmodifiable()
	{
		List<String> datas1 = Arrays.asList("1");
		Collection<String> unmodifiableList = CollectionUtils.unmodifiableCollection(datas1);
		unmodifiableList.add("2");
	}

	public static void main(String[] args)
	{
		isEmpty();
		isNotEmpty();
		equals();
		union();
		intersection();
		disjunction();
		substract();
//		unmodifiable();
		containsAny();
	}
}

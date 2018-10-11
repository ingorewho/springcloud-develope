package com.jdk1_8.set;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 10:47 2018/8/27
 * @Modified By:
 */
public class CollectionsService
{
	/**
	 * 计算集合中最小/大值
	 */
	public static void minAndMax()
	{
		List<Integer> datas = Arrays.asList(1, 2, 3);
		int min = Collections.min(datas);
		System.out.println("集合中最小值: " + min);
		int max = Collections.max(datas);
		System.out.println("集合中最大值: " + max);
	}

	/**
	 * 打乱集合元素顺序
	 */
	public static void shuffle()
	{
		List<Integer> datas = Arrays.asList(1, 2, 3);
		Collections.shuffle(datas);
		System.out.println("打乱顺序后的集合为: " + datas);
	}

	public static void nCopies()
	{
		int item = 1;
		List<Integer> datas = Collections.nCopies(10, item);
		System.out.println("拷贝后的集合: " + datas);
	}

	/**
	 * 对集合进行排序
	 */
	public static void sort()
	{
		List<Integer> datas = Arrays.asList(1, 2, 3);
		Collections.sort(datas, (a, b) -> b.compareTo(a));
		System.out.println("排序后集合: " + datas);
	}

	/**
	 * 拷贝并覆盖对应位置的元素
	 */
	public static void copy()
	{
		List<Integer> datas1 = Arrays.asList(3, 2, 1);
		List<Integer> datas2 = Arrays.asList(1, 2, 3, 4, 5);
		Collections.copy(datas2, datas1);
		System.out.println("被覆盖后的集合: " + datas2);
	}

	/**
	 * 二分查找法
	 * (使用binarySearch的二分法查找比indexOf遍历算法性能上高很多,特别是在大数据集而且目标值又接近尾部时)
	 */
	public static void binarySearch()
	{
		List<Integer> datas1 = Arrays.asList(3, 2, 1);
		System.out.println(Collections.binarySearch(datas1, 3));
	}

	/**
	 * 检查两个集合有无相同元素，有的话返回false
	 */
	public static void disJoint()
	{
		List<String> datas1 = Arrays.asList("1", "2", "3");
		List<String> datas2 = Arrays.asList("2", "3");
		System.out.println("两个集合是否有相同元素: " + Collections.disjoint(datas1, datas2));
	}

	/**
	 * 用指定元素替换集合中的所有元素
	 */
	public static void fill()
	{
		List<String> datas = Arrays.asList("1", "2", "3");
		Collections.fill(datas, "4");
		System.out.println("替换后的集合: " + datas);
	}

	/**
	 * 查询某个元素在集合中出现的次数
	 */
	public static void frequency()
	{
		List<String> datas = Arrays.asList("1", "2", "3");
		int num = Collections.frequency(datas, "1");
		System.out.println("元素1在集合中出现的次数: " + num);
	}

	/**
	 * 回指定源列表中第一次出现目标列表的起始位置
	 */
	public static void indexOfSubList()
	{
		List<String> datas1 = Arrays.asList("3", "2", "3");
		List<String> datas2 = Arrays.asList("3");
		System.out.println("第一次出现指定元素集合的位置是: " + Collections.indexOfSubList(datas1, datas2));
	}

	/**
	 * 回指定源列表中最后一次出现目标列表的起始位置
	 */
	public static void lastIndexOfSubList()
	{
		List<String> datas1 = Arrays.asList("3", "2", "3");
		List<String> datas2 = Arrays.asList("3");
		System.out.println("最后一次出现指定元素集合的位置是: " + Collections.lastIndexOfSubList(datas1, datas2));
	}

	/**
	 * 创建空集合/map/set
	 */
	public static void empty()
	{
		List<String> datas2 = Collections.emptyList();
		System.out.println("创建空集合: " + datas2);
		System.out.println("创建空map: " + Collections.emptyMap());
		System.out.println("创建空set: " + Collections.emptySet());
	}

	/**
	 * 得到检查容器的一个安全视图
	 */
	public static void checked()
	{
		List datas1 = Arrays.asList("1", "2", "3");
//		List<String> safeList = Collections.checkedList(datas1, String.class);
		List datas2 = datas1;
//		List datas3 = safeList;
		//程序执行如下代码会报错
//		datas3.add(11);
	}

	/**
	 * 反转集合中元素顺序
	 */
	public static void reverse()
	{
		List<String> datas = Arrays.asList("1", "2", "3");
		Collections.reverse(datas);
		System.out.println("反转后的集合: " + datas);
	}

	/**
	 * 替换目标集合中元素A成元素B
	 */
	public static void replaceAll()
	{
		List<String> datas = Arrays.asList("A", "B", "C");
		Collections.replaceAll(datas, "A", "B");
		System.out.println("替换后的集合: " + datas);
	}

	/**
	 * 指定一个目标集合以及两个元素的索引，交换这两个指定位置元素的值。
	 */
	public static void swap()
	{
		List<String> datas = Arrays.asList("A", "B", "C");
		Collections.swap(datas, 1, 2);
		System.out.println("替换位置后的集合: " + datas);
	}

	/**
	 * 将Collection转换为安全的Collection
	 */
	public static void sychronized()
	{
		List<String> datas1 = Arrays.asList("1", "2", "3");
		List<String> datas1sync = Collections.synchronizedList(datas1);
		System.out.println("安全集合: " + datas1sync);

		Map<String, String> maps1 = Maps.newHashMap();
		maps1.put("1", "2");
		Map<String, String> maps1sync = Collections.synchronizedMap(maps1);
		System.out.println("安全Map: " + maps1sync);
	}

	/**
	 * 定义不可修改的集合
	 */
	public static void unmodifiedList()
	{
		List<String> datas = Collections.unmodifiableList(Arrays.asList("1", "2", "3"));
		//下面操作会抛异常
		datas.add("4");
	}

	/**
	 * 1.返回一个不可变集只包含指定对象。
	 * 2.可用来清除集合中所有的指定元素
	 */
	public static void singleton()
	{
		//注意：Arrays.asList创建的集合不支持删除操作
		List<String> datas = new ArrayList<>(Arrays.asList("2", "2", "2"));
		//删除一个元素
		datas.remove("2");

		List<String> singleton = Collections.singletonList("2");
		datas.removeAll(singleton);
		System.out.println("single清除后的集合: " + datas);
	}

	/**
	 * 根据指定距离循环移动元素
	 */
	public static void rotate()
	{
		List<String> datas = Arrays.asList("1", "2", "3");
		Collections.rotate(datas, 2);
		System.out.println("循环移动后的集合: " + datas);
	}

	/**
	 * reverOrder生成Comparator比较器
	 */
	public static void reverOrder()
	{
		List<String> datas = Arrays.asList("1", "2", "3");
		Comparator c = Collections.reverseOrder();
		Collections.sort(datas, c);
		System.out.println("采用reverOrder比较器排序后的结果集: " + datas);
	}

	public static void main(String[] args)
	{
		minAndMax();
		shuffle();
		nCopies();
		sort();
		copy();
		binarySearch();
		disJoint();
		fill();
		frequency();
		indexOfSubList();
		lastIndexOfSubList();
		checked();
		reverse();
		replaceAll();
		swap();
		sychronized();
//		unmodifiedList();
		singleton();
		rotate();
		reverOrder();
	}
}


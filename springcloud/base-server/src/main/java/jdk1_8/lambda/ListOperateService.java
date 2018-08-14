package jdk1_8.lambda;

import java.util.ArrayList;
import java.util.List;

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


	public static void main(String[] args)
	{
	    List<String> data = new ArrayList<>();
	    data.add("1");
	    data.add("2");

	    //测试List.forEach
		forEach(data);

		//测试Stream.forEach
		streamForEach(data);
	}

}

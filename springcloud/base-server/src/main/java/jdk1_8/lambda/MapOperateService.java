package jdk1_8.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: rzq
 * @Description:
 * @Date: Created In 16:12 2018/8/13
 * @Modified By:
 */
public class MapOperateService
{
	public void forEach(Map<String, String> data)
	{
		data.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
	}


}

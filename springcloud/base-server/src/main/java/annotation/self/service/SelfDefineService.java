package annotation.self.service;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:44 2018/9/10
 * @Modified By:
 */
public class SelfDefineService
{
	public static void getAnnotation()
	{
		SelfDefineBean bean = new SelfDefineBean();
		//判断Class类是否包含某个类型的注解
		if(SelfDefineBean.class.isAnnotationPresent(SelfDefine.class))
		{
			SelfDefine annotation = SelfDefineBean.class.getAnnotation(SelfDefine.class);
			System.out.println("注解信息message:" + annotation.message());
		}
	}
}

package annotation.self.service;

import java.lang.annotation.*;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 15:33 2018/9/10
 * @Modified By:
 */
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SelfDefines
{
	SelfDefine[] value();
}

package com.ignore.annotation.spring.service;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:56 2018/9/17
 * @Modified By:
 */
public class MvcAnnoationService {
    /**
     * @Service用于标注业务层组件
     * @Controller用于标注控制层组件（如struts中的action）
     * @Repository用于标注数据访问组件，即DAO组件
     * @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
     */

    /**
     * @Autowired和@Resource对比:
     * 共同点:装配bean. 写在字段上,或写在setter方法
     * 不同点:
     *   @Autowired:
     *   1.默认按类型装配
     *   2.依赖对象必须存在，如果要允许null值，可以设置它的required属性为false  @Autowired(required=false)
     *   3.也可以使用名称装配，配合@Qualifier注解
     *
     *   @Resource:
     *   1.默认按名称进行装配，通过name属性进行指定
     *
     *   通俗讲：@Autowired自动注解，举个例子，一个类，俩个实现类，Autowired就不知道注入哪一个实现类，而Resource有name属性，可以区分。
     */

    /**
     * @Controller和@RestController对比:
     *  1.@Restcontroller是@Controller和@ResponseBody的结合体
     *  2.如果要返回JSON数据到页面上，则需要使用@RestController注解
     *  3.如果要配合视图解析器则
     */

}

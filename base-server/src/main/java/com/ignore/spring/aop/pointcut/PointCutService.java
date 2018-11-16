package com.ignore.spring.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: ignore1992
 * @Description: 1.切入点（pointcut）
 * 对连接点进行拦截的定义
 * 2.连接点（joinpoint）
 * 被拦截到的点，因为Spring只支持方法类型的连接点，所以在Spring中连接点指的就是被拦截到的方法，实际上连接点还可以是字段或者构造器
 * @Date: Created In 16:25 2018/9/25
 */
public class PointCutService {

    /**
     * Pointcut 是指那些方法需要被执行"AOP",是由"Pointcut Expression"来描述的.
     * Pointcut的定义包括两个部分：Pointcut表示式(expression)和Pointcut签名(signature)
     * Pointcut定义时，还可以使用&&、||、! 这三个运算
     * 1.execution用的最多
     * 格式:execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
     * 修饰符匹配（modifier-pattern?）
     * 返回值匹配（ret-type-pattern）可以为*表示任何返回值,全路径的类名等
     * 类路径匹配（declaring-type-pattern?）
     * 方法名匹配（name-pattern）可以指定方法名 或者 *代表所有, set* 代表以set开头的所有方法
     * 参数匹配（(param-pattern)）可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用“*”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(*,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型；可以用(..)表示零个或多个任意参数
     * 异常类型匹配（throws-pattern?）
     * 其中后面跟着“?”的是可选项
     */
    //pointcut表达式
    @Pointcut("execution(* com.ignore.spring.*..*.*(..))")
    //pointcut签名
    public void point1() {

    }

    /**
     * 2.with和@with用法
     * with:用于匹配连接点所在的Java类或者包，其所有方法都将被匹配
     *
     * @with: 用于匹配在类级使用了参数确定的注解的类，其所有方法都将被匹配
     */
    @Pointcut("within(com.ignore.spring..*)")
    public void point2() {

    }

    @Pointcut("@within(com.ignore.spring.aop.ClassAnnoation)")
    public void point3() {

    }

    /**
     * 3.@annotation用法
     * 匹配连接点被它参数指定的Annotation注解的方法。也就是说，所有被指定注解标注的方法都将匹配。
     */
    @Pointcut("@annotation(com.ignore.spring.aop.LogOutput)")
    public void point4() {

    }

    /**
     * 4.bean用法
     * 通过受管Bean的名字来限定连接点所在的Bean。该关键词是Spring2.5新增的。
     */
    @Pointcut("bean(BaseBizServiceImpl)")
    public void point5() {

    }

    /**
     * 5.this用法
     * 实现指定接口的代理对象的任意连接点 （在 Spring AOP 中只是方法执行）
     */
    @Pointcut("this(com.ignore.spring.aop.sevice.BaseBizService)")
    public void point6() {

    }

    /**
     * 6.target用法
     * 实现指定接口的目标对象的任意连接点（在 Spring AOP 中只是方法执行）
     */
    @Pointcut("target(com.ignore.spring.aop.sevice.BaseBizService)")
    public void point7() {

    }

    /**
     * 7.args用法
     * 匹配传入指定类型参数的任意连接点（在 Spring AOP 中只是方法执行）
     */
    @Pointcut("args(String,int)")
    public void point8() {
    }
}
